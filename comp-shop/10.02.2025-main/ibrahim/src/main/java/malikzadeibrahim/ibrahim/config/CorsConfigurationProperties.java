package malikzadeibrahim.ibrahim.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "server.servlet.cors")
@Getter
@Setter
public class CorsConfigurationProperties {
    private String[] allowedOrigins;
    private String[] allowedMethods;
    private String[] allowedHeaders;
    private boolean allowCredentials;
}