package org.hideoutgroup.gateway.router;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;

/**
 * @author 董文强
 * @version 1.0
 * @date 2019年01月22日
 */
@Configuration
public class RouterConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(RouterConfig.class);

    @Bean
    public ChangeRequestUriGatewayFilterFactory changeRequestUriGatewayFilterFactory() {
        return new ChangeRequestUriGatewayFilterFactory();
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder, @Autowired ChangeRequestUriGatewayFilterFactory filterFactory) {

        return builder.routes()
                .route(p -> p
                        .path("/api/*").or().path("/api").or().path("/api/")
                        .filters(f -> f.rewritePath("/api", ""))
                        .uri(URI.create("http://111.111.111.111"))
                        .filter(filterFactory.apply()))
                .build();
    }

}
