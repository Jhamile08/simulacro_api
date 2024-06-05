package riwi.riwi.riwi_education.domain.entities;
import java.util.List;

import org.springframework.data.annotation.Id;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "courses")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    @Column(nullable = false)
    private String course_name;
    @Column(nullable = false)
    private String description;

    @OneToMany(
        fetch = FetchType.EAGER,
        mappedBy = "course",
        cascade = CascadeType.ALL,
        orphanRemoval = false  
    )
    private List<Enrollments> enrollment;

    @OneToMany(
        fetch = FetchType.EAGER,
        mappedBy = "course",
        cascade = CascadeType.ALL,
        orphanRemoval = false  
    )
    private List<Lessons> lesson;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id",referencedColumnName = "userId" )
    private Users user;
}
