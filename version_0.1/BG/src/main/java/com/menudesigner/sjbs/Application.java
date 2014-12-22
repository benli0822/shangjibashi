package com.menudesigner.sjbs;

import com.menudesigner.sjbs.service.CommandService;
import com.menudesigner.sjbs.service.repository.CommandRepository;
import com.menudesigner.sjbs.service.repository.DishRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Locale;

/**
 * Created by JIN Benli on 27/10/14.
 */
//@Configuration
//@EnableAutoConfiguration
//@EnableJpaRepositories
//@Import({RepositoryRestMvcConfiguration.class})
//@ComponentScan

@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        DishRepository dishRepository = context.getBean(DishRepository.class);
        CommandRepository commandRepository = context.getBean(CommandRepository.class);
        CommandService commandService = context.getBean(CommandService.class);
    }

    private static Log logger = LogFactory.getLog(Application.class);

    @Bean
    protected ServletContextListener listener() {
        return new ServletContextListener() {

            @Override
            public void contextInitialized(ServletContextEvent sce) {
                logger.info("ServletContext initialized");
            }

            @Override
            public void contextDestroyed(ServletContextEvent sce) {
                logger.info("ServletContext destroyed");
            }

        };
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

}
