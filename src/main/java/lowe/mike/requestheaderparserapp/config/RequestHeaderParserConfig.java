package lowe.mike.requestheaderparserapp.config;

import lowe.mike.requestheaderparserapp.service.RequestHeaderParserService;
import lowe.mike.requestheaderparserapp.service.RequestHeaderParserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RequestHeaderParserConfig {

    @Bean
    public RequestHeaderParserService requestHeaderParserService() {
        return new RequestHeaderParserServiceImpl();
    }

}
