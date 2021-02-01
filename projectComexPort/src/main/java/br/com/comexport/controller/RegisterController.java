package br.com.comexport.controller;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.comexport.dto.RegisterDTO;
import br.com.comexport.model.Register;
import br.com.comexport.service.RegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/comexport")
@Api(value = "Register")
public class RegisterController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterController.class);
	
	@Autowired
	private RegisterService registerService;
	
	@ApiOperation(value = "Saving Register")
	@PostMapping()
	public ResponseEntity<ResponseEntity<String>> postSaveRegiter(@RequestBody @Valid RegisterDTO registerDTO) {
		LOGGER.info("Saving Register in Controller");
		
		ResponseEntity<ResponseEntity<String>> returnResponseEntity = null;
		
		try {
			this.registerService.saveRegister(registerDTO);
			ResponseEntity<String> body = new ResponseEntity<String>("Registered Successfully!", HttpStatus.CREATED);
			returnResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(body);			
		} catch (SQLException e) {
			LOGGER.error("Error in postSaveRegiter: " + e);
			ResponseEntity<String> body = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
			returnResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);		
		}
		
		return returnResponseEntity;
	}
	
	@ApiOperation(value = "Updates the Register")
	@PutMapping()
	public ResponseEntity<ResponseEntity<String>> putUpdateRegiter(@RequestBody @Valid RegisterDTO registerDTO) {
		LOGGER.info("Update Register in Controller");
		
		ResponseEntity<ResponseEntity<String>> returnResponseEntity = null;
		
		try {
			this.registerService.updateRegister(registerDTO);
			ResponseEntity<String> body = new ResponseEntity<String>("Successfully updated", HttpStatus.OK);
			returnResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(body);			
		} catch (SQLException e) {
			LOGGER.error("Error in putUpdateRegiter: " + e);
			ResponseEntity<String> body = new ResponseEntity<String>("Email cannot be updated", HttpStatus.UNAUTHORIZED);
			returnResponseEntity = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(body);	
		}
		
		return returnResponseEntity;
	}
	
	@ApiOperation(value = "Listing all the Register")
	@GetMapping("/list")
	public ResponseEntity<ResponseEntity<List<Register>>> getListRegiter() {
		LOGGER.info("List Register in Controller");
		
		 ResponseEntity<ResponseEntity<List<Register>>> returnResponseEntityList = null;
		 List<Register> objectRegisterList = null;
		
		try {
			objectRegisterList = this.registerService.listAllRegister();
			ResponseEntity<List<Register>> body = new  ResponseEntity<List<Register>>(objectRegisterList, HttpStatus.OK);
			returnResponseEntityList = ResponseEntity.status(HttpStatus.CREATED).body(body);			
		} catch (SQLException e) {
			LOGGER.error("Error in getListRegiter: " + e);
			ResponseEntity<List<Register>> body = new ResponseEntity<List<Register>>(objectRegisterList, HttpStatus.NOT_FOUND);
			returnResponseEntityList = ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);	
		}
		
		return returnResponseEntityList;
	}
	
	@ApiOperation(value = "Listing all the Register")
	@DeleteMapping()
	public ResponseEntity<ResponseEntity<String>> deleteRegiter(Long id) {
		LOGGER.info("List Register in Controller");
		
		String msgDelete = "Successfully deleted!";	
		ResponseEntity<ResponseEntity<String>> returnResponseEntityDelete = null;
		
		try {
			this.registerService.deleteRegister(id);
			ResponseEntity<String> body = new  ResponseEntity<String>(msgDelete, HttpStatus.OK);
			returnResponseEntityDelete = ResponseEntity.status(HttpStatus.OK).body(body);			
		} catch (SQLException e) {
			LOGGER.error("Error in getListRegiter: " + e);
			ResponseEntity<String> body = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
			returnResponseEntityDelete = ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);	
		}
		
		return returnResponseEntityDelete;
	}
	
	@ApiOperation(value = "Search Registration by email")
	@GetMapping("/findemail")
	public ResponseEntity<ResponseEntity<List<Register>>> getRegiterFindEmail(String email) {
		LOGGER.info("Searching Register in Controller");
		
		ResponseEntity<ResponseEntity<List<Register>>> returnResponseEntityFind = null;
		List<Register> registerObject = null;
		
		try {
			registerObject = this.registerService.findRegisterEmail(email);
			
			if (!registerObject.isEmpty()) {
				ResponseEntity<List<Register>> body = new  ResponseEntity<List<Register>>(registerObject, HttpStatus.OK);
				returnResponseEntityFind = ResponseEntity.status(HttpStatus.OK).body(body);				
			} else {
				LOGGER.info("User with this email does not exist in Controller");
				ResponseEntity<List<Register>> body = new ResponseEntity<List<Register>>(registerObject, HttpStatus.NOT_ACCEPTABLE);
				returnResponseEntityFind = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(body);	
			}
		} catch (SQLException e) {
			LOGGER.error("Error in getRegiterFindEmail: " + e);
			ResponseEntity<List<Register>> body = new ResponseEntity<List<Register>>(registerObject, HttpStatus.NOT_FOUND);
			returnResponseEntityFind = ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);	
		}
		
		return returnResponseEntityFind;
	}
	
	@ApiOperation(value = "Search Registration by name")
	@GetMapping("/findname")
	public ResponseEntity<ResponseEntity<List<Register>>> getRegiterFindName(String name) {
		LOGGER.info("Searching Register in Controller");
		
		ResponseEntity<ResponseEntity<List<Register>>> returnResponseEntityFind = null;
		List<Register> registerObject = null;
		
		try {
			registerObject = this.registerService.findRegisterEmail(name);
			
			if (!registerObject.isEmpty()) {
				ResponseEntity<List<Register>> body = new  ResponseEntity<List<Register>>(registerObject, HttpStatus.OK);
				returnResponseEntityFind = ResponseEntity.status(HttpStatus.OK).body(body);				
			} else {
				LOGGER.info("User with this name does not exist in Controller");
				ResponseEntity<List<Register>> body = new ResponseEntity<List<Register>>(registerObject, HttpStatus.NOT_ACCEPTABLE);
				returnResponseEntityFind = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(body);	
			}
		} catch (SQLException e) {
			LOGGER.error("Error in getRegiterFindName: " + e);
			ResponseEntity<List<Register>> body = new ResponseEntity<List<Register>>(registerObject, HttpStatus.NOT_FOUND);
			returnResponseEntityFind = ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);	
		}
		
		return returnResponseEntityFind;
	}
	
	@ApiOperation(value = "Search Registration by dateOfBirth")
	@GetMapping("/finddateofbirth")
	public ResponseEntity<ResponseEntity<List<Register>>> getRegiterFindDateOfBirth(String dateOfBirth) {
		LOGGER.info("Searching getRegiterFindDateOfBirth in Controller");
		
		ResponseEntity<ResponseEntity<List<Register>>> returnResponseEntityFind = null;
		List<Register> registerObject = null;
		
		try {
			registerObject = this.registerService.findRegisterDateOfBirth(dateOfBirth);
			
			if (!registerObject.isEmpty()) {
				ResponseEntity<List<Register>> body = new  ResponseEntity<List<Register>>(registerObject, HttpStatus.OK);
				returnResponseEntityFind = ResponseEntity.status(HttpStatus.OK).body(body);				
			} else {
				LOGGER.info("User with this dateOfBirth does not exist in Controller");
				ResponseEntity<List<Register>> body = new ResponseEntity<List<Register>>(registerObject, HttpStatus.NOT_ACCEPTABLE);
				returnResponseEntityFind = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(body);	
			}
		} catch (SQLException e) {
			LOGGER.error("Error in getRegiterFindDateOfBirth: " + e);
			ResponseEntity<List<Register>> body = new ResponseEntity<List<Register>>(registerObject, HttpStatus.NOT_FOUND);
			returnResponseEntityFind = ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);	
		}
		
		return returnResponseEntityFind;
	}
	
	
}
