package rs.ac.bg.fon.task_manager.dto.task;

import rs.ac.bg.fon.task_manager.dto.employee.EmployeeResponseDto;

import java.time.LocalDate;

public record TaskResponseDto(
        Long id,
        String title,
        String description,
        LocalDate dueDate,
        boolean completed,
        EmployeeResponseDto employee
) {
}
