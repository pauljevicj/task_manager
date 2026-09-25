package rs.ac.bg.fon.task_manager.service;

import org.springframework.stereotype.Service;
import rs.ac.bg.fon.task_manager.converter.TaskConverter;
import rs.ac.bg.fon.task_manager.dto.task.TaskRequestDto;
import rs.ac.bg.fon.task_manager.dto.task.TaskResponseDto;
import rs.ac.bg.fon.task_manager.entity.Employee;
import rs.ac.bg.fon.task_manager.entity.Task;
import rs.ac.bg.fon.task_manager.repository.TaskRepository;
import java.util.List;

@Service
public class TaskService implements BaseService<TaskRequestDto, TaskResponseDto>{

    private final TaskRepository repository;
    private final TaskConverter converter;

    public TaskService(TaskRepository repository, TaskConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public TaskResponseDto create(TaskRequestDto taskRequestDto) {
        Task taskToSave = repository.save(converter.toEntity(taskRequestDto));
        return converter.toResponse(taskToSave);
    }

    @Override
    public TaskResponseDto update(Long id, TaskRequestDto taskRequestDto) {
        Task taskToUpdate = repository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        return converter.toResponse(taskToUpdate);
    }

    @Override
    public TaskResponseDto getById(Long id) {
        Task task = repository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        return converter.toResponse(task);
    }

    @Override
    public List<TaskResponseDto> getAll() {
        return repository.findAll().stream().map(converter::toResponse).toList();
    }

    @Override
    public void delete(Long id) {repository.deleteById(id);}
}
