/*
 * Copyright 2014-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sjbs.menudesigner.terminal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    /**
     * Application main() method.
     * <p/>
     * Uses the fluent {@link SpringApplicationBuilder} to create and run the
     * {@link SpringApplication} object.
     * <p/>
     * The options specified:
     * <p/>
     * <ul>
     * <li>headless(false) - allow AWT classes to be instantiated</li>
     * <li>web(false) - prevents the bundling of Tomcat or other Web components
     * </ul>
     * <p/>
     * Execution is picked up by the {@link Runner} class, which implements
     * {@link CommandLineRunner}.
     *
     * @param args
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .headless(false)
                .web(false)
                .run(args);
    }

    /**
     * Creates the {@link DemoFrame} object and returns it.
     * <p/>
     * This @Bean could have been replaced by a @Component annotation being
     * added to the {@link DemoFrame} class.
     *
     * @return the application window
     */
    @Bean
    public MainFrame frame() {
        return new MainFrame();
    }
}
