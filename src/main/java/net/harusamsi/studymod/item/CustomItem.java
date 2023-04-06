package net.harusamsi.studymod.item;

import net.harusamsi.studymod.RegisterItems;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class CustomItem extends Item {

    public CustomItem(Settings settings) {
        super(settings);
    }

    // 사용 시 아이템 사운드
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.playSound(SoundEvents.BLOCK_WOOL_BREAK, 1.0F, 1.0F);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }

    // 아이템 툴팁 추가
    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        // 기본 흰 텍스트 툴팁
        tooltip.add(Text.translatable("item.studymod.custom_item.tooltip1"));
        // 빨간 텍스트 툴팁
        tooltip.add(Text.translatable("item.studymod.custom_item.tooltip2").formatted(Formatting.RED));

        // 아이템 클래스뿐만 아니라 블럭 클래스에도 툴팁이 가능하다
        // 함수: public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext);
    }

    public static class CustomToolMaterial implements ToolMaterial {
        public static final CustomToolMaterial INSTANCE = new CustomToolMaterial();

        @Override
        public int getDurability() {
            return 500;
        }
        // 내구도

        @Override
        public float getMiningSpeedMultiplier() {
            return 10.0F;
        }
        // 채광속도 : 나무-2.0F, 다이아-5.0F

        @Override
        public float getAttackDamage() {
            return 0F;
        }
        // 생성자 atkdmg + 위 함수 atkdmg + 1로 데미지 계산
        // 생성자에서 데미지 컨트롤을 위해 0F로 고정

        @Override
        public int getMiningLevel() {
            return 3;
        }
        // 다이아 채광레벨 3, 옵시디언 요구 채광레벨 3+

        @Override
        public int getEnchantability() {
            return 7;
        }
        // 인첸트 성능 / 금: 22, 다이아: 10 / 수치 높을수록 더 높은 인첸트 붙음

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(RegisterItems.CUSTOM_MATERIAL);
        }
        // 수리 재료
    }
}
