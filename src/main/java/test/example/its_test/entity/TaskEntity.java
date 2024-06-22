package test.example.its_test.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "its_task")
public class TaskEntity extends BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "expired_date")
    private LocalDateTime expiredDate;

    @Column(name = "note")
    private String note;

    @Column(name = "receive_date")
    private LocalDateTime receiveDate;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "ticket_number")
    private String ticketNumber;

    @Column(name = "ticket_url")
    private String ticketURL;

    @ManyToOne
    @JoinColumn(name = "system_id", referencedColumnName = "id")
    private SystemEntity system;
}
