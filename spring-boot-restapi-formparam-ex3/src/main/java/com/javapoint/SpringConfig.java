package com.javapoint;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.javapoint")
public class SpringConfig extends WebMvcConfigurerAdapter{
	
		@Bean
		public ViewResolver viewResolver() {
			InternalResourceViewResolver viewres =  new InternalResourceViewResolver();
			viewres.setViewClass(JstlView.class);
			viewres.setPrefix("/WEB-INF/views/");
			viewres.setSuffix(".jsp");
			return viewres;
		}
		
		@Override
		public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	        configurer.enable();
	    }
		
	
}