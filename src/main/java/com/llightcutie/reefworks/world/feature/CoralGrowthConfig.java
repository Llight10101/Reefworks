package com.llightcutie.reefworks.world.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

import java.util.List;

public class CoralGrowthConfig implements FeatureConfiguration {

    // --- structural identity of a reef colony ---
    public enum StructureType {
        DOME,
        SPIRE,
        CLUSTER,
        BRANCH;

        public static final Codec<StructureType> CODEC = Codec.STRING.xmap(
                s -> StructureType.valueOf(s.trim().toUpperCase()),
                StructureType::name
        );
    }

    // --- weighted growth profile (how reefs decide what they become) ---
    public record WeightedStructure(StructureType type, int weight) {

        public static final Codec<WeightedStructure> CODEC = RecordCodecBuilder.create(instance ->
                instance.group(
                        StructureType.CODEC.fieldOf("type").forGetter(WeightedStructure::type),
                        Codec.INT.fieldOf("weight").forGetter(WeightedStructure::weight)
                ).apply(instance, WeightedStructure::new)
        );
    }

    // --- reef composition definition (what this colony is made of) ---
    public static final Codec<CoralGrowthConfig> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    BuiltInRegistries.BLOCK.byNameCodec().fieldOf("coral_block").forGetter(c -> c.coralBlock),
                    BuiltInRegistries.BLOCK.byNameCodec().fieldOf("coral_plant").forGetter(c -> c.coralPlant),
                    BuiltInRegistries.BLOCK.byNameCodec().fieldOf("coral_fan").forGetter(c -> c.coralFan),
                    BuiltInRegistries.BLOCK.byNameCodec().fieldOf("coral_wall_fan").forGetter(c -> c.coralWallFan),
                    WeightedStructure.CODEC.listOf().fieldOf("structures").forGetter(c -> c.structures)
            ).apply(instance, CoralGrowthConfig::new)
    );

    // --- reef material palette ---
    public final Block coralBlock;
    public final Block coralPlant;
    public final Block coralFan;
    public final Block coralWallFan;

    // --- possible growth forms this reef can take ---
    public final List<WeightedStructure> structures;

    public CoralGrowthConfig(
            Block coralBlock,
            Block coralPlant,
            Block coralFan,
            Block coralWallFan,
            List<WeightedStructure> structures
    ) {
        this.coralBlock = coralBlock;
        this.coralPlant = coralPlant;
        this.coralFan = coralFan;
        this.coralWallFan = coralWallFan;
        this.structures = structures;
    }

    // --- determines what kind of structure this colony expresses ---
    public StructureType pickStructure(RandomSource random) {
        int totalGrowthWeight = structures.stream()
                .mapToInt(WeightedStructure::weight)
                .sum();

        if (totalGrowthWeight <= 0) {
            return StructureType.DOME;
        }

        int roll = random.nextInt(totalGrowthWeight);
        int accumulated = 0;

        for (WeightedStructure structure : structures) {
            accumulated += structure.weight();

            if (roll < accumulated) {
                return structure.type();
            }
        }

        return StructureType.DOME;
    }
}