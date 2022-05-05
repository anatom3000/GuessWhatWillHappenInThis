package fr.anatom3000.gwwhit.compat;

import com.enderzombi102.loadercomplex.api.Addon;
import com.enderzombi102.loadercomplex.api.Loader;
import com.enderzombi102.loadercomplex.api.annotation.Instance;
import com.enderzombi102.loadercomplex.api.block.Block;
import com.enderzombi102.loadercomplex.api.block.Blockstate;
import com.enderzombi102.loadercomplex.api.entity.Player;
import com.enderzombi102.loadercomplex.api.utils.Direction;
import com.enderzombi102.loadercomplex.api.utils.Hand;
import com.enderzombi102.loadercomplex.api.utils.Position;
import com.enderzombi102.loadercomplex.api.utils.ResourceIdentifier;
import com.enderzombi102.loadercomplex.api.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class LoaderComplexCompat implements Addon {
    @Instance
    public static final LoaderComplexCompat INSTANCE = new LoaderComplexCompat();
    private static final String ID = "gwwhit";
    public String description;
    public String name;
    public String iconPath;
    public Map<String, String> links;

    @Override
    public void init(Loader loader) {
        loader.getRegistry().register(
            new Block() {
                @Override
                public boolean OnBlockInteracted(World world, Position pos, Blockstate state, Player player, Hand hand, Direction direction, double hitX, double hitY, double hitZ) {
                    player.sendMessage("You feel well fed");
                    player.setFoodLevel( 20 );
                    player.setSaturationLevel( 20 );
                    return true;
                }
            },
            new ResourceIdentifier( ID, "food_bank" ),
            new ResourceIdentifier( ID, "gwwhit" )
        );
    }

    @Override
    public String getAuthors() {
        return "Anatom3000, ENDERZOMBI102";
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Nullable
    @Override
    public String getName() {
        return name;
    }

    @Nullable
    @Override
    public String getIconPath() {
        return iconPath;
    }

    @Override
    public Map<String, String> getLinks() {
        return links;
    }
}
