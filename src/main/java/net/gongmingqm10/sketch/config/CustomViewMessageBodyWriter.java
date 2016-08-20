package net.gongmingqm10.sketch.config;

import com.codahale.metrics.MetricRegistry;
import io.dropwizard.views.View;
import io.dropwizard.views.ViewMessageBodyWriter;
import io.dropwizard.views.ViewRenderer;
import net.gongmingqm10.sketch.views.BaseView;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
public class CustomViewMessageBodyWriter extends ViewMessageBodyWriter {

    private final AppConfiguration appConfiguration;

    @Context
    HttpServletRequest httpServletRequest;

    public CustomViewMessageBodyWriter(MetricRegistry metricRegistry, Iterable<ViewRenderer> viewRenderers, AppConfiguration appConfiguration) {
        super(metricRegistry, viewRenderers);
        this.appConfiguration = appConfiguration;
    }

    @Override
    public void writeTo(View t,
                        Class<?> type,
                        Type genericType,
                        Annotation[] annotations,
                        MediaType mediaType,
                        MultivaluedMap<String, Object> httpHeaders,
                        OutputStream entityStream) throws IOException {
        if (BaseView.class.isInstance(t)) {
            // Add some basic stuff for the BaseView. Such as global username or csrf token
        }
        super.writeTo(t, type, genericType, annotations, mediaType, httpHeaders, entityStream);
    }
}
