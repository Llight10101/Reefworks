package com.llightcutie.reefworks;

import com.llightcutie.reefworks.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public class ReefworksModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TUBE_POLYP_SAMPLE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BRAIN_POLYP_SAMPLE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BUBBLE_POLYP_SAMPLE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FIRE_POLYP_SAMPLE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HORN_POLYP_SAMPLE, RenderType.cutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEAD_TUBE_POLYP_SAMPLE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEAD_BRAIN_POLYP_SAMPLE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEAD_BUBBLE_POLYP_SAMPLE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEAD_FIRE_POLYP_SAMPLE, RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEAD_HORN_POLYP_SAMPLE, RenderType.cutout());
    }
}