package com.hex.shopec.config;

import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@SpringBootApplication(scanBasePackages={"com.hex.shopec.config","com.hex.shopec.restcontroller","com.hex.shopec.model","com.hex.shopec.repository","com.hex.shopec.service"})
@EnableJpaRepositories("com.hex.shopec.repository")
@EntityScan("com.hex.shopec.model")
public class ShopecApplication extends SpringBootServletInitializer {

 @Override
 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(ShopecApplication.class);
 }
 
 public static void main(String[] args) {
  SpringApplication.run(ShopecApplication.class, args);
 }
 
 
   @Configuration
   @EnableMBeanExport(defaultDomain="xxxxx")//<=======Replace xxxxx with your empID==========> 
   protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {


//   @Autowired
//   @Qualifier("customUserDetailsService")
//   UserDetailsService userDetailsService;  
     
//   /*@Autowired
//   private SECorsFilter corsFilter;
//   */
//   @Override
//   public void configure(WebSecurity web) throws Exception {
// 		super.configure(web);
// 	}
  
 
  @Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and()
		//.authenticationProvider(userDetailsService)
		 //.addFilterBefore(corsFilter, ChannelProcessingFilter.class)
		// starts authorizing configurations
		.authorizeRequests()
		// ignoring the guest's urls "
		.antMatchers("/GET/products").permitAll()
		// authenticate all remaining URLS
		.anyRequest().fullyAuthenticated();
     
	}
  	
  	@Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("HEAD",
                "GET", "POST", "PUT", "DELETE", "PATCH"));
        // setAllowCredentials(true) is important, otherwise:
        // The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*' when the request's credentials mode is 'include'.
        configuration.setAllowCredentials(true);
        // setAllowedHeaders is important! Without it, OPTIONS preflight request
        // will fail with 403 Invalid CORS request
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type","Origin","Accept","Location"));
        //configuration.setExposedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type","Origin","Accept","Location"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
  
    //  @Override
    //  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    //      auth.userDetailsService(userDetailsService);
    //  }
     
    //  @Autowired
    //  public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
    // 	 auth.userDetailsService(userDetailsService);
    //  }
     
  /*   @Bean
     protected MyCorsFilter  myCorsFilter() {
    	 return new MyCorsFilter();
     }*/
     
   
     
     

	// @SuppressWarnings("deprecation")
	// @Bean
	// public static NoOpPasswordEncoder passwordEncoder() {
	// 	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	// }
         
   }
 
   @Bean
   public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
 
}