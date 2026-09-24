package rs.ac.bg.fon.task_manager.dto.task;

import java.time.LocalDate;

public record TaskRequestDto(
        String title,
        String description,
        LocalDate dueDate,
        boolean completed,
        Long employeeId) {
}
