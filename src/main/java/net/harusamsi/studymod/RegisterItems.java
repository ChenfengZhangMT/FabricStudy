package net.harusamsi.studymod;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.harusamsi.studymod.armor.CustomArmorMaterial;
import net.harusamsi.studymod.block.*;
import net.harusamsi.studymod.block.entity.DemoBlockEntity;
import net.harusamsi.studymod.item.CustomArrow;
import net.harusamsi.studymod.item.CustomMaterialItem;
import net.harusamsi.studymod.item.CustomItem;
import net.harusamsi.studymod.item.CustomBow;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RegisterItems {
    // 아이템 추가
    public static final Item CUSTOM_ITEM = Registry.register(
            Registries.ITEM,
            new Identifier("studymod", "custom_item"),
            new CustomItem(new FabricItemSettings().maxCount(16))
    );

    private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder(new Identifier("studymod", "test_group"))
            .icon(() -> new ItemStack(CUSTOM_ITEM))
            .build();

    
    // 방어구 추가
    public static final ArmorMaterial CUSTOM_ARMOR_MATERIAL = new CustomArmorMaterial();
    public static final Item CUSTOM_MATERIAL = new CustomMaterialItem(new FabricItemSettings());
    public static final Item CUSTOM_MATERIAL_HELMET = new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.HEAD, new FabricItemSettings());
    public static final Item CUSTOM_MATERIAL_CHESTPLATE = new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.CHEST, new FabricItemSettings());
    public static final Item CUSTOM_MATERIAL_LEGGINGS = new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.LEGS, new FabricItemSettings());
    public static final Item CUSTOM_MATERIAL_BOOTS = new ArmorItem(CUSTOM_ARMOR_MATERIAL, EquipmentSlot.FEET, new FabricItemSettings());


    // 도구 추가, attackSpeed Default 4.0F
    public static final ToolItem CUSTOM_MATERIAL_SHOVEL = new ShovelItem(CustomItem.CustomToolMaterial.INSTANCE, 1.5F, -3.0F, new FabricItemSettings());
    public static final ToolItem CUSTOM_MATERIAL_SWORD = new SwordItem(CustomItem.CustomToolMaterial.INSTANCE, 3, -2.4F, new FabricItemSettings());
    public static final ToolItem CUSTOM_MATERIAL_PICKAXE = new PickaxeItem(CustomItem.CustomToolMaterial.INSTANCE, 1, -2.8F, new FabricItemSettings());
    public static final ToolItem CUSTOM_MATERIAL_AXE = new AxeItem(CustomItem.CustomToolMaterial.INSTANCE, 7.0F, -3.2F, new FabricItemSettings());
    public static final ToolItem CUSTOM_MATERIAL_HOE = new HoeItem(CustomItem.CustomToolMaterial.INSTANCE, 7, -3.2F, new FabricItemSettings());

    // 커스텀 활, 화살
    public static final BowItem CUSTOM_BOW = new CustomBow(new FabricItemSettings());
    public static final CustomArrow CUSTOM_ARROW = new CustomArrow(new FabricItemSettings());

    // 커스텀 블럭
    public static final CustomBlock CUSTOM_BLOCK = new CustomBlock(FabricBlockSettings.of(Material.STONE).hardness(4.0f));
    public static final ChargeableBlock CHARGEABLE_BLOCK = new ChargeableBlock(FabricBlockSettings.copyOf(Blocks.STONE));
    public static final VerticalSlabBlock VERTICAL_SLAB_BLOCK = new VerticalSlabBlock(FabricBlockSettings.copyOf(Blocks.POLISHED_ANDESITE));
    public static final AllSlabBlock ALL_SLAB_BLOCK = new AllSlabBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK));
    public static final WaterloggableBlock WATERLOGGABLE_BLOCK = new WaterloggableBlock(FabricBlockSettings.copyOf(Blocks.EMERALD_BLOCK));
    
    // 블럭 엔티티용 커스텀 블럭
    public static final DemoBlock DEMO_BLOCK = new DemoBlock(FabricBlockSettings.copyOf(Blocks.STONE));

    // 블럭 엔티티 타입 추가
    public static final BlockEntityType<DemoBlockEntity> DEMO_BLOCK_ENTITY = Registry.register(
        Registries.BLOCK_ENTITY_TYPE,
        new Identifier("studymod", "demo_block_entity"),
        FabricBlockEntityTypeBuilder.create(DemoBlockEntity::new, DEMO_BLOCK).build()
    );


    public static void register() {
        // 아이템 연료, 퇴비로 사용
        FuelRegistry.INSTANCE.add(CUSTOM_ITEM, 300);
        CompostingChanceRegistry.INSTANCE.add(CUSTOM_ITEM, 1.0F);

        Registry.register(Registries.ITEM, new Identifier("studymod", "custom_material"), CUSTOM_MATERIAL);
        
        // 방어구 추가
        Registry.register(Registries.ITEM, new Identifier("studymod", "custom_material_helmet"), CUSTOM_MATERIAL_HELMET);
        Registry.register(Registries.ITEM, new Identifier("studymod", "custom_material_chestplate"), CUSTOM_MATERIAL_CHESTPLATE);
        Registry.register(Registries.ITEM, new Identifier("studymod", "custom_material_leggings"), CUSTOM_MATERIAL_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier("studymod", "custom_material_boots"), CUSTOM_MATERIAL_BOOTS);

        // 도구 추가
        Registry.register(Registries.ITEM, new Identifier("studymod", "custom_material_shovel"), CUSTOM_MATERIAL_SHOVEL);
        Registry.register(Registries.ITEM, new Identifier("studymod", "custom_material_sword"), CUSTOM_MATERIAL_SWORD);
        Registry.register(Registries.ITEM, new Identifier("studymod", "custom_material_pickaxe"), CUSTOM_MATERIAL_PICKAXE);
        Registry.register(Registries.ITEM, new Identifier("studymod", "custom_material_axe"), CUSTOM_MATERIAL_AXE);
        Registry.register(Registries.ITEM, new Identifier("studymod", "custom_material_hoe"), CUSTOM_MATERIAL_HOE);

        // 커스텀 활 추가
        Registry.register(Registries.ITEM, new Identifier("studymod", "custom_bow"), CUSTOM_BOW);
        Registry.register(Registries.ITEM, new Identifier("studymod", "custom_arrow"), CUSTOM_ARROW);

        // 커스텀 블럭 추가
        Registry.register(Registries.BLOCK, new Identifier("studymod", "custom_block"), CUSTOM_BLOCK);
        // 아이템을 사용해 블럭을 추가하기 위해 아이템으로도 등록 (인벤토리)
        Registry.register(Registries.ITEM, new Identifier("studymod", "custom_block"), new BlockItem(CUSTOM_BLOCK, new FabricItemSettings()));
        
        // 차지 후 번개치는 커스텀 블럭 추가
        Registry.register(Registries.BLOCK, new Identifier("studymod", "chargeable_block"), CHARGEABLE_BLOCK);
        Registry.register(Registries.ITEM, new Identifier("studymod", "chargeable_block"), new BlockItem(CHARGEABLE_BLOCK, new FabricItemSettings()));

        Registry.register(Registries.BLOCK, new Identifier("studymod", "vertical_slab_block"), VERTICAL_SLAB_BLOCK);
        Registry.register(Registries.ITEM, new Identifier("studymod", "vertical_slab_block"), new BlockItem(VERTICAL_SLAB_BLOCK, new FabricItemSettings()));

        Registry.register(Registries.BLOCK, new Identifier("studymod", "all_slab_block"), ALL_SLAB_BLOCK);
        Registry.register(Registries.ITEM, new Identifier("studymod", "all_slab_block"), new BlockItem(ALL_SLAB_BLOCK, new FabricItemSettings()));

        Registry.register(Registries.BLOCK, new Identifier("studymod", "waterloggable_block"), WATERLOGGABLE_BLOCK);
        Registry.register(Registries.ITEM, new Identifier("studymod", "waterloggable_block"), new BlockItem(WATERLOGGABLE_BLOCK, new FabricItemSettings()));

        Registry.register(Registries.BLOCK, new Identifier("studymod", "demo_block"), DEMO_BLOCK);
        Registry.register(Registries.ITEM, new Identifier("studymod", "demo_block"), new BlockItem(DEMO_BLOCK, new FabricItemSettings()));
        
        // 아이템 그룹에 아이템 추가
        ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP).register(content -> {
            // 커스텀 아이템
            content.add(CUSTOM_ITEM);
            
            // 커스텀 광물
            content.add(CUSTOM_MATERIAL);
            
            // 커스텀 방어구
            content.add(CUSTOM_MATERIAL_HELMET);
            content.add(CUSTOM_MATERIAL_CHESTPLATE);
            content.add(CUSTOM_MATERIAL_LEGGINGS);
            content.add(CUSTOM_MATERIAL_BOOTS);

            // 커스텀 도구
            content.add(CUSTOM_MATERIAL_SHOVEL);
            content.add(CUSTOM_MATERIAL_SWORD);
            content.add(CUSTOM_MATERIAL_PICKAXE);
            content.add(CUSTOM_MATERIAL_AXE);
            content.add(CUSTOM_MATERIAL_HOE);
            content.add(CUSTOM_ARROW);
            content.add(CUSTOM_ARROW);
        });
    }
}
