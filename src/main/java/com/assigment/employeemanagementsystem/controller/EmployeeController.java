package com.assigment.employeemanagementsystem.controller;

import com.assigment.employeemanagementsystem.domain.Employee;
import com.assigment.employeemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // This means that this class is a Controller
public class EmployeeController {

	@Autowired
	// This means to get the bean which is auto-generated by Spring
	// We will use an employeeService for each
	EmployeeService employeeService;

	//	display list of employees
	@GetMapping("/")
	// This means that this method will be executed when user sends GET Requests to "/"
	// In our case, "http://localhost:8080/"
	public String viewHomePage(Model model) {

		//	We can use this attribute "listEmployees" to perform server-side rendering of the HTML with using Thymeleaf.
		//	We set all employees data as "listEmployees"
		model.addAttribute("listEmployees", employeeService.getAllEmployees());

		//		shows the index.html template:
		return "index";
	}

	//	showNewEmployeeForm
	@GetMapping("/showNewEmployeeForm")
	// This means that this method will be executed when user sends GET Requests to "/showNewEmployeeForm"
	// In our case,  "http://localhost:8080/showNewEmployeeForm"
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();

		// We can use this attribute "employee" to perform server-side rendering of the HTML with using Thymeleaf.
		// We set employee object as "employee"
		model.addAttribute("employee", employee);

		//	shows the new_employee.html template:
		return "new_employee";
	}

	//	add an employee
	@PostMapping("/saveEmployee")
	// This means that this method will be executed when user sends POST Requests to "/saveEmployee"
	// In our case, "http://localhost:8080/saveEmployee"
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		//	@ModelAttribute  binds the object called "employee" of request body from the POST request into the employee parameter of the saveEmployee() method.

		employeeService.saveEmployee(employee);

		// after save the employee data to database, redirect to "/"
		return "redirect:/";
	}

	//	show update form
	@GetMapping("/showFormForUpdate/{id}")
	// This means that this method will be executed when user sends GET Requests to "/showFormForUpdate/{employee's id}"
	// In our case, "http://localhost:8080/showFormForUpdate/{employee's id}"
	public String showUpdateForm(@PathVariable Long id, Model model) {
		// @PathVariable binds the {id} which the path of GET request contains into the id parameter of showUpdateForm() method.

		Employee employee = employeeService.getEmployeeById(id);

		//	We can use this attribute "employee" to perform server-side rendering of the HTML with using Thymeleaf.
		//	We set employee data as "employee"
		model.addAttribute("employee", employee);

		//	shows the update_employee.html template:
		return "update_employee";
	}

	//	delete the employee by id
	@GetMapping("/delete/{id}")
	// This means that this method will be executed when user sends GET Requests to "/delete/{employee's id}"
	//	In our case, "http://localhost:8080/delete/{employee's id}"
	public String deleteEmployeeById(@PathVariable Long id, Model model) {
		employeeService.deleteEmployeeById(id);

	//	after delete the employee data from database, redirect to "/"
		return "redirect:/";
	}
}
