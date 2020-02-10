package com.uniovi.services;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.uniovi.entities.Teacher;
@Service
public class TeacherService {
	private List<Teacher> teachersList = new LinkedList<Teacher>();

	@PostConstruct
	public void init() {
		teachersList.add(new Teacher("1", "1", "1", "1"));
		teachersList.add(new Teacher("2", "2", "2", "2"));
	}

	public List<Teacher> getTeachers() {
		return teachersList;
	}

	public Teacher getTeacher(String id) {
		return teachersList.stream().filter(mark -> mark.getDni().equals(id)).findFirst().get();
	}

	public void addTeacher(Teacher teacher) {
		// Si en Id es null le asignamos el ultimo + 1 de la lista
		if (teacher.getDni() == null) {
			teacher.setDni(teachersList.get(teachersList.size() - 1).getDni() + 1);
		}

		teachersList.add(teacher);
	}

	public void deleteTeacher(String dni) {
		teachersList.removeIf(teacher -> teacher.getDni().equals(dni));
	}

	public void editTeacher(Teacher teacher, String dni2) {
		deleteTeacher(dni2);
		addTeacher(teacher);
	}
}
