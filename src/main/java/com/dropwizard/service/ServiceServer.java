package com.dropwizard.service;

import com.dropwizard.service.resource.HealthCheckResource;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class ServiceServer extends com.yammer.dropwizard.Service<Configuration> {
    public static void main(String[] args) throws Exception {
        new ServiceServer().run(args);
    }
    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {

    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        environment.addResource(new HealthCheckResource());
    }
}
