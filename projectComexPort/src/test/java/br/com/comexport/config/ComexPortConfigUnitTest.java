package br.com.comexport.config;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExtendWith(MockitoExtension.class)
class ComexPortConfigUnitTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ComexPortConfigUnitTest.class);
	
	@InjectMocks
	private ComexPortConfig comexPortConfig;
	
	
	@DisplayName("test if the TargetDataSource is not null")
	@Test
	void testTargetDataSource() {
		LOGGER.info("Starting the testTargetDataSource Method");
		
		try {
			DataSource testDataSource = this.comexPortConfig.dataSourceComexPort();
			assertNotNull(testDataSource);
		} catch (Exception e) {
			LOGGER.error("Error testTargetDataSource in Method: " + e);
		}
	}

}
