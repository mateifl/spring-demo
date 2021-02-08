package ro.mfl.testclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {

    @Value("${webclient.base.url}")
    private String baseUrl;

    @Bean
    @Scope("prototype")
    public WebClient webClient() {
        return WebClient.create(baseUrl);
    }

}
