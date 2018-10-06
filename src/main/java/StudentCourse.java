import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "student_course")
@Data
public class StudentCourse {

    @EmbeddedId
    private StudentCourseKey studentCourseKey;

    @Column(name = "grade")
    private int grade;

    @Column(name = "lessons")
    private int lessons;

}
