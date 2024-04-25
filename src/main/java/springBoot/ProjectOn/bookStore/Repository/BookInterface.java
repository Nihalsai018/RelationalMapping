package springBoot.ProjectOn.bookStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springBoot.ProjectOn.bookStore.Entity.Books;

public interface BookInterface extends JpaRepository<Books,Integer> {
    @Query("SELECT b.bookCount FROM Books b WHERE b.bookName = ?1")
    int findBookCountByBookName(String bookName);



}
