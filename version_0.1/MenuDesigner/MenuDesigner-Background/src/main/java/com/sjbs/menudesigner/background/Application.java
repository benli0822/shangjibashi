package com.sjbs.menudesigner.background;

import com.sjbs.menudesigner.background.service.CommandService;
import com.sjbs.menudesigner.background.common.repository.CommandRepository;
import com.sjbs.menudesigner.background.common.repository.DishRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by JIN Benli on 27/10/14.
 */

@SpringBootApplication
@ComponentScan("com.sjbs.menudesigner.background")
@EnableJpaRepositories
public class Application {

  /**
   * Application main method.
   *
   * @param args input arguments
   * @throws Exception exceptions
   */
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

  // not working
  @Bean
  @Order(Ordered.HIGHEST_PRECEDENCE)
  CharacterEncodingFilter characterEncodingFilter() {
    CharacterEncodingFilter filter = new CharacterEncodingFilter();
    filter.setEncoding("UTF-8");
    filter.setForceEncoding(true);
    return filter;
  }
}
