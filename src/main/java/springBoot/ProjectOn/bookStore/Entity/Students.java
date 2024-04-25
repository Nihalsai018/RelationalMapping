package springBoot.ProjectOn.bookStore.Entity;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
//@Data // here jakason is unabe to bind the data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Student_table")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String studentName;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "Student_books",
            joinColumns = {

            @JoinColumn(name = "Student_id",referencedColumnName = "studentId")

            },
            inverseJoinColumns = {
                    @JoinColumn(name = "book_id", referencedColumnName = "bookId")
            }
    )
    @JsonManagedReference
    private Set<Books> booklist;


}
