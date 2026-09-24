package rs.ac.bg.fon.task_manager.dto.employee;

import java.time.LocalDate;

public record EmployeeRequestDto(
        String fullName,
        String email,
        String phoneNumber,
        LocalDate dateOfBirth,
        Double salary) {
}
