package test.example.its_test.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import test.example.its_test.entity.TaskEntity;

import java.time.LocalDateTime;

@Getter
@Setter
public class TaskDto {
    private Long id;

    @NotEmpty(message = "Content must not be empty")
    private String content;

    @NotNull(message = "Cost must not be null")
    private Double cost;

    @NotNull(message = "End date must not be null")
    private LocalDateTime endDate;

    @NotNull(message = "Expired date must not be null")
    private LocalDateTime expiredDate;

    @NotNull(message = "Note must not be null")
    private String note;

    @NotNull(message = "Receive date must not be null")
    private LocalDateTime receiveDate;

    @NotNull(message = "Start date must not be null")
    private LocalDateTime startDate;

    @NotEmpty(message = "Ticket number must not be empty")
    private String ticketNumber;

    @NotEmpty(message = "Ticket URL must not be empty")
    private String ticketURL;

    @NotNull(message = "System ID must not be null")
    private Long systemId;

    // Constructor to convert from TaskEntity to TaskDto
    public TaskDto(TaskEntity task) {
        this.id = task.getId();
        this.content = task.getContent();
        this.cost = task.getCost();
        this.endDate = task.getEndDate();
        this.expiredDate = task.getExpiredDate();
        this.note = task.getNote();
        this.receiveDate = task.getReceiveDate();
        this.startDate = task.getStartDate();
        this.ticketNumber = task.getTicketNumber();
        this.ticketURL = task.getTicketURL();
        this.systemId = task.getSystem() != null ? task.getSystem().getId() : null;
    }

    public TaskDto() {
    }
}
