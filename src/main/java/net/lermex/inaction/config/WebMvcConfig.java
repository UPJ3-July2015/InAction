package net.lermex.inaction.config;

import static org.springframework.context.annotation.ComponentScan.Filter;

import java.text.SimpleDateFormat;
import java.util.List;

import net.lermex.inaction.Application;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
@ComponentScan(basePackageClasses = Application.class, includeFilters = @Filter(Controller.class), useDefaultFilters = false)
@EnableAspectJAutoProxy
class WebMvcConfig extends WebMvcConfigurationSupport {

    private static final String MESSAGE_SOURCE = "/WEB-INF/i18n/messages";
    private static final String VIEWS = "/WEB-INF/views/";

    private static final String RESOURCES_LOCATION = "/resources/";
    private static final String RESOURCES_HANDLER = RESOURCES_LOCATION + "**";

    @Override
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping requestMappingHandlerMapping = super.requestMappingHandlerMapping();
        requestMappingHandlerMapping.setUseSuffixPatternMatch(false);
        requestMappingHandlerMapping.setUseTrailingSlashMatch(false);
        return requestMappingHandlerMapping;
    }

    @Bean(name = "messageSource")
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename(MESSAGE_SOURCE);
        messageSource.setCacheSeconds(5);
        return messageSource;
    }

    @Bean
    public TemplateResolver templateResolver() {
        TemplateResolver templateResolver = new ServletContextTemplateResolver();
        templateResolver.setPrefix(VIEWS);
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setCacheable(false);
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine(templateEngine());
        thymeleafViewResolver.setCharacterEncoding("UTF-8");
        return thymeleafViewResolver;
    }

    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setValidationMessageSource(messageSource());
        return validator;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(RESOURCES_HANDLER).addResourceLocations(RESOURCES_LOCATION);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * Handles favicon.ico requests assuring no <code>404 Not Found</code> error is returned.
     */
    @Controller
    static class FaviconController {
        @RequestMapping("favicon.ico")
        String favicon() {
            return "forward:/resources/images/favicon.ico";
        }
    }
    
    /* Эти два метода ниже настраивают отображение timestamp в дата-время */
    
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(converter());
        addDefaultHttpMessageConverters(converters) ;
    }

    @Bean
    MappingJackson2HttpMessageConverter converter() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        mapper.setDateFormat(new SimpleDateFormat("yyyy.MM.dd HH:mm:ss"));
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new
                MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setObjectMapper(mapper);
        return mappingJackson2HttpMessageConverter;
    }
}
