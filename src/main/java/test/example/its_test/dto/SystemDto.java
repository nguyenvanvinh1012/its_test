package test.example.its_test.dto;

import lombok.Getter;
import lombok.Setter;
import test.example.its_test.entity.SystemEntity;

@Getter
@Setter
public class SystemDto {
    Long systemId;
    String systemName;

    public SystemDto() {
    }

    public SystemDto(SystemEntity system) {
        this.systemId = system.getId();
        this.systemName = system.getSystemName();
    }
}
