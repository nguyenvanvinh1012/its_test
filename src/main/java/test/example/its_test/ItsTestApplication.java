package test.example.its_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ItsTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItsTestApplication.class, args);
    }

}
