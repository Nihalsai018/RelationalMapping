package springBoot.ProjectOn.bookStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springBoot.ProjectOn.bookStore.Entity.Students;

import java.util.List;

public interface StudentInterface extends JpaRepository<Students,Integer> {
    List<Students> findByStudentNameContaining(String name);



}
