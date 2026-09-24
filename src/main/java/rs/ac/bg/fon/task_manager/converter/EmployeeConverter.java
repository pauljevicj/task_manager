package rs.ac.bg.fon.task_manager.converter;

import rs.ac.bg.fon.task_manager.dto.employee.EmployeeRequestDto;
import rs.ac.bg.fon.task_manager.dto.employee.EmployeeResponseDto;
import rs.ac.bg.fon.task_manager.entity.Employee;

public class EmployeeConverter implements Converter<Employee, EmployeeRequestDto, EmployeeResponseDto>{

    @Override
    public EmployeeResponseDto toResponse(Employee e) {
        return new EmployeeResponseDto(e.getId(), e.getFullName(), e.getEmail(), e.getPhoneNumber(), e.getDateOfBirth(), e.getSalary());
    }

    @Override
    public Employee toEntity(EmployeeRequestDto r) {
//        Employee employee = new Employee();
//        employee.setFullName(r.fullName());
//        employee.setEmail(r.email());
//        employee.setPhoneNumber(r.phoneNumber());
//        employee.setDateOfBirth(r.dateOfBirth());
//        employee.setSalary(r.salary());
//        return employee;
        return new Employee(r.fullName(), r.email(), r.phoneNumber(), r.dateOfBirth(), r.salary());
    }
}
