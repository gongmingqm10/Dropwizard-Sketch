package net.gongmingqm10.sketch.helpers;

import java.util.HashMap;
import java.util.Map;

public class FeatureToggles {
    private static Map<FeatureToggle, Boolean> featureToggles = new HashMap<>();

    public static void loadFeatureToggles(Map<FeatureToggle, Boolean> featureToggles) {
        FeatureToggles.featureToggles = new HashMap<>(featureToggles);
    }

    public static boolean getFeatureToggle(FeatureToggle featureToggle) {
        return featureToggles.containsKey(featureToggle) && featureToggles.get(featureToggle);
    }

    public static void addFeatureToggle(FeatureToggle featureToggle, boolean enabled) {
        featureToggles.put(featureToggle, enabled);
    }
}
