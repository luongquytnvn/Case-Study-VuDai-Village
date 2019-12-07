package CaseStudy.validation;

import CaseStudy.models.Employee;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EmployeeValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"dateOfBirth","dateOfBirth.empty","Date Of Birth must not be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"phoneNumber","phoneNumber.empty","Phone Number must not be empty");
        Employee employee = (Employee) target;
        String regex = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        if (!employee.getPhoneNumber().matches(regex)) {
            errors.rejectValue("phoneNumber", "phoneNumber.error","Phone number is not VietNam number phone");
        }
    }
}
