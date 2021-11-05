package fr.anatom3000.gwwhit.config.data;

import fr.anatom3000.gwwhit.GWWHIT;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;

@SuppressWarnings("CanBeFinal") // Shut up code inspection
@Config(name = GWWHIT.MOD_ID)
public class MainConfig extends PartitioningSerializer.GlobalData {
    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Category("moreOres")
    public MoreOresConfig moreOres = new MoreOresConfig();

    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Category("gameplay")
    public GameplayConfig gameplay = new GameplayConfig();

    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Category("rendering")
    public RenderingConfig rendering = new RenderingConfig();

    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Category("audio")
    public AudioConfig audio = new AudioConfig();

    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Category("misc")
    public MiscConfig misc = new MiscConfig();

    @ConfigEntry.Gui.TransitiveObject
    @ConfigEntry.Category("blocks")
    public BlockConfig blocks = new BlockConfig();
}
