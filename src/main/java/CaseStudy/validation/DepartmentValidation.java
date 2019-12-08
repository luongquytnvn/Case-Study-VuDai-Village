package CaseStudy.validation;

import CaseStudy.models.Department;
import CaseStudy.models.Employee;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class DepartmentValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Department.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"departmentPhone","phoneNumber.empty","Phone Number must not be empty");
        Department department = (Department) target;
        String regex = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        if (!department.getDepartmentPhone().matches(regex)) {
            errors.rejectValue("departmentPhone", "phoneNumber.error","Phone number is not VietNam number phone");
        }
    }
}
