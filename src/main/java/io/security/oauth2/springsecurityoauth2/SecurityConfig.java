package io.security.oauth2.springsecurityoauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//어노테이션 둘 다 가능! Bean을 만들기 때문에~!
//@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated();
        http.formLogin();
        http.httpBasic();
        http.exceptionHandling().authenticationEntryPoint(new AuthenticationEntryPoint() {  //custom 한 entrypoint가 우선임!
            @Override
            public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
                System.out.println("custom entryPoint");
            }
        });

//        CustomSecurityConfigurer customSecurityConfigurer = new CustomSecurityConfigurer();
//        customSecurityConfigurer.setFlag(true);

//        http.apply(new CustomSecurityConfigurer().setFlag(false));
        return http.build();
    }

//    @Bean
//    SecurityFilterChain securityFilterChain2(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().authenticated();
//        http.httpBasic();
////        CustomSecurityConfigurer customSecurityConfigurer = new CustomSecurityConfigurer();
////        customSecurityConfigurer.setFlag(true);
////        http.apply(new CustomSecurityConfigurer().setFlag(false));
//        return http.build();
//    }


}
