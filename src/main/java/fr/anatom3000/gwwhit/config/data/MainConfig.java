package fr.anatom3000.gwwhit.config.data;

import fr.anatom3000.gwwhit.Const;
import fr.anatom3000.gwwhit.config.SyncOptions;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Category;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.TransitiveObject;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;

import static fr.anatom3000.gwwhit.config.SyncOptions.GROUP;

@SuppressWarnings("CanBeFinal") // Shut up code inspection
@Config(name = Const.MOD_ID)
public class MainConfig extends PartitioningSerializer.GlobalData {
    @SyncOptions(GROUP) @TransitiveObject @Category("moreOres") public MoreOresConfig moreOres = new MoreOresConfig();

    @SyncOptions(GROUP) @TransitiveObject @Category("gameplay") public GameplayConfig gameplay = new GameplayConfig();

    @SyncOptions(GROUP) @TransitiveObject @Category("rendering") public RenderingConfig rendering = new RenderingConfig();

    @SyncOptions(GROUP) @TransitiveObject @Category("audio") public AudioConfig audio = new AudioConfig();

    @SyncOptions(GROUP) @TransitiveObject @Category("misc") public MiscConfig misc = new MiscConfig();

    @SyncOptions(GROUP) @TransitiveObject @Category("blocks") public BlockConfig blocks = new BlockConfig();
}
