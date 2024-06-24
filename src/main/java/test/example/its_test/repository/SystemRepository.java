package test.example.its_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.example.its_test.entity.SystemEntity;

@Repository
public interface SystemRepository extends JpaRepository<SystemEntity, Long> {
}
