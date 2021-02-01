package br.com.comexport.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.comexport.model.Register;

@Repository
public interface IRegisterDao extends JpaRepository<Register, Long>{
	
	@Query(value = "SELECT * FROM register r WHERE r.email = :email", nativeQuery = true)
	List<Register> findByEmailRegister(@Param("email") String email);
	
	@Query(value = "SELECT * FROM register r WHERE r.name = :name", nativeQuery = true)
	List<Register> findByNameRegister(@Param("name") String name);
	
	@Query(value = "SELECT * FROM register r WHERE r.date_of_birth = :date_of_birth", nativeQuery = true)
	List<Register> findByDateOfBirthRegister(@Param("date_of_birth") String dateOfBirth);

}
