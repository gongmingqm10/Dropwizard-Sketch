package net.gongmingqm10.sketch;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import net.gongmingqm10.sketch.config.AppConfiguration;
import net.gongmingqm10.sketch.config.Dependencies;
import net.gongmingqm10.sketch.config.SketchConfiguration;
import net.gongmingqm10.sketch.helpers.FeatureToggles;

public class DropWizardSketchApplication extends Application<SketchConfiguration> {

    private Dependencies dependencies;

    public DropWizardSketchApplication() {
        this.dependencies = new Dependencies();
    }

    public static void main(String[] args) throws Exception {
        new DropWizardSketchApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<SketchConfiguration> bootstrap) {
        bootstrap.setConfigurationSourceProvider(dependencies.getConfigurationProvider());
        bootstrap.addBundle(new AssetsBundle());
    }

    @Override
    public void run(SketchConfiguration configuration, Environment environment) throws Exception {
        dependencies.setConfiguration(configuration);
        AppConfiguration appConfiguration = configuration.getAppConfiguration();
        FeatureToggles.loadFeatureToggles(appConfiguration.getFeatureToggles());

        environment.healthChecks().register("DropWizard Sketch", dependencies.getHealthCheck());
        environment.jersey().register(dependencies.getViewMessageBodyWriter(environment));

        environment.jersey().register(dependencies.getHomeResource());
    }
}