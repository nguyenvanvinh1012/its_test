package test.example.its_test.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import test.example.its_test.dto.TaskDto;
import test.example.its_test.service.TaskService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/tasks")
@Validated
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping()
    public List<TaskDto> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{taskId}")
    public TaskDto getDetailTask(@PathVariable("taskId") Long taskId) {
        return taskService.getTask(taskId);
    }

    @PostMapping()
    public TaskDto createTask(@Valid @RequestBody TaskDto taskDto) {
        return taskService.createTask(taskDto);
    }

    @PutMapping("/{taskId}")
    public TaskDto updateTask(@PathVariable("taskId") Long taskId, @Valid @RequestBody TaskDto taskDto) {
        return taskService.updateTask(taskId, taskDto);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable("taskId") Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.ok("Task deleted successfully!");
    }

    // Handle exceptions for authentication errors.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }
}
