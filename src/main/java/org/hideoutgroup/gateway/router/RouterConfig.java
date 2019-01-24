package org.hideoutgroup.gateway.router;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 董文强
 * @version 1.0
 * @date 2019年01月22日
 */
@Configuration
public class RouterConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(RouterConfig.class);

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> {
                    return p
                            .path("/api")
                            //.filters(f -> f.addRequestHeader("Hello", "World"))
                            .uri("http://httpbin.org:80");
                })
                .route(p -> p
                        .host("*.hystrix.com")
                        .filters(f -> f.hystrix(config -> config.setName("mycmd").setFallbackUri("forward:/fallback")))
                        .uri("http://httpbin.org:80")).
                        build();
    }

}
