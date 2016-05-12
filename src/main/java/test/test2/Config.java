package test.test2;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration()
public class Config {

	@Bean
	public DriverManagerDataSource dataSource() throws URISyntaxException, UnsupportedEncodingException {
        URI dbUri = new URI("postgres://iwlxjgjndszdgw:-TDE06I16WI-LlE4kYX3qTjABd@ec2-54-163-254-231.compute-1.amazonaws.com:5432/dbf1cj19b51l82");
        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String jdbcUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() +
        		"?sslmode=require&user=" + URLEncoder.encode(username, "UTF-8") +
        		"&password=" + URLEncoder.encode(password, "UTF-8");
		DriverManagerDataSource res = new DriverManagerDataSource(jdbcUrl);
		res.setDriverClassName("org.postgresql.Driver");
		return res;
	}
	
	@Bean
	public JdbcTemplate jdbc() throws UnsupportedEncodingException, URISyntaxException {
		return new JdbcTemplate(dataSource());
	}
}
