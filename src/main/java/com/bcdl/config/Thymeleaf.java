package com.bcdl.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Thymeleaf {
    @Value("${WebConfig.Thymeleaf.prefix:#{'classpath:/templates/'}}")
    public String prefix;
    @Value("${WebConfig.Thymeleaf.suffix:#{'.html'}}")
    public String suffix;
    @Value("${WebConfig.Thymeleaf.mode:#{'HTML'}}")
    public String mode;
    @Value("${WebConfig.Thymeleaf.encoding:#{'utf-8'}}")
    public String encoding;
    @Value("${WebConfig.Thymeleaf.cache:#{true}}")
    public boolean cache;
    @Value("${WebConfig.Thymeleaf.viewNames:#{null}}")
    public String[] viewNames;
    @Value("${WebConfig.Thymeleaf.excludedViewNames:#{null}}")
    public String[] excludedViewNames;
    @Value("${WebConfig.Thymeleaf.templateResolverOrder:#{1}}")
    public Integer templateResolverOrder;
    @Value("${WebConfig.Thymeleaf.enabled:#{true}}")
    public boolean enabled;
}
