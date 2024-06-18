package com.dropwizard.service;

import com.dropwizard.service.resource.HealthCheckResource;
import com.dropwizard.service.resource.Route;
import com.dropwizard.service.resource.TaskResource;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import io.dropwizard.jdbi3.JdbiFactory;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.jdbi.v3.core.Jdbi;

public class ServiceServer extends Application<Config> {
    public static void main(String[] args) throws Exception {
        new ServiceServer().run(args);
    }
    @Override
    public void initialize(Bootstrap<Config> bootstrap) {
       bootstrap.addBundle(new SwaggerBundle<Config>() {
        @Override
        protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(Config configuration) {
            return configuration.getSwagger();
        }
    });

    }

    @Override
    public void run(Config config, Environment environment) throws Exception {
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, config.getDataSourceFactory(), "postgresql");
        Route route = new Route(jdbi);
        TaskResource taskResource = new TaskResource(jdbi);
        environment.jersey().register(route);
        environment.jersey().register(taskResource);
        environment.jersey().register(new HealthCheckResource());
    }
}
