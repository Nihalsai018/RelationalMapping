package springBoot.ProjectOn.bookStore.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="Books_table")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String bookName;
    private int bookCount;

    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "booklist",cascade = CascadeType.ALL)  //With FetchType.EAGER, when you retrieve a Books entity from the database, JPA will automatically fetch all associated Students
    @JsonBackReference //  to prevent infinite recursion during JSON serialization.        //In contrast, with FetchType.LAZY, associated entities are not loaded immediately when you fetch the owning entity (in this case, the Books entity).
    private Set<Students> studentsList;

}
