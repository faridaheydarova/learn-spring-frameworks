package az.developia.spring_rest_project.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper mapper(){
        ModelMapper mapper=new ModelMapper();
        return mapper;
    }
}
