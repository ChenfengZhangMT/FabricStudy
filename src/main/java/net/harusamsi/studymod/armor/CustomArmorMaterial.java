package net.harusamsi.studymod.armor;

import net.harusamsi.studymod.RegisterItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class CustomArmorMaterial implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
    private static final int A = 1, B = 2, C = 3, D = 1;
    private static final int[] PROTECTION_VALUES = new int[] {A, B, C, D};
    // A: boots / B: leggings / C: chestplate / D: helmet
    // leather: {1, 2, 3, 1}
    // Diamond/Netherite: {3, 6, 8, 3}


    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * 1;
    }
    // 내구도 (부서지기 전 히트수)

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }
    // 위 PROTECTION_VALUES 부름, 방어력

    @Override
    public int getEnchantability() {
        return 1;
    }
    // 아머 레벨 및 다중 인첸트

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_CHAIN;
    }
    // 장착 사운드

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(RegisterItems.CUSTOM_MATERIAL);
    }
    // 수리 재료

    @Override
    public String getName() {
        // 소문자만 가능
        return "custom";
    }
    // 방어구 재료 이름 (예: diamond)

    @Override
    public float getToughness() {
        return 1.0F;
    }
    // 내구도 이상의 데미지를 입었을 때 두번째 방어력
    // 방어 강도: 1.0F당 +1

    @Override
    public float getKnockbackResistance() {
        return 0.3F;
    }
    // 넉백 저항: 0.1F당 +1
}
