package fil.tiir.fakedistrib;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@MapperScan(value = "fil.tiir.fakedistrib.dao")
public class Application extends WebMvcConfigurerAdapter {
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		final PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sessionFactory.setMapperLocations(resolver.getResources("classpath*:**/*Mapper.xml"));
		return sessionFactory.getObject();
	}

	@Bean
	public DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setUsername("postgres");
		ds.setPassword("coolbaby");
		ds.setUrl("jdbc:postgresql://127.0.0.1:5432/distrib");
		ds.setDriverClassName("org.postgresql.Driver");
		ds.setMaxWait(25);
		return ds;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	  if (!registry.hasMappingForPattern("/css/**")) {
	     registry.addResourceHandler("/css/**").addResourceLocations("classpath:/css/");
	  }
	}
	
	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
		
	}
}
