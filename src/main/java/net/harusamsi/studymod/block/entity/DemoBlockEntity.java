package net.harusamsi.studymod.block.entity;

import net.harusamsi.studymod.RegisterItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class DemoBlockEntity extends BlockEntity  {
    private int number = 0;
    private int startTimeFromBuilt = 0;
    private static int timeFromBuilt = 0;

    public DemoBlockEntity(BlockPos pos, BlockState state) {
        super(RegisterItems.DEMO_BLOCK_ENTITY, pos, state);
        startTimeFromBuilt = timeFromBuilt;
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        nbt.putInt("number", number);
        nbt.putInt("time", timeFromBuilt - startTimeFromBuilt);
        super.writeNbt(nbt);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        number = nbt.getInt("number");
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }

    public static void tick(World world, BlockPos pos, BlockState state, DemoBlockEntity be) {
        if (timeFromBuilt + 1 == Integer.MAX_VALUE) {
            timeFromBuilt = 0;
        }
        else {
            timeFromBuilt++;
        }
    }
}
