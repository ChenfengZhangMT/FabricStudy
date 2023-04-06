package net.harusamsi.studymod.block;

import net.harusamsi.studymod.RegisterItems;
import net.harusamsi.studymod.block.entity.DemoBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class DemoBlock extends BlockWithEntity {
    public DemoBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof DemoBlockEntity) {
            DemoBlockEntity demoBlockEntity = (DemoBlockEntity)blockEntity;
            NbtCompound nbt = demoBlockEntity.createNbt();
            int count = nbt.getInt("number");
            int time = nbt.getInt("time");
            if (!world.isClient) {
                player.sendMessage(Text.of("(click: " + count + ")"), false);
                player.sendMessage(Text.of("(time: " + time + ")"), false);
                player.sendMessage(Text.of("-------------------------------"), false);
            }
            nbt.putInt("number", count + 1);
            demoBlockEntity.readNbt(nbt);
            return ActionResult.SUCCESS;
        }
        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DemoBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, RegisterItems.DEMO_BLOCK_ENTITY, (world1, pos, state1, be) -> DemoBlockEntity.tick(world1, pos, state1, be));
    }
}
