package springBoot.ProjectOn.bookStore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springBoot.ProjectOn.bookStore.Entity.Students;
import springBoot.ProjectOn.bookStore.Repository.BookInterface;
import springBoot.ProjectOn.bookStore.Repository.StudentInterface;

import java.util.List;

@RestController
@RequestMapping("/StudentBooks")
public class StudentBooks {
    String nihal ="nn";
    @Autowired
    private BookInterface bookInterface;
    @Autowired
    private StudentInterface studentInterface;
    @PostMapping("/save")
    public Students addRecords(@RequestBody Students students){
        return studentInterface.save(students);
    }

    @GetMapping("/getall")
    public List<Students> retiriveRecords(){
        return studentInterface.findAll();
    }

    @GetMapping("/getby/{name}")
    public List<Students> retriveByName(@PathVariable String name){
        return studentInterface.findByStudentNameContaining(name);
    }

    @GetMapping("/getcount/{bookName}")
    public int countOfBook(@PathVariable String bookName){
        return bookInterface.findBookCountByBookName(bookName);

    }



}
