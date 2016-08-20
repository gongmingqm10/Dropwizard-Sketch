package net.gongmingqm10.sketch.config;

import io.dropwizard.Configuration;
import net.gongmingqm10.sketch.helpers.FeatureToggle;

import java.util.HashMap;
import java.util.Map;

public class AppConfiguration extends Configuration {
    private String apiUrl;
    private Map<FeatureToggle, Boolean> featureToggles = new HashMap<>();

    public String getApiUrl() {
        return apiUrl;
    }

    public Map<FeatureToggle, Boolean> getFeatureToggles() {
        return featureToggles;
    }
}
