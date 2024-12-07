package quizzpro.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class webconfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("http://localhost:4200"); 
        corsConfiguration.addAllowedMethod("*"); 
        corsConfiguration.addAllowedHeader("*"); 
        corsConfiguration.setAllowCredentials(true);
        
        return new CorsFilter(request -> corsConfiguration);
    }
}
