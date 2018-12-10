
package com.hex.shopec.config;

import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//BEGIN GENERATED CODE
// CHECKSTYLE:OFF
/*
Component
*/
@SpringBootApplication(scanBasePackages = { "com.hex.shopec.config", "com.hex.shopec.restcontroller",
        "com.hex.shopec.model", "com.hex.shopec.repository", "com.hex.shopec.service" })
@EnableJpaRepositories("com.hex.shopec.repository")
/*
Component
*/
@EntityScan("com.hex.shopec.model")
public class ShopecApplication extends SpringBootServletInitializer {

    @Override
    /*
    Component
    */
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(ShopecApplication.class);
    }

    /*
    Component
    */
    public static void main(final String[] args) {
        SpringApplication.run(ShopecApplication.class, args);
    }

    /*
    Component
    */
    @Configuration
    //@Order(1)
    protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
        /*
        Component
        */
        @Autowired
        @Qualifier("customUserDetailsService")
        private UserDetailsService userDetailsService;

        /*@Autowired
        private SECorsFilter corsFilter;
        */
        @Override
        /*
        Component
        */
        public void configure(final WebSecurity web) throws Exception {
            super.configure(web);
        }

        /*
        Component
        */
        @Override
        protected void configure(final HttpSecurity http) throws Exception {
            http.cors().and()
                    //.authenticationProvider(userDetailsService)
                    //.addFilterBefore(corsFilter, ChannelProcessingFilter.class)
                    // starts authorizing configurations
                    .authorizeRequests()
                    // ignoring the guest's urls "
                    .antMatchers("/products/list", "/order/create", "/account/login").permitAll()
                    // authenticate all remaining URLS
                    .anyRequest().fullyAuthenticated().and()
                    /* "/logout" will log the user out by invalidating the HTTP Session,
                    * cleaning up any {link rememberMe()} authentication that was configured, */
                    .logout().permitAll().logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST")).and()
                    .formLogin().and().httpBasic().authenticationEntryPoint(loginUrlauthenticationEntryPoint()).and()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).and()
                    // disabling the CSRF - Cross Site Request Forgery
                    .csrf().disable(); //.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        }

        /*
        Component
        @return model 
        */
        @Bean
        public CorsConfigurationSource corsConfigurationSource() {
            final CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowedOrigins(Arrays.asList("*"));
            configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH"));
            // setAllowCredentials(true) is important, otherwise:
            // The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*'
            //when the request's credentials mode is 'include'.
            configuration.setAllowCredentials(true);
            // setAllowedHeaders is important! Without it, OPTIONS preflight request
            // will fail with 403 Invalid CORS request
            configuration.setAllowedHeaders(
                    Arrays.asList("Authorization", "Cache-Control", "Content-Type", "Origin", "Accept", "Location"));
            //configuration.setExposedHeaders(Arrays.asList("Authorization", "Cache-Control",
            //"Content-Type","Origin","Accept","Location"));
            final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", configuration);
            return source;
        }

        /*
        @param auth.
        Component
        @return model
        */
        @Override
        public void configure(final AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService);
        }

        /*
        Component
        @return model
        */
        @Autowired
        public void configureGlobalSecurity(final AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService);
        }

        /*   @Bean
           protected MyCorsFilter  myCorsFilter() {
          	 return new MyCorsFilter();
           }*/
        /*
        Component
        @return model
        */
        @Bean
        public AuthenticationEntryPoint loginUrlauthenticationEntryPoint() {
            return new LoginUrlAuthenticationEntryPoint("/account/login");
        }

        @SuppressWarnings("deprecation")
        /*
        model Mapper
        @return model
        */
        @Bean
        public static NoOpPasswordEncoder passwordEncoder() {
            return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
        }

    }

    /*
    * Mapper.
    * @return ModelMapper.
    */
    @Bean
    public final ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
//END GENERATED CODE