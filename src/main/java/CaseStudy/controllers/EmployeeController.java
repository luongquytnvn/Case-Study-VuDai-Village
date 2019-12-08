package CaseStudy.controllers;

import CaseStudy.models.*;
import CaseStudy.services.*;
import CaseStudy.validation.EmployeeValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AcademicLevelService academicLevelService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private LaborContractService laborContractService;
    @Autowired
    private PositionService positionService;

    @ModelAttribute("academicLevels")
    public Page<AcademicLevel> academicLevels(Pageable pageable) {
        return academicLevelService.findAll(pageable);
    }

    @ModelAttribute("departmentsList")
    public Page<Department> departments(Pageable pageable) {
        return departmentService.findAll(pageable);
    }

    @ModelAttribute("laborContracts")
    public Page<LaborContract> laborContracts(Pageable pageable) {
        return laborContractService.findAll(pageable);
    }

    @ModelAttribute("positions")
    public Page<Position> positions(Pageable pageable) {
        return positionService.findAll(pageable);
    }

    @GetMapping("/admin/employee-list")
    public String employeeList(Model model, @PageableDefault(size = 10) Pageable pageable) {
        Page<Employee> employees = employeeService.findAll(pageable);
        model.addAttribute("employees", employees);
        return "employee/list";
    }

    @GetMapping("/admin/employee-list-sort")
    public String employeeListSort(Model model, @RequestParam Optional<String> sortBy, Optional<String> direction) {
        if (sortBy.get().equals("default")) {
            return "redirect:/admin/employee-list";
        }
        String sort = sortBy.get();
        Pageable pageable = new PageRequest(0, 100, new Sort(Sort.Direction.valueOf(direction.get()), sort));
        Page<Employee> employees = employeeService.findAll(pageable);
        model.addAttribute("employees", employees);
        return "employee/list";
    }

    @GetMapping("/admin/employee-list-name")
    public String employeeListName(Model model, @PageableDefault(size = 10, sort = "name") Pageable pageable) {
        Page<Employee> employees = employeeService.findAll(pageable);
        model.addAttribute("employees", employees);
        return "employee/list";
    }

    @GetMapping("/admin/employee-list-salary")
    public String employeeListNameSalary(Model model, @PageableDefault(size = 10, sort = "salary") Pageable pageable) {
        Page<Employee> employees = employeeService.findAll(pageable);
        model.addAttribute("employees", employees);
        return "employee/list";
    }


    @GetMapping("/admin/employee-create")
    public String employeeCreate(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }

    @PostMapping("/admin/employee-create")
    public String employeeCreate(Model model, @Validated Employee employee, BindingResult bindingResult) {
        new EmployeeValidation().validate(employee, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "employee/create";
        }
        employeeService.save(employee);
        model.addAttribute("employee", new Employee());
        model.addAttribute("message", "Created new employee");
        return "employee/create";
    }

    @GetMapping("/admin/employee-edit/{id}")
    public String employeeEdit(@PathVariable Long id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employee/edit";
    }

    @PostMapping("/admin/employee-edit")
    public String employeeEdit(@Validated Employee employee, BindingResult bindingResult, Model model) {
        new EmployeeValidation().validate(employee, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "employee/edit";
        }
        employeeService.save(employee);
        model.addAttribute("employee", employeeService.findById(employee.getId()));
        model.addAttribute("message", "Edited employee");
        return "employee/edit";
    }

    @GetMapping("/admin/employee-delete/{id}")
    public String employeeDelete(@PathVariable Long id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employee/delete";
    }

    @PostMapping("/admin/employee-delete")
    public String employeeDelete(Employee employee, RedirectAttributes redirectAttributes) {
        employeeService.delete(employee.getId());
        redirectAttributes.addFlashAttribute("message", "Deleted employee");
        return "redirect:/admin/employee-list";
    }

    @PostMapping("/admin/employee-search")
    public String employeeSearch(Optional<String> search, Model model, Pageable pageable) {
        if (search.isPresent()) {
            Page<Employee> employees = employeeService.findAllByNameContaining(search.get(), pageable);
            model.addAttribute("employees", employees);
            return "employee/list";
        }
        return "redirect:/admin/employee-list";
    }

    @GetMapping("/admin/employee-view/{id}")
    public String employeeView(@PathVariable Long id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employee/view";
    }
    @GetMapping("/admin/employee-findAllByAcademicLevel/{id}")
    public String findAllByAcademicLevel_Id(@PathVariable Long id, Pageable pageable,Model model) {
        Page<Employee> employees = employeeService.findAllByAcademicLevel_Id(id, pageable);
        model.addAttribute("employees", employees);
        return "employee/list";
    }
    @GetMapping("/admin/employee-findAllByDepartment/{id}")
    public String findAllByDepartment_Id(@PathVariable Long id, Pageable pageable,Model model) {
        Page<Employee> employees = employeeService.findAllByDepartment_Id(id, pageable);
        model.addAttribute("employees", employees);
        return "employee/list";
    }
    @GetMapping("/admin/employee-findAllByLaborContract/{id}")
    public String findAllByLaborContract_Id(@PathVariable Long id, Pageable pageable,Model model) {
        Page<Employee> employees = employeeService.findAllByLaborContract_Id(id, pageable);
        model.addAttribute("employees", employees);
        return "employee/list";
    }
    @GetMapping("/admin/employee-findAllByPosition/{id}")
    public String findAllByPosition_Id(@PathVariable Long id, Pageable pageable,Model model) {
        Page<Employee> employees = employeeService.findAllByPosition_Id(id, pageable);
        model.addAttribute("employees", employees);
        return "employee/list";
    }
}
