package net.gongmingqm10.sketch.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.client.JerseyClientConfiguration;

public class SketchConfiguration extends Configuration {

    @JsonProperty("app")
    private AppConfiguration appConfiguration;

    private JerseyClientConfiguration jerseyClient;

    public AppConfiguration getAppConfiguration() {
        return appConfiguration;
    }

    public JerseyClientConfiguration getJerseyClient() {
        return jerseyClient;
    }
}
