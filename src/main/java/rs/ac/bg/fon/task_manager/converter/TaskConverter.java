package rs.ac.bg.fon.task_manager.converter;

import rs.ac.bg.fon.task_manager.dto.employee.EmployeeResponseDto;
import rs.ac.bg.fon.task_manager.dto.task.TaskRequestDto;
import rs.ac.bg.fon.task_manager.dto.task.TaskResponseDto;
import rs.ac.bg.fon.task_manager.entity.Employee;
import rs.ac.bg.fon.task_manager.entity.Task;
import rs.ac.bg.fon.task_manager.service.EmployeeService;

public class TaskConverter implements Converter<Task, TaskRequestDto, TaskResponseDto>{

    private final EmployeeService employeeService;

    public TaskConverter(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public TaskResponseDto toResponse(Task t) {
        Employee e = t.getAssignee();
        EmployeeResponseDto employeeResponse = new EmployeeResponseDto(e.getId(), e.getFullName(), e.getEmail(), e.getPhoneNumber(), e.getDateOfBirth(), e.getSalary());
        return new TaskResponseDto(t.getId(), t.getTitle(), t.getDescription(), t.getDueDate(), t.isCompleted(),employeeResponse);
    }

    @Override
    public Task toEntity(TaskRequestDto t) {
        return new Task(t.title(), t.description(), t.dueDate(), t.completed());
    }

    public void update(Task t, TaskRequestDto tr){
        if(tr == null)
            return;

        t.setTitle(tr.title());
        t.setDescription(tr.description());
        t.setDueDate(tr.dueDate());
        t.setCompleted(tr.completed());
        t.setAssignee(employeeService.getByIdUpdate(tr.employeeId()));
    }
}
