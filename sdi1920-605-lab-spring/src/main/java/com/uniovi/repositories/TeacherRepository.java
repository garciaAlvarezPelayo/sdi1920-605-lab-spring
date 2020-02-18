package com.uniovi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.uniovi.entities.Teacher;
import com.uniovi.entities.User;

public interface TeacherRepository extends CrudRepository<Teacher, String>{
	Teacher findByDni(String dni);
}
