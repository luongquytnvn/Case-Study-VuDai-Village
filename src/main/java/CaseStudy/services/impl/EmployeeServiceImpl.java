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

    @Override
    public Page<Employee> findAllByNameContaining(String name, Pageable pageable) {
        return employeeRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public Page<Employee> findAllByAcademicLevel_Id(Long id, Pageable pageable) {
        return employeeRepository.findAllByAcademicLevel_Id(id, pageable);
    }

    @Override
    public Page<Employee> findAllByDepartment_Id(Long id, Pageable pageable) {
        return employeeRepository.findAllByDepartment_Id(id, pageable);
    }

    @Override
    public Page<Employee> findAllByLaborContract_Id(Long id, Pageable pageable) {
        return employeeRepository.findAllByLaborContract_Id(id, pageable);
    }

    @Override
    public Page<Employee> findAllByPosition_Id(Long id, Pageable pageable) {
        return employeeRepository.findAllByPosition_Id(id, pageable);
    }

}
