package com.llightcutie.reefworks.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

import java.util.ArrayList;
import java.util.List;

public class CoralGrowthFeature extends Feature<CoralGrowthConfig> {

    public CoralGrowthFeature(Codec<CoralGrowthConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<CoralGrowthConfig> context) {

        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();
        CoralGrowthConfig config = context.config();

        CoralGrowthConfig.StructureType form = config.pickStructure(random);

        return switch (form) {
            case DOME -> placeDome(level, origin, random, config);
            case SPIRE -> placeSpire(level, origin, random, config);
            case CLUSTER -> placeCluster(level, origin, random, config);
            case BRANCH -> placeBranch(level, origin, random, config);
        };
    }

    // seabed tracing (locates where reef growth can anchor)
    private int traceSeabed(WorldGenLevel level, BlockPos origin, int x, int z) {
        for (int y = 0; y >= -5; y--) {
            BlockPos check = origin.offset(x, y, z);

            if (!level.getBlockState(check).is(Blocks.WATER)) {
                return origin.getY() + y + 1;
            }
        }

        return origin.getY();
    }

    // local environmental check (can this point sustain growth?)
    private boolean isSustainedByWater(WorldGenLevel level, BlockPos pos) {

        boolean touchesWater = false;
        boolean touchesSolid = false;

        for (Direction dir : Direction.values()) {
            BlockState nearby = level.getBlockState(pos.relative(dir));

            if (nearby.is(Blocks.WATER)) {
                touchesWater = true;
            }

            if (!nearby.isAir() && !nearby.is(Blocks.WATER)) {
                touchesSolid = true;
            }
        }

        return touchesWater && touchesSolid;
    }

    // commit phase (materializes reef growth into the world)
    private boolean commitGrowth(
            WorldGenLevel level,
            List<BlockPos> positions,
            CoralGrowthConfig config,
            RandomSource random,
            boolean requireSupport
    ) {

        boolean anyPlaced = false;

        for (BlockPos pos : positions) {

            boolean valid = requireSupport
                    ? isSustainedByWater(level, pos)
                    : level.getBlockState(pos).is(Blocks.WATER);

            if (valid) {
                level.setBlock(pos, config.coralBlock.defaultBlockState(), 3);
                anyPlaced = true;
            }
        }

        for (BlockPos pos : positions) {
            if (requireSupport && !isSustainedByWater(level, pos)) {
                level.setBlock(pos, Blocks.WATER.defaultBlockState(), 3);
            }
        }

        for (BlockPos pos : positions) {
            applySurfaceLife(level, pos.above(), random, config);
        }

        return anyPlaced;
    }

    // dome growth form
    private boolean placeDome(WorldGenLevel level, BlockPos origin, RandomSource random, CoralGrowthConfig config) {

        List<BlockPos> growth = new ArrayList<>();
        int radius = 3;

        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {

                int seabed = traceSeabed(level, origin, x, z);

                for (int y = 0; y <= radius; y++) {

                    double dist = Math.sqrt(x * x + y * y + z * z);

                    if (dist < radius - 1 || dist > radius) continue;
                    if (random.nextFloat() < 0.4f) continue;

                    BlockPos pos = new BlockPos(
                            origin.getX() + x,
                            seabed + y,
                            origin.getZ() + z
                    );

                    if (level.getBlockState(pos).is(Blocks.WATER)) {
                        growth.add(pos);
                    }
                }
            }
        }

        return commitGrowth(level, growth, config, random, true);
    }

    // spire growth form
    private boolean placeSpire(WorldGenLevel level, BlockPos origin, RandomSource random, CoralGrowthConfig config) {

        List<BlockPos> growth = new ArrayList<>();

        for (int x = -2; x <= 2; x++) {
            for (int z = -2; z <= 2; z++) {

                if (Math.abs(x) == 2 && Math.abs(z) == 2) continue;
                if (random.nextFloat() < 0.35f) continue;

                int seabed = traceSeabed(level, origin, x, z);

                int distance = Math.abs(x) + Math.abs(z);

                int height =
                        distance == 0 ? 5 + random.nextInt(3) :
                                distance <= 2 ? 2 + random.nextInt(2) :
                                        1;

                for (int y = 0; y < height; y++) {

                    BlockPos pos = new BlockPos(
                            origin.getX() + x,
                            seabed + y,
                            origin.getZ() + z
                    );

                    if (level.getBlockState(pos).is(Blocks.WATER)) {
                        growth.add(pos);
                    }
                }
            }
        }

        return commitGrowth(level, growth, config, random, true);
    }

    // cluster growth form
    private boolean placeCluster(WorldGenLevel level, BlockPos origin, RandomSource random, CoralGrowthConfig config) {

        List<BlockPos> growth = new ArrayList<>();

        int nodes = 3 + random.nextInt(3);

        for (int i = 0; i < nodes; i++) {

            int ox = random.nextInt(5) - 2;
            int oz = random.nextInt(5) - 2;
            int baseHeight = 1 + random.nextInt(3);

            for (int x = -1; x <= 1; x++) {
                for (int z = -1; z <= 1; z++) {

                    if (random.nextFloat() < 0.3f) continue;

                    int ax = ox + x;
                    int az = oz + z;

                    int seabed = traceSeabed(level, origin, ax, az);

                    int height = Math.max(1, baseHeight - (Math.abs(x) + Math.abs(z)));

                    for (int y = 0; y < height; y++) {

                        BlockPos pos = new BlockPos(
                                origin.getX() + ax,
                                seabed + y,
                                origin.getZ() + az
                        );

                        if (level.getBlockState(pos).is(Blocks.WATER)) {
                            growth.add(pos);
                        }
                    }
                }
            }
        }

        return commitGrowth(level, growth, config, random, true);
    }

    // branch growth form
    private boolean placeBranch(WorldGenLevel level, BlockPos origin, RandomSource random, CoralGrowthConfig config) {

        List<BlockPos> growth = new ArrayList<>();

        int seabed = traceSeabed(level, origin, 0, 0);
        int trunkHeight = 1 + random.nextInt(3);

        // trunk emergence
        for (int y = 0; y < trunkHeight; y++) {
            BlockPos pos = new BlockPos(origin.getX(), seabed + y, origin.getZ());

            if (level.getBlockState(pos).is(Blocks.WATER)) {
                growth.add(pos);
            }
        }

        // branching extension
        int branches = 2 + random.nextInt(3);
        Direction[] directions = Direction.Plane.HORIZONTAL.stream().toArray(Direction[]::new);

        for (int i = 0; i < branches; i++) {

            Direction dir = directions[random.nextInt(directions.length)];
            int length = 2 + random.nextInt(3);

            int bx = origin.getX();
            int by = seabed + trunkHeight - 1;
            int bz = origin.getZ();

            for (int step = 0; step < length; step++) {

                by += 1;

                if (step % 3 != 2 || random.nextFloat() < 0.3f) {
                    bx += dir.getStepX();
                    bz += dir.getStepZ();
                }

                BlockPos pos = new BlockPos(bx, by, bz);

                if (level.getBlockState(pos).is(Blocks.WATER)) {
                    growth.add(pos);
                }
            }
        }

        return commitGrowth(level, growth, config, random, false);
    }

    // surface life emergence (plants + wall fans)
    private void applySurfaceLife(WorldGenLevel level, BlockPos pos, RandomSource random, CoralGrowthConfig config) {

        if (level.getBlockState(pos).is(Blocks.WATER)
                && level.getBlockState(pos.below()).is(config.coralBlock)
                && random.nextFloat() < 0.5f) {

            level.setBlock(pos, config.coralPlant.defaultBlockState(), 3);
        }

        BlockPos base = pos.below();

        for (Direction dir : Direction.Plane.HORIZONTAL) {

            BlockPos side = base.relative(dir);
            BlockPos back = side.relative(dir.getOpposite());

            if (level.getBlockState(side).is(Blocks.WATER)
                    && level.getBlockState(back).is(config.coralBlock)
                    && random.nextFloat() < 0.25f) {

                BlockState fan = config.coralWallFan
                        .defaultBlockState()
                        .setValue(BlockStateProperties.HORIZONTAL_FACING, dir);

                level.setBlock(side, fan, 3);
            }
        }
    }
}