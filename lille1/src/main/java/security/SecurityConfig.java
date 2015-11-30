package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
            	.permitAll();
    }
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	       	
	// TODO : A modifier pour faire l'authentification
	// CF : http://docs.spring.io/spring-security/site/docs/4.0.x/reference/htmlsingle/#jc-form
	}
}
