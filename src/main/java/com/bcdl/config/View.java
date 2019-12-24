package com.bcdl.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class View {
    @Value("${WebConfig.View.prefix:#{null}}")
    public String prefix;
    @Value("${WebConfig.View.suffix:#{null}}")
    public String suffix;
    @Value("${WebConfig.View.viewNames:#{null}}")
    public String[] viewNames;
    @Value("${WebConfig.View.order:#{2}}")
    public Integer order;
}
