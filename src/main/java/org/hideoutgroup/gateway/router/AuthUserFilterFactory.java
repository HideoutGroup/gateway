package org.hideoutgroup.gateway.router;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.*;

/**
 * @author wenqiangdong
 * @date 2019-04-17
 */
@Slf4j
@Component
public class AuthUserFilterFactory implements GlobalFilter, Ordered {


    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE - 10;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        URI requestUrl = exchange.getRequiredAttribute(GATEWAY_REQUEST_URL_ATTR);

        String scheme = requestUrl.getScheme();
        if (isAlreadyRouted(exchange) || (!"http".equals(scheme) && !"https".equals(scheme))) {
            return chain.filter(exchange);
        }
        setAlreadyRouted(exchange);
        CompletableFuture<String> a = null;
        return Mono.fromFuture(a).flatMap(v -> {
            log.info("{}", v);
            //TODO
            return chain.filter(exchange);
        });

    }
}
