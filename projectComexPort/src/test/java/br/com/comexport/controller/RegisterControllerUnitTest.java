package br.com.comexport.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import br.com.comexport.dto.RegisterDTO;
import br.com.comexport.model.Register;
import br.com.comexport.service.RegisterService;

@ExtendWith(MockitoExtension.class)
class RegisterControllerUnitTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterControllerUnitTest.class);
	
	@InjectMocks
	private RegisterController registerController;
	
	@Mock
	private RegisterService registerService;
		
	
	@DisplayName("The testPostSaveRegiter method Tests whether the return message is the same as the expected message")
	@Test
	void testPostSaveRegiter() {
		LOGGER.info("Starting the testPostSaveRegiter Method");
		
		String actual = "Registered Successfully!";
		
		RegisterDTO registerDTO = new RegisterDTO();
		registerDTO.setDateOfBirth("2021-02-01");
		registerDTO.setEmail("test@comexport.com.br");
		registerDTO.setName("test name");
		
		try {
			ResponseEntity<ResponseEntity<String>> expected = this.registerController.postSaveRegiter(registerDTO);
			assertEquals(expected.getBody().getBody(), actual);
		} catch (Exception e) {
			LOGGER.error("Error testPostSaveRegiter in Method: " + e);
		}
	}
	
	@DisplayName("The testPutUpdateRegiter method Tests whether the return message is the same as the expected message")
	@Test
	void testPutUpdateRegiter() {
		LOGGER.info("Starting the testPutUpdateRegiter Method");
		
		String actual = "Successfully updated";
		
		RegisterDTO registerDTO = new RegisterDTO();
		registerDTO.setDateOfBirth("2021-02-02");
		registerDTO.setEmail("test@comexport.com.br");
		registerDTO.setName("test name update");
		
		try {
			ResponseEntity<ResponseEntity<String>> expected = this.registerController.putUpdateRegiter(registerDTO);
			assertEquals(expected.getBody().getBody(), actual);
		} catch (Exception e) {
			LOGGER.error("Error testPutUpdateRegiter in Method: " + e);
		}
	}
	
	@DisplayName("The testGetListRegiter method Tests whether the return value is the same as the expected message")
	@Test
	void testGetListRegiter() {
		LOGGER.info("Starting the testGetListRegiter Method");
		
		int actual = 200;
		
		try {
			ResponseEntity<ResponseEntity<List<Register>>> expected = this.registerController.getListRegiter();
			assertEquals(expected.getBody().getStatusCode().value(), actual);
		} catch (Exception e) {
			LOGGER.error("Error testGetListRegiter in Method: " + e);
		}
	}
	
	@DisplayName("The testDeleteRegiter method Tests whether the return message is the same as the expected message")
	@Test
	void testDeleteRegiter() {
		LOGGER.info("Starting the testDeleteRegiter Method");
		
		Long id = 1L;
		String actual = "Successfully deleted!";
		
		try {
			ResponseEntity<ResponseEntity<String>> expected = this.registerController.deleteRegiter(id);
			assertEquals(expected.getBody().getBody(), actual);
		} catch (Exception e) {
			LOGGER.error("Error testDeleteRegiter in Method: " + e);
		}
	}
	
	@DisplayName("The testGetRegiterFindEmail method Tests whether the return value is the same as the expected message")
	@Test
	void testGetRegiterFindEmail() {
		LOGGER.info("Starting the testGetRegiterFindEmail Method");
		
		String email = "test@comexport.com.br";
		int actual = 406;
		
		try {
			ResponseEntity<ResponseEntity<List<Register>>> expected = this.registerController.getRegiterFindEmail(email);
			assertEquals(expected.getBody().getStatusCode().value(), actual);
		} catch (Exception e) {
			LOGGER.error("Error testGetRegiterFindEmail in Method: " + e);
		}
	}
	
	@DisplayName("The testGetRegiterFindDateOfBirth method Tests whether the return value is the same as the expected message")
	@Test
	void testGetRegiterFindDateOfBirth() {
		LOGGER.info("Starting the testGetRegiterFindDateOfBirth Method");
		
		String dateOfBirth = "2021-02-01";
		int actual = 406;
				
		try {
			ResponseEntity<ResponseEntity<List<Register>>> expected = this.registerController.getRegiterFindDateOfBirth(dateOfBirth);
			assertEquals(expected.getBody().getStatusCode().value(), actual);
		} catch (Exception e) {
			LOGGER.error("Error testGetRegiterFindDateOfBirth in Method: " + e);
		}
	}
	
	@DisplayName("The testGetRegiterFindName method Tests whether the return value is the same as the expected message")
	@Test
	void testGetRegiterFindName() {
		LOGGER.info("Starting the testGetRegiterFindName Method");
		
		String name = "test name";
		int actual = 406;
		
		try {
			ResponseEntity<ResponseEntity<List<Register>>> expected = this.registerController.getRegiterFindName(name);
			assertEquals(expected.getBody().getStatusCode().value(), actual);
		} catch (Exception e) {
			LOGGER.error("Error testGetRegiterFindName in Method: " + e);
		}
	}

}
