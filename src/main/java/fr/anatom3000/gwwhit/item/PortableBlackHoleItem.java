package fr.anatom3000.gwwhit.item;

import io.netty.util.internal.ConcurrentSet;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Collections;

public class PortableBlackHoleItem extends Item {

    public PortableBlackHoleItem(Settings settings) {
        super(settings);
    }
    private static ConcurrentSet<BlockPos> remove = new ConcurrentSet<>();

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (context.getPlayer() != null) {
            context.getPlayer().setCurrentHand(context.getHand());
        }
        BlockPos startPos = context.getBlockPos();
        new Thread(() -> storeBlocks(context.getWorld(), startPos, 8)).start();
        return ActionResult.CONSUME;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        player.setCurrentHand(hand);
        breakStoredBlocks(world);
        return TypedActionResult.consume(player.getStackInHand(hand));
    }

    private static void breakStoredBlocks(World world) {
        //TODO: Fix ghost blocks
        ArrayList<BlockPos> positions = new ArrayList<>(remove);
        Collections.shuffle(positions);
        for (int i = 0; i < positions.size() && i < 128; ++i) {
            BlockPos pos = positions.get(i);
            if (!world.getBlockState(pos).isAir()) {
                world.breakBlock(positions.get(i), false);
            }
            remove.remove(pos);
        }
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 1;
    }

    private static void storeBlocks(World world, BlockPos pos, int distance) {
        for (int x = -distance; x <= distance; ++x) {
            for (int y = -distance; y <= distance; ++y) {
                for (int z = -distance; z <= distance; ++z) {
                    if (remove.size() >= 16384) {
                        return;
                    }
                    BlockPos newPos = new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z);
                    if (!world.getBlockState(newPos).isAir()) {
                        remove.add(newPos);
                    }
                }
            }
        }
    }

}
