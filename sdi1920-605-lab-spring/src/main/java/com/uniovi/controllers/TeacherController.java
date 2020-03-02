package com.uniovi.controllers;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uniovi.entities.Mark;
import com.uniovi.entities.Teacher;
import com.uniovi.services.TeacherService;
import com.uniovi.validators.TeachersValidator;

@Controller
public class TeacherController {

	@Autowired
	private TeacherService ts;
	@Autowired
	private TeachersValidator tv;
	
	@RequestMapping("/teacher/list")
	public String getList(Model model, Pageable pageable) {
		Page<Teacher> teachers = new PageImpl<Teacher>(new LinkedList<Teacher>());
		teachers = ts.getTeachers(pageable);
		model.addAttribute("teacherList", teachers.getContent());
		model.addAttribute("page", teachers);
		return "teacher/list";
	}
	
	@RequestMapping(value = "/teacher/add")
	public String getTeacher(Model model) {
		model.addAttribute("teacher", new Teacher());
		return "teacher/add";
	}

	@RequestMapping(value = "/teacher/add", method = RequestMethod.POST)
	public String setTeacher(@Validated Teacher teacher, BindingResult result) {
		tv.validate(teacher, result);
		if(result.hasErrors()) {
			return "teacher/add";
		}
		
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
