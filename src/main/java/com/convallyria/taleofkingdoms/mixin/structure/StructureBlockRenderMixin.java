package com.convallyria.taleofkingdoms.mixin.structure;

import net.minecraft.client.renderer.blockentity.StructureBlockRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = StructureBlockRenderer.class, priority = 999) // Carpet support - let it control render distance
public class StructureBlockRenderMixin {

    /**
     * @reason Increase the distance that the bounding box can be seen up to 256 blocks
     * @author SamB440/Cotander
     */
    @ModifyConstant(method = "getRenderDistance", constant = @Constant(intValue = 96), require = 0)
    @OnlyIn(Dist.CLIENT)
    public int getRenderDistance(int value) {
        return 256;
    }
}
