package rs.ac.bg.fon.task_manager.service;

import org.springframework.stereotype.Service;
import rs.ac.bg.fon.task_manager.converter.EmployeeConverter;
import rs.ac.bg.fon.task_manager.dto.employee.EmployeeRequestDto;
import rs.ac.bg.fon.task_manager.dto.employee.EmployeeResponseDto;
import rs.ac.bg.fon.task_manager.entity.Employee;
import rs.ac.bg.fon.task_manager.repository.EmployeeRepository;
import java.util.List;

@Service
public class EmployeeService implements BaseService<EmployeeRequestDto,EmployeeResponseDto> {

    private final EmployeeRepository repository;
    private final EmployeeConverter converter;

    public EmployeeService(EmployeeRepository repository, EmployeeConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public EmployeeResponseDto create(EmployeeRequestDto employeeRequestDto) {
        Employee savedEmployee = repository.save(converter.toEntity(employeeRequestDto));
        return converter.toResponse(savedEmployee);
    }

    @Override
    public EmployeeResponseDto update(Long id, EmployeeRequestDto employeeRequestDto) {
        Employee employeeToUpdate = repository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        converter.update(employeeToUpdate, employeeRequestDto);
        return converter.toResponse(repository.save(employeeToUpdate));
    }

    @Override
    public EmployeeResponseDto getById(Long id) {
        Employee employee = repository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        return converter.toResponse(employee);
    }

    @Override
    public List<EmployeeResponseDto> getAll() {
        return repository.findAll().stream().map(converter::toResponse).toList();
    }

    @Override
    public void delete(Long id) {repository.deleteById(id); }

    public Employee getByIdUpdate(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }
}
