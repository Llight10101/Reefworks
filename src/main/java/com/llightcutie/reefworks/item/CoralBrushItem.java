package com.llightcutie.reefworks.item;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.BrushItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class CoralBrushItem extends BrushItem {

    private static final int BRUSH_DURATION = 60;

    public CoralBrushItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);

        if (isVanillaCoral(state, level)) {
            Player player = context.getPlayer();
            if (player != null) {
                player.startUsingItem(context.getHand());
            }
            return InteractionResult.CONSUME;
        }

        Player player = context.getPlayer();
        if (player != null && this.calculateHitResult(player).getType() == HitResult.Type.BLOCK) {
            player.startUsingItem(context.getHand());
        }
        return InteractionResult.CONSUME;
    }

    @Override
    public void onUseTick(Level level, LivingEntity entity, ItemStack stack, int remainingUseTicks) {
        if (!(entity instanceof Player player)) return;

        HitResult hitResult = calculateHitResult(player);
        if (!(hitResult instanceof BlockHitResult blockHitResult) || hitResult.getType() != HitResult.Type.BLOCK) {
            entity.releaseUsingItem();
            return;
        }

        BlockPos pos = blockHitResult.getBlockPos();
        BlockState state = level.getBlockState(pos);

        if (!isVanillaCoral(state, level)) {
            super.onUseTick(level, entity, stack, remainingUseTicks);

            return;
        }

        int ticksUsed = getUseDuration(stack, entity) - remainingUseTicks;

        if (ticksUsed >= BRUSH_DURATION) {
            if (!level.isClientSide) {
                Item sample = getSample(state, level);
                if (sample != null) {
                    stack.hurtAndBreak(1, entity, EquipmentSlot.MAINHAND);
                    player.addItem(new ItemStack(sample));
                }
            }
            entity.releaseUsingItem();
        }
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 200;
    }

    private HitResult calculateHitResult(Player player) {
        return ProjectileUtil.getHitResultOnViewVector(
                player,
                e -> !e.isSpectator() && e.isPickable(),
                player.blockInteractionRange()
        );
    }

    private Item getSample(BlockState state, Level level) {

        if (level.random.nextFloat() > 0.25f) {
            return ModItems.BLEACHED_CORAL_FRAGMENT;
        }

        Block block = state.getBlock();

        if (block == Blocks.TUBE_CORAL_BLOCK)
            return ModItems.TUBE_POLYP_SAMPLE.asItem();
        if (block == Blocks.BRAIN_CORAL_BLOCK)
            return ModItems.BRAIN_POLYP_SAMPLE.asItem();
        if (block == Blocks.BUBBLE_CORAL_BLOCK)
            return ModItems.BUBBLE_POLYP_SAMPLE.asItem();
        if (block == Blocks.FIRE_CORAL_BLOCK)
            return ModItems.FIRE_POLYP_SAMPLE.asItem();
        if (block == Blocks.HORN_CORAL_BLOCK)
            return ModItems.HORN_POLYP_SAMPLE.asItem();

        return null;
    }

    private boolean isVanillaCoral(BlockState state, Level level) {
        Block block = state.getBlock();

        return block.defaultBlockState().is(BlockTags.CORAL_BLOCKS);
    }
}