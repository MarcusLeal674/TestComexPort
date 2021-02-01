package br.com.comexport.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.comexport.dao.IRegisterDao;
import br.com.comexport.dto.RegisterDTO;
import br.com.comexport.model.Register;

@Service
public class RegisterService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterService.class);

	@Autowired
	private IRegisterDao iRegister;

	public void saveRegister(RegisterDTO registerDTO) throws SQLException {
		LOGGER.info("Saving Register in Service");

		LocalDate localDateOfBirth = LocalDate.parse(registerDTO.getDateOfBirth());

		try {
			Register returnRegiter = new Register();
			returnRegiter.setName(registerDTO.getName());
			returnRegiter.setEmail(registerDTO.getEmail());
			returnRegiter.setDateOfBirth(localDateOfBirth);
			this.iRegister.save(returnRegiter);
		} catch (Exception e) {
			LOGGER.error("saveRegister method error: " + e);
		}
	}

	public void updateRegister(RegisterDTO registerDTO) throws SQLException {
		LOGGER.info("Updating Register in Service");

		LocalDate localDateOfBirth = LocalDate.parse(registerDTO.getDateOfBirth());

		try {
			Optional<Register> regiterBefore = this.iRegister.findById(registerDTO.getId());

			Register registerAfter = regiterBefore.get();
			if (regiterBefore.isPresent()) {
				
				if (!registerAfter.getEmail().equalsIgnoreCase(registerDTO.getEmail())) {
					registerAfter.setName(registerDTO.getName());
					registerAfter.setDateOfBirth(localDateOfBirth);
					registerAfter.setId(registerDTO.getId());
					
					this.iRegister.save(registerAfter);					
				} else {
					LOGGER.info("Email cannot be updated");
					throw new Exception("Email cannot be updated");
				}
			} else {
				LOGGER.error("The Register has not been update");
				throw new SQLException("The Register has not been update");
			}
		} catch (Exception e) {
			LOGGER.error("updateRegister method error: " + e);
		}

	}

	public List<Register> listAllRegister() throws SQLException {
		LOGGER.info("Searching for all Register in Service");

		List<Register> returnRegisterList = null;

		try {
			returnRegisterList = this.iRegister.findAll();
		} catch (Exception e) {
			LOGGER.error("listAllRegister method error: " + e);
		}

		return returnRegisterList;
	}

	public void deleteRegister(Long id) throws SQLException {
		LOGGER.info("Delete Register in Service");

		try {
			Optional<Register> regiterDelete = this.iRegister.findById(id);
			if (regiterDelete.isPresent()) {
				this.iRegister.delete(regiterDelete.get());
			} else {
				LOGGER.error("The Register has not been deleted");
				throw new SQLException("The Register has not been deleted");
			}
		} catch (Exception e) {
			LOGGER.error("deleteRegister method error: " + e);
		}
	}

	public List<Register> findRegisterEmail(String email) throws SQLException {
		LOGGER.info("Searching findRegisterEmail in Service");

		List<Register> returnRegister = null;

		try {
			List<Register> regiterObject = this.iRegister.findByEmailRegister(email);
			
			if (!regiterObject.isEmpty()) {
				returnRegister = regiterObject;						
			} else {
				LOGGER.error("User with this email does not exist");
				throw new SQLException("User with this email does not exist");
			}
		} catch (Exception e) {
			LOGGER.error("findRegisterEmail method error: " + e);
		}
		return returnRegister;
	}
	
	public List<Register> findRegisterName(String name) throws SQLException {
		LOGGER.info("Searching findRegisterName in Service");

		List<Register> returnRegister = null;

		try {
			List<Register> regiterObject = this.iRegister.findByNameRegister(name);
			
			if (!regiterObject.isEmpty()) {
				returnRegister = regiterObject;						
			} else {
				LOGGER.error("Name cannot be changed");
				throw new SQLException("Name cannot be changed");
			}
		} catch (Exception e) {
			LOGGER.error("findRegisterName method error: " + e);
		}
		return returnRegister;
	}
	
	public List<Register> findRegisterDateOfBirth(String dateOfBirth) throws SQLException {
		LOGGER.info("Searching findRegisterEmail in Service");

		List<Register> returnRegister = null;

		try {
			List<Register> regiterObject = this.iRegister.findByDateOfBirthRegister(dateOfBirth);
			
			if (!regiterObject.isEmpty()) {
				returnRegister = regiterObject;				
			} else {
				LOGGER.error("DateOfBirth cannot be changed");
				throw new SQLException("DateOfBirth cannot be changed");
			}			
		} catch (Exception e) {
			LOGGER.error("findRegisterDateOfBirth method error: " + e);
		}
		return returnRegister;
	}
}
