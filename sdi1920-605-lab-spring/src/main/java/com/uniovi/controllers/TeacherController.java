package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.entities.Teacher;
import com.uniovi.services.TeacherService;

@RestController
public class TeacherController {

	@Autowired
	private TeacherService ts;
	
	@RequestMapping("/teacher/list")
	public String getList() {
		return ts.getTeachers().toString();
	}

	@RequestMapping(value="/teacher/add")
	public String setTeacher(@RequestParam String dni, @RequestParam String name, @RequestParam String surname, @RequestParam String category) {
		Teacher teacher = new Teacher(dni, name, surname, category);
		ts.addTeacher(teacher);
		return "Ok";
	}

	@RequestMapping("/teacher/details")
	public String getDetail(@RequestParam String dni) {
		return ts.getTeacher(dni).toString();
	}
	
	@RequestMapping("/teacher/delete")
	public String deleteTeacher(@RequestParam String dni) {
		ts.deleteTeacher(dni);
		return "Ok";
	}
	
	@RequestMapping(value="/teacher/edit")
	public String editTeacher(@RequestParam String dni2 ,@RequestParam String dni1, @RequestParam String name, @RequestParam String surname, @RequestParam String category) {
		Teacher teacher = new Teacher(dni1, name, surname, category);
		ts.editTeacher(teacher, dni2);
		return "Ok";
	}
	
	
	
}
