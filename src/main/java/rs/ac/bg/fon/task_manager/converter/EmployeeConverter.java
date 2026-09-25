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
        return new Employee(r.fullName(), r.email(), r.phoneNumber(), r.dateOfBirth(), r.salary());
    }

    public void update(Employee e, EmployeeRequestDto er){
        if(er == null)
            return;

        e.setFullName(er.fullName());
        e.setEmail(er.email());
        e.setPhoneNumber(er.phoneNumber());
        e.setDateOfBirth(er.dateOfBirth());
        e.setSalary(er.salary());
    }
}
