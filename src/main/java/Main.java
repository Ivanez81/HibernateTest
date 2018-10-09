import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(StudentCourse.class)
                .buildSessionFactory();

        Session session = null;

        try {
//            session = factory.getCurrentSession();
//            Student student = new Student();
//            student.setName("Teddy");
//            session.beginTransaction();
//            session.save(student);
//            session.getTransaction().commit();

//            session = factory.getCurrentSession();
//            Course course = new Course();
//            course.setName("Ruby");
//            course.setDuration(5);
//            session.beginTransaction();
//            List<Student> students = new ArrayList<>();
//            Student student = session.get(Student.class, 1);
//            students.add(student);
//            course.setStudents(students);
//            session.save(course);
//            session.getTransaction().commit();

        // working with Embedded Key update grades and number of lessons
//            session = factory.getCurrentSession();
//            StudentCourseKey studentCourseKey = new StudentCourseKey();
//            session.beginTransaction();
//            studentCourseKey.setStudentId(1);
//            studentCourseKey.setCourseId(6);
//            StudentCourse studentCourse = session.get(StudentCourse.class, studentCourseKey);
//            studentCourse.setGrade(17);
//            studentCourse.setLessons(3);
//            System.out.println(studentCourse.toString());
//            session.getTransaction().commit();

        // get courses by student
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Student student = session.get(Student.class, 1);
//            System.out.println(student.toString() + student.getCourses());
//            session.getTransaction().commit();


        // get grades by student
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Student student = session.get(Student.class, 1);
//
//            student.setGrades(session.createQuery(
//                    "SELECT sc.grade FROM StudentCourse sc WHERE sc.studentCourseKey.studentId = 2")
//                    .getResultList());
//            System.out.println(student.getGrades());
//            session.getTransaction().commit();


        // get grades by course
            session = factory.getCurrentSession();
            session.beginTransaction();
            Course course  = session.get(Course.class, 1);

            course.setGrades(session.createQuery(
                    "SELECT sc.grade FROM StudentCourse sc WHERE sc.studentCourseKey.courseId = 1")
                    .getResultList());
            System.out.println("Grades by " + course.getName() + ": " + course.getGrades());
            System.out.println("Average grade: " + course.getGrades()
                    .stream().mapToInt(Integer::intValue).average());
            session.getTransaction().commit();


        } finally {
            session.close();
            factory.close();
        }
    }
}
