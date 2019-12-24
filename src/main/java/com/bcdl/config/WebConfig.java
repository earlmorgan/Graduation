package com.bcdl.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.web.servlet.view.InternalResourceViewResolver;

import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = WebConfig.class)
//ConfigurationProperties 需要写解析文件=-
//@ConfigurationProperties(prefix = "WebConfig", ignoreInvalidFields=true, ignoreUnknownFields=true)
public class WebConfig implements WebMvcConfigurer {

    //日志
    private static final Logger log = LoggerFactory.getLogger(WebConfig.class);

    @Autowired
    private Thymeleaf thymeleaf;
    @Autowired
    private View view;


    /**
     *  @Description: 注册jsp视图解析器
     *  @params: []
     *  @return: org.springframework.web.servlet.ViewResolver
     */
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix(view.prefix);
        viewResolver.setSuffix(view.suffix);
        viewResolver.setViewNames(view.viewNames);
        viewResolver.setOrder(view.order);
        return viewResolver;
    }

    /**
     *  @Description: 注册html视图解析器
     *  @params: []
     *  @return: org.thymeleaf.templateresolver.ITemplateResolver
     */
    @Bean
    public ITemplateResolver templateResolver(){
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setTemplateMode(thymeleaf.mode);
        templateResolver.setPrefix(thymeleaf.prefix);
        templateResolver.setSuffix(thymeleaf.suffix);
        templateResolver.setCharacterEncoding(thymeleaf.encoding);
        templateResolver.setCacheable(thymeleaf.cache);
        return templateResolver;
    }

    /**
     *  @Description: 将自定义html视图解析器添加到模板引擎并注册到ioc
     *  @params: []
     *  @return: org.thymeleaf.spring5.SpringTemplateEngine
     */
    @Bean
    public SpringTemplateEngine templateEngine(){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    /**
     *  @Description: Thymeleaf视图解析器配置
     *  @params: []
     *  @return: org.thymeleaf.spring5.view.ThymeleafViewResolver
     */
    @Bean
    public ThymeleafViewResolver thymeleafViewResolver(){
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding(thymeleaf.encoding);
        viewResolver.setViewNames(thymeleaf.viewNames);
        viewResolver.setExcludedViewNames(thymeleaf.excludedViewNames);
        viewResolver.setOrder(thymeleaf.templateResolverOrder);
        return viewResolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * @Description: 配置静态文件映射
     * @params: [ResourceHandlerRegistry registry]
     * @return: void
     **/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("/WEB-INF/static/").addResourceLocations("classpath:/static/");
    }



}
