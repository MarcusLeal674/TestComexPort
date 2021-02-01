package br.com.comexport.config;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import springfox.documentation.spring.web.plugins.Docket;

@ExtendWith(MockitoExtension.class)
class SwaggerComexPortConfigUnitTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SwaggerComexPortConfigUnitTest.class);
	
	@InjectMocks
	private SwaggerComexPortConfig swaggerComexPortConfig;
	

	@DisplayName("test if the ApiSwaggerComexPort is not null")
	@Test
	void testApiSwaggerComexPort() {
		LOGGER.info("Starting the testApiSwaggerComexPort Method");
		
		try {
			Docket testDocket = this.swaggerComexPortConfig.apiSwaggerComexPort();
			assertNotNull(testDocket);
		} catch (Exception e) {
			LOGGER.error("Error testApiSwaggerComexPort in Method: " + e);
		}
	}

}
