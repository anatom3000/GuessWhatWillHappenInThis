package fr.anatom3000.gwwhit.block.entity;

import fr.anatom3000.gwwhit.gui.FurnaceGuiDescription;
import fr.anatom3000.gwwhit.registry.BlockEntityRegistry;
import fr.anatom3000.gwwhit.util.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeInputProvider;
import net.minecraft.recipe.RecipeMatcher;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;


public class FurnaceBlockEntity extends BlockEntity implements ImplementedInventory, RecipeInputProvider, NamedScreenHandlerFactory {
    private static final HashMap<Item, Integer> FUELS = new HashMap<>() {{
        put( Items.LAVA_BUCKET, 20000);
        put( Blocks.COAL_BLOCK.asItem(), 16000);
    }};

    // 1: fuel
    // 0: input
    // 2: output
    private DefaultedList<ItemStack> items =  DefaultedList.ofSize(3, ItemStack.EMPTY);
    private long storedExp;
    private long burnTime;

    public FurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.FURNACE_BLOCK_ENTITY, pos, state);

    }

    // --- NamedScreenHandlerFactory ---

    /**
     * Returns the title of this screen handler; will be a part of the open
     * screen packet sent to the client.
     */
    @Override
    public Text getDisplayName() {
        return new TranslatableText("container.gwwhit.slow_furnace");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new FurnaceGuiDescription(
                syncId,
                inv,
                ScreenHandlerContext.create(
                        this.world,
                        this.pos
                )
        );
    }

    // --- ImplementedInventory ---

    /**
     * Gets the item list of this inventory.
     * Must return the same instance every time it's called.
     *
     * @return the item list
     */
    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    @Override
    public void markDirty() {
        super.markDirty();
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, Direction side) {
        return switch (slot) {
            case 0 -> {
                assert this.world != null;
                yield this.world.getRecipeManager().getFirstMatch(
                        RecipeType.SMELTING,
                        this,
                        this.world
                ).isPresent();
            }
            case 1 -> FUELS.containsKey( stack.getItem() );
            case 2 -> false;
            default -> throw new IllegalStateException("Unexpected value: " + slot);
        };
    }

    // --- RecipeInputProvider ---

    @Override
    public void provideRecipeInputs(RecipeMatcher finder) {

    }

    public static void tick(World world, BlockPos pos, BlockState state, FurnaceBlockEntity blockEntity) {

    }

    public void dropExperience(ServerWorld serverWorld, Vec3d ofCenter) {

    }

    private ItemStack getInput() {
        return this.items.get(0);
    }

    private ItemStack getFuel() {
        return this.items.get(1);
    }

    private ItemStack getOutput() {
        return this.items.get(2);
    }
}
