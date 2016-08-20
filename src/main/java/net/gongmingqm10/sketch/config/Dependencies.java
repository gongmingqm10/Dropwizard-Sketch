package net.gongmingqm10.sketch.config;


import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import io.dropwizard.views.ViewMessageBodyWriter;
import io.dropwizard.views.mustache.MustacheViewRenderer;
import net.gongmingqm10.sketch.resources.HomeResource;
import net.gongmingqm10.sketch.services.UserService;

import static java.util.Collections.singletonList;

public class Dependencies {

    private SketchConfiguration configuration;

    public SketchConfigurationProvider getConfigurationProvider() {
        return new SketchConfigurationProvider();
    }

    public HomeResource getHomeResource() {
        return new HomeResource(getUserService());
    }

    private UserService getUserService() {
        return new UserService();
    }

    public void setConfiguration(SketchConfiguration configuration) {
        this.configuration = configuration;
    }

    public ViewBundle getViewBundle() {
        return new ViewBundle();
    }

    public ViewMessageBodyWriter getViewMessageBodyWriter(Environment environment) {
        return new CustomViewMessageBodyWriter(
                environment.metrics(),
                singletonList(new MustacheViewRenderer()),
                configuration.getAppConfiguration());
    }

    public SketchHealthCheck getHealthCheck() {
        return new SketchHealthCheck();
    }
}
