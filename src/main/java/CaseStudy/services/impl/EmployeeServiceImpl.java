package CaseStudy.services.impl;

import CaseStudy.models.Employee;
import CaseStudy.repositories.EmployeeRepository;
import CaseStudy.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.delete(id);
    }
    public List<Employee> findByName(String search, Pageable pageable){
        Page<Employee> employees = employeeRepository.findAll(pageable);
        List<Employee> results = new ArrayList<>();
        for (Employee e: employees) {
            if (e.getName().toLowerCase().contains(search.toLowerCase()))
            results.add(e);
        }
        return results;
    }
}
