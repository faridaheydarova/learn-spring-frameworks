package az.developia.spring_rest_project.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.i18n.AcceptHeaderLocaleContextResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class LocalResolverConfig {

	@Bean
	public LocaleResolver localResolver() {
		AcceptHeaderLocaleResolver localeResolver=new AcceptHeaderLocaleResolver();
	localeResolver.setDefaultLocale(Locale.US);
return localeResolver;
	}
}
