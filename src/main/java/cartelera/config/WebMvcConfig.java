/**
 * 
 */
package cartelera.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configurable
//@EnableWebMvc // equivalente al <mvc:annotation-driven/>
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry
		.addMapping("/api/**")
		.allowedOrigins("http://localhost:8181", "127.0.0.1:8181", "127.0.1.1:8181", "http://localhost:8090", "127.0.0.1:8090", "127.0.1.1:8090")
		.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD");
		
	}
}
