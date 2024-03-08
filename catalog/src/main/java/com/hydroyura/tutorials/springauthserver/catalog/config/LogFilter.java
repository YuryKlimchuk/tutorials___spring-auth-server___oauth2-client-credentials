package com.hydroyura.tutorials.springauthserver.catalog.config;

import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class LogFilter extends AbstractLogFilter {
    @Override
    protected void initLogger() {
        LOG = LoggerFactory.getLogger("CATALOG");
    }
}
