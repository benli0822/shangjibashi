package com.menudesigner.sjbs.config.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by JIN Benli on 06/04/15.
 */
@Configuration
@PropertySource({"classpath:config/datasource.properties"})
public class DatabaseConfig
{
}
