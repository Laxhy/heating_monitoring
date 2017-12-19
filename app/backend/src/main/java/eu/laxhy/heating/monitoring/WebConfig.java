package eu.laxhy.heating.monitoring;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Enables CORS for all requests.
 *
 * @author Laxhy
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //TODO: are there any constant that could be used for http method names?
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}