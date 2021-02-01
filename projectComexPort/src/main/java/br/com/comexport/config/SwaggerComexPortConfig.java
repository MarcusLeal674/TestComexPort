package br.com.comexport.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerComexPortConfig extends WebMvcConfigurationSupport {
	
	private static final Set<String> DEFAULT_PRODUCES_COMEX_PORT = new HashSet<String>(Arrays.asList("application/json", "application/xml"));
	
	@Bean
	public Docket apiSwaggerComexPort() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("br.com.comexport.controller"))
		.paths(PathSelectors.any()).build().apiInfo(metaDataComexPort()).produces(DEFAULT_PRODUCES_COMEX_PORT)
		.consumes(DEFAULT_PRODUCES_COMEX_PORT);
	}
	
	private ApiInfo metaDataComexPort() {
		return new ApiInfoBuilder().title("ComexPort")
		.description("\"Company ComexPort \"").version("1.0.0").license("Apache License Version 2.0")
		.license("https://www.apache.org/licenses/LICENSE-2.0\"").build();
	}
	
	protected void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
		resourceHandlerRegistry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		resourceHandlerRegistry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

}
