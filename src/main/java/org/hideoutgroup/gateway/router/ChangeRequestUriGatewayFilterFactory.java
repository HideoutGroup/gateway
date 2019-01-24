package org.hideoutgroup.gateway.router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.factory.AbstractChangeRequestUriGatewayFilterFactory;
import org.springframework.web.server.ServerWebExchange;

import java.net.URI;
import java.util.Optional;

/**
 * 
 * @date 2019年01月24日
 * @version 1.0
 */
public class ChangeRequestUriGatewayFilterFactory extends AbstractChangeRequestUriGatewayFilterFactory {
 private static final Logger LOGGER = LoggerFactory.getLogger(ChangeRequestUriGatewayFilterFactory.class);

    public ChangeRequestUriGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    protected Optional<URI> determineRequestUri(ServerWebExchange exchange, Object config) {
       // exchange.getRequest()
        return Optional.empty();
    }


    public static class Config {
    }
}
