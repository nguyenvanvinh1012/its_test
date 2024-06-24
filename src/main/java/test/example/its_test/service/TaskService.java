package test.example.its_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.example.its_test.dto.TaskDto;
import test.example.its_test.entity.TaskEntity;
import test.example.its_test.exception.ResourceNotFoundException;
import test.example.its_test.repository.SystemRepository;
import test.example.its_test.repository.TaskRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private SystemRepository systemRepository;

    public List<TaskDto> getAllTasks() {
        List<TaskEntity> tasks = taskRepository.findAll();
        return tasks.stream().map(TaskDto::new).collect(Collectors.toList());
    }

    public TaskDto getTask(Long taskId) {
        TaskEntity task = taskRepository.findById(taskId).orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + taskId));
        return new TaskDto(task);
    }

    public TaskDto createTask(TaskDto taskDto) {
        TaskEntity task = new TaskEntity();
        task.setContent(taskDto.getContent());
        task.setCost(taskDto.getCost());
        task.setEndDate(taskDto.getEndDate());
        task.setExpiredDate(taskDto.getExpiredDate());
        task.setNote(taskDto.getNote());
        task.setReceiveDate(taskDto.getReceiveDate());
        task.setStartDate(taskDto.getStartDate());
        task.setTicketNumber(taskDto.getTicketNumber());
        task.setTicketURL(taskDto.getTicketURL());
        task.setSystem(systemRepository.findById(taskDto.getSystemId()).orElseThrow(() -> new ResourceNotFoundException("System not found with id: " + taskDto.getSystemId())));
        taskRepository.save(task);
        return new TaskDto(task);
    }

    public TaskDto updateTask(Long taskId, TaskDto taskDto) {
        TaskEntity task = taskRepository.findById(taskId).orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + taskId));
        task.setContent(taskDto.getContent());
        task.setCost(taskDto.getCost());
        task.setEndDate(taskDto.getEndDate());
        task.setExpiredDate(taskDto.getExpiredDate());
        task.setNote(taskDto.getNote());
        task.setReceiveDate(taskDto.getReceiveDate());
        task.setStartDate(taskDto.getStartDate());
        task.setTicketNumber(taskDto.getTicketNumber());
        task.setTicketURL(taskDto.getTicketURL());
        task.setSystem(systemRepository.findById(taskDto.getSystemId()).orElseThrow(() -> new ResourceNotFoundException("System not found with id: " + taskDto.getSystemId())));
        taskRepository.save(task);
        return new TaskDto(task);
    }

    public void deleteTask(Long taskId) {
        TaskEntity task = taskRepository.findById(taskId).orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + taskId));
        taskRepository.delete(task);
    }
}
