package net.gongmingqm10.sketch.config;

import com.codahale.metrics.health.HealthCheck;

public class SketchHealthCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        // Maybe need  to check something instead of always healthy
        return Result.healthy();
    }
}
