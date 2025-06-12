package healthindicatorsound;

import net.fabricmc.api.ModInitializer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import healthindicatorsound.config.HealthWarningConfig;

public class HealthWarning implements ModInitializer {
	public static final String MOD_ID = "healthindicatorsound";

	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		HealthWarningConfig.init();
		LOGGER.info("Health indicator loaded!");
	}

	public static boolean isModEnabled() {
        return HealthWarningConfig.get().enabled;
    }
}