package com.microservices.auth_service.Model.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.auth_service.Model.Pojo.OurUsers;

@Repository
public interface UserRepo extends JpaRepository<OurUsers, Integer>{
	//@Query(value="select * from ourusers where email=?1",nativeQuery = true)
	Optional<OurUsers>	findByEmail(String email);
}
