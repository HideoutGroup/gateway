package org.hideoutgroup.gateway.router;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractChangeRequestUriGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.Optional;
import java.util.function.Function;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.containsEncodedParts;


/**
 * @version 1.0
 * @date 2019年01月24日
 */

public class ChangeRequestUriGatewayFilterFactory extends AbstractChangeRequestUriGatewayFilterFactory<ChangeRequestUriGatewayFilterFactory.Config>  {
    private static final Logger LOGGER = LoggerFactory.getLogger(ChangeRequestUriGatewayFilterFactory.class);

    public ChangeRequestUriGatewayFilterFactory() {
        super(Config.class);
    }

    static final String ServiceQueryName = "service";

    @Override
    protected Optional<URI> determineRequestUri(ServerWebExchange exchange, Config config) {
        ServerHttpRequest req = exchange.getRequest();
        URI uri = req.getURI();
        URI tempURI = exchange.getAttribute(GATEWAY_REQUEST_URL_ATTR);
        String service = req.getQueryParams().getFirst(ServiceQueryName);
        boolean encoded = containsEncodedParts(uri);
        URI mergedUrl = UriComponentsBuilder.fromUri(tempURI)
                .host(service)
                .port(null)
                .replaceQueryParam(ServiceQueryName)
                .build(encoded)
                .toUri();
        LOGGER.info("原本请求{},转换后的请求{}", uri, mergedUrl);
        return Optional.of(mergedUrl);
    }

    public GatewayFilter apply() {
       return super.apply(new Config());
   }



    public static class Config {
    }
}
