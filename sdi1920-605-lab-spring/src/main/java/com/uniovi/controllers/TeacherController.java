package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uniovi.entities.Mark;
import com.uniovi.entities.Teacher;
import com.uniovi.services.TeacherService;

@Controller
public class TeacherController {

	@Autowired
	private TeacherService ts;
	
	@RequestMapping("/teacher/list")
	public String getList(Model model) {
		model.addAttribute("teacherList", ts.getTeachers());
		return "teacher/list";
	}
	
	@RequestMapping(value = "/teacher/add")
	public String getTeacher() {
		return "teacher/add";
	}

	@RequestMapping(value = "/teacher/add", method = RequestMethod.POST)
	public String setTeacher(@ModelAttribute Teacher teacher) {
		ts.addTeacher(teacher);
		return "redirect:/teacher/list";
	}

	@RequestMapping("/teacher/details")
	public String getDetail(@RequestParam String dni) {
		return "teacher/list";
	}
	
	@RequestMapping("/teacher/delete/{dni}")
	public String deleteMark(@PathVariable String dni) {
		ts.deleteTeacher(dni);
		return "redirect:/teacher/list";
	}
	
	@RequestMapping(value="/teacher/edit")
	public String editTeacher(@RequestParam String dni2 ,@RequestParam String dni1, @RequestParam String name, @RequestParam String surname, @RequestParam String category) {
		return "teacher/list";
	}
	
	
	
}
