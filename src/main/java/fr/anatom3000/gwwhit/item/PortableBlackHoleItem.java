package fr.anatom3000.gwwhit.item;

import io.netty.util.internal.ConcurrentSet;
import net.minecraft.block.Blocks;
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
import java.util.HashMap;

public class PortableBlackHoleItem extends Item {
    private static final HashMap<ItemStack, ConcurrentSet<BlockPos>> STORAGE = new HashMap<>();

    public PortableBlackHoleItem(Settings settings) {
        super(settings);
    }

    private static void breakStoredBlocks(World world, ItemStack stack) {
        if (world.isClient || !STORAGE.containsKey(stack)) {
            return;
        }
        ArrayList<BlockPos> positions = new ArrayList<>(STORAGE.get(stack));
        Collections.shuffle(positions);
        int size = Math.min( positions.size(), 256 );
        for (int i = 0; i < size; ++i) {
            BlockPos pos = positions.get(i);
            if (!world.getBlockState(pos).isAir()) {
                world.removeBlock(positions.get(i), false);
                world.updateNeighbors(pos, Blocks.AIR);
            }
            STORAGE.get(stack).remove(pos);
        }
    }

    private static void storeBlocks(World world, BlockPos pos, int distance, ItemStack stack) {
        if (!STORAGE.containsKey(stack)) {
            STORAGE.put(stack, new ConcurrentSet<>());
        }
        for (int x = -distance; x <= distance; ++x) {
            for (int y = -distance; y <= distance; ++y) {
                for (int z = -distance; z <= distance; ++z) {
                    if (STORAGE.get(stack).size() >= 16384) {
                        return;
                    }
                    BlockPos newPos = new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z);
                    if (!world.getBlockState(newPos).isAir()) {
                        STORAGE.get(stack).add(newPos);
                    }
                }
            }
        }
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (context.getPlayer() != null) {
            context.getPlayer().setCurrentHand(context.getHand());
        }
        BlockPos startPos = context.getBlockPos();
        new Thread(() -> storeBlocks(context.getWorld(), startPos, 8, context.getStack())).start();
        return ActionResult.CONSUME;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        player.setCurrentHand(hand);
        breakStoredBlocks(world, player.getStackInHand(hand));
        return TypedActionResult.consume(player.getStackInHand(hand));
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 1;
    }
}
