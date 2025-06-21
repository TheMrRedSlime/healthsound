package healthindicatorsound.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;

@Config(name = "healthwarning")
public class HealthWarningConfig implements ConfigData {

    @ConfigEntry.Gui.Tooltip
    public float threshold = 6.0F;
    @ConfigEntry.Gui.Tooltip
    public boolean enabled = true;
    @ConfigEntry.Gui.Tooltip
    public float soundmultiplier = 34.4F;

    public static void init() {
        AutoConfig.register(HealthWarningConfig.class, Toml4jConfigSerializer::new);
    }

    public static HealthWarningConfig get() {
        return AutoConfig.getConfigHolder(HealthWarningConfig.class).getConfig();
    }
}