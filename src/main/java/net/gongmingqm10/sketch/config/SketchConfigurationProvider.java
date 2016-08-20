package net.gongmingqm10.sketch.config;

import com.google.common.io.ByteStreams;
import io.dropwizard.configuration.ConfigurationSourceProvider;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static java.lang.String.format;

public class SketchConfigurationProvider implements ConfigurationSourceProvider {
    private EnvironmentVariableSubstitutor substitutor;

    public SketchConfigurationProvider() {
        this.substitutor = new EnvironmentVariableSubstitutor();
    }

    @Override
    public InputStream open(String environment) throws IOException {
        InputStream configStream = getClass().getClassLoader().getResourceAsStream(format("config/%s.yml", environment));
        String config = new String(ByteStreams.toByteArray(configStream), StandardCharsets.UTF_8);
        String substituted = substitutor.replace(config);

        return new ByteArrayInputStream(substituted.getBytes(StandardCharsets.UTF_8));
    }
}
