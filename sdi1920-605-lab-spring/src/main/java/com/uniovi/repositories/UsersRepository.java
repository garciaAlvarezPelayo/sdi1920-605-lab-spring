package com.uniovi.repositories;

import com.uniovi.entities.*;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long> {
	User findByDni(String dni);

	@Query("select r from User r where (LOWER(r.lastName) like lower(?1) or lower(r.name) like lower(?1))")
	List<User> searchBySurnameAndName(String searchText);

}
