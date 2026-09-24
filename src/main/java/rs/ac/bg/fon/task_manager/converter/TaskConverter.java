package rs.ac.bg.fon.task_manager.converter;

import rs.ac.bg.fon.task_manager.dto.employee.EmployeeResponseDto;
import rs.ac.bg.fon.task_manager.dto.task.TaskRequestDto;
import rs.ac.bg.fon.task_manager.dto.task.TaskResponseDto;
import rs.ac.bg.fon.task_manager.entity.Employee;
import rs.ac.bg.fon.task_manager.entity.Task;

public class TaskConverter implements Converter<Task, TaskRequestDto, TaskResponseDto>{
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
}
