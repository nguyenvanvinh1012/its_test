package test.example.its_test.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "its_system")
public class SystemEntity extends BaseEntity {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name =  "system_name")
    private String systemName;

    @OneToMany(mappedBy = "system", cascade = CascadeType.ALL)
    private List<TaskEntity> tasks;
}
