package healthindicatorsound;

import net.fabricmc.api.ClientModInitializer;


public class HealthWarningClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HealthWarning.LOGGER.info("Indicator Client Loaded!");
    }
}
