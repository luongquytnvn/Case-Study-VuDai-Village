package CaseStudy.controllers;

import CaseStudy.models.Department;
import CaseStudy.models.Employee;
import CaseStudy.services.DepartmentService;
import CaseStudy.services.EmployeeService;
import CaseStudy.validation.DepartmentValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/admin/department-list")
    public String departmentList(Model model, @PageableDefault(size = 5) Pageable pageable) {
        Page<Department> departments = departmentService.findAll(pageable);
        model.addAttribute("department", departments);
        return "department/list";
    }

    @GetMapping("/admin/create-department")
    public String showFormCreate(Model model) {
        model.addAttribute("department", new Department());
        return "department/create";
    }

    @PostMapping("/admin/create-department")
    public String saveCreate(Model model, @Validated Department department, BindingResult bindingResult) {
        new DepartmentValidation().validate(department, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/department/create";
        }
        departmentService.save(department);
        model.addAttribute("department", new Department());
        model.addAttribute("message", "Create success a new department");
        return "/department/create";
    }

    @GetMapping("/admin/edit-department/{id}")
    public String showFormEdit(Model model, @PathVariable Long id) {
        Department department = departmentService.findById(id);
        model.addAttribute("department", department);
        return "/department/edit";
    }

    @PostMapping("/admin/edit-department")
    public String saveEdit(Model model,@Validated Department department, BindingResult bindingResult) {
        new DepartmentValidation().validate(department, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/department/edit";
        }
        departmentService.save(department);
        model.addAttribute("department", department);
        model.addAttribute("message", "Edit success department");
        return "/department/edit";
    }

    @GetMapping("/admin/delete-department/{id}")
    public String showFormDelete(Model model, @PathVariable Long id) {
        Department department = departmentService.findById(id);
        model.addAttribute("department", department);
        return "/department/delete";
    }

    @PostMapping("/admin/delete-department")
    public String deleteDepartment(Department department, Pageable pageable, Model model) {
        Page<Employee> employees = employeeService.findAllByDepartment_Id(department.getId(),pageable);
        if (employees.hasContent()) {
            model.addAttribute("department", departmentService.findById(department.getId()));
            model.addAttribute("message", "You must remove the employee associated with this field");
            return "/department/delete";
        }
        departmentService.remove(department.getId());
        return "redirect:/admin/department-list";
    }

    @PostMapping("/admin/department-search")
    public String searchDepartment(Model model, Optional<String> search, @PageableDefault(size = 5) Pageable pageable) {
        if (!search.isPresent()) {
            return "redirect:/admin/department-list";
        }
        Page<Department> departments = departmentService.findAllByNameContaining(search.get(), pageable);
        model.addAttribute("department", departments);
        return "department/list";
    }
}



