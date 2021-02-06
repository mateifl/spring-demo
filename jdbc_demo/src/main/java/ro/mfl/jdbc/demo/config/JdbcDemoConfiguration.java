package ro.mfl.jdbc.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@Configuration
@EnableJdbcRepositories("ro.mfl.jdbc.demo.repositories")  
public class JdbcDemoConfiguration extends AbstractJdbcConfiguration {
	

}
