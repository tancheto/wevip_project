package bg.sofia.uni.fmi.piss.project.wevip;

import bg.sofia.uni.fmi.piss.project.wevip.service.DetailsService;
import bg.sofia.uni.fmi.piss.project.wevip.service.UserAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  private DetailsService detailsService;

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(10);
  };

  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(detailsService).passwordEncoder(passwordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/registrationForm", "/theory/**", "/add", "/practice/**", "/css/**", "/images/**", "/js/**").permitAll()
        .antMatchers("/index", "/main", "/parts/", "/tasks/**", "/difficulties/", "/loginForm").permitAll()
        .antMatchers("/user/registrationForm", "/user/loginForm", "/noSolutionTasks/**", "/approve", "/offer").permitAll()
        .anyRequest().authenticated()
        .and()
        //wants to authenticate using a form
        .formLogin()
        //use a custom login form - every user that is not authenticated
        .loginPage("/index")
        .permitAll()
        .and()
        .logout()
        .permitAll()
        .and()
        .httpBasic()
        .and()
        .csrf().disable();
  }
}
