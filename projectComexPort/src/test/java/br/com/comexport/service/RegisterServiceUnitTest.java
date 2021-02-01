package br.com.comexport.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.comexport.controller.RegisterController;
import br.com.comexport.dao.IRegisterDao;
import br.com.comexport.dto.RegisterDTO;
import br.com.comexport.model.Register;

@ExtendWith(MockitoExtension.class)
class RegisterServiceUnitTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterServiceUnitTest.class);
	
	@InjectMocks
	RegisterController controller;
	
	@Mock
	private RegisterService registerService;
	
	@Mock
	private IRegisterDao iRegister;
	
	
	@DisplayName("The testUpdateRegister method Tests whether the return message is the same as the expected message")
	@Test
	void testUpdateRegister() {
		LOGGER.info("Starting the testUpdateRegister Method");
		
		RegisterDTO registerDTO = new RegisterDTO();
		registerDTO.setId(1L);
		registerDTO.setDateOfBirth("2021-02-02");
		registerDTO.setEmail("test@comexport.com.br");
		registerDTO.setName("test name update");
		
		try {
			Mockito.doNothing().when(this.registerService).updateRegister(registerDTO);
			controller.putUpdateRegiter(registerDTO);
			Mockito.verify(this.registerService).updateRegister(registerDTO);			
		} catch (Exception e) {
			LOGGER.error("Error testUpdateRegister in Method: " + e);
		}
	}
	
	@DisplayName("The testListAllRegister method Tests whether the return value equals expected true")
	@Test
	void testListAllRegister() {
		LOGGER.info("Starting the testGetListRegiter Method");
				
		try {
			List<Register> expected = this.registerService.listAllRegister();
			assertEquals(expected.isEmpty(), true);
		} catch (Exception e) {
			LOGGER.error("Error testListAllRegister in Method: " + e);
		}
	}
	
	@DisplayName("The testDeleteRegister method Tests whether the return message is the same as the expected message")
	@Test
	void testDeleteRegister() {
		LOGGER.info("Starting the testDeleteRegister Method");
		
		Long id = 1L;
		
		try {			
			Mockito.doNothing().when(this.registerService).deleteRegister(id);
			this.controller.deleteRegiter(id);
			Mockito.verify(this.registerService).deleteRegister(id);
		} catch (Exception e) {
			LOGGER.error("Error testDeleteRegister in Method: " + e);
		}
	}

}
