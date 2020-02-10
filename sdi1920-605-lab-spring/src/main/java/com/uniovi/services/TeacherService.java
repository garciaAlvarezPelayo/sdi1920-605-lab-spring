package com.uniovi.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Teacher;
import com.uniovi.repositories.TeacherRepository;
@Service
public class TeacherService {
	
	@Autowired
	private TeacherRepository teacherRepository;

	public List<Teacher> getTeachers() {
		List<Teacher> marks = new ArrayList<Teacher>();
		teacherRepository.findAll().forEach(marks::add);
		return marks;
	}

	public Teacher getTeacher(String id) {
		return teacherRepository.findById(id).get();
	}

	public void addTeacher(Teacher teacher) {
		teacherRepository.save(teacher);
	}

	public void deleteTeacher(String dni) {
		teacherRepository.deleteById(dni);
	}

	public void editTeacher(Teacher teacher, String dni2) {
		deleteTeacher(dni2);
		addTeacher(teacher);
	}
}
