package net.harusamsi.studymod.item;

import net.harusamsi.studymod.entity.projectile.CustomArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.world.World;

public class CustomArrow extends ArrowItem {
    public CustomArrow(Item.Settings settings) {
        super(settings);
    }

    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
        CustomArrowEntity customArrowEntity = new CustomArrowEntity(world, shooter);
        customArrowEntity.initFromStack(stack);
        return customArrowEntity;
    }
}
