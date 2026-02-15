package assignment.caseStudy2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.CaseStudy3.UniversitySystem.Course;
import com.CaseStudy3.UniversitySystem.Enrollment;
import com.CaseStudy3.UniversitySystem.Instructor;
import com.CaseStudy3.UniversitySystem.InstructorProfile;
import com.CaseStudy3.UniversitySystem.UniversityService;

public class UniversityTest {

    private UniversityService service = new UniversityService();

    @Test
    public void testOneToOne() {

        InstructorProfile p = new InstructorProfile();
        p.setId(1L);
        p.setOfficeRoom("B-101");
        p.setPhone("999999");

        Instructor i = new Instructor();
        i.setId(1L);
        i.setName("Dr. Sharma");
        i.setDepartment("CSE");
        i.setProfile(p);

        service.createInstructor(i);

        assertNotNull(service.getInstructor(1L).getProfile());
    }

    @Test
    public void testOneToMany() {

        Course c1 = new Course();
        c1.setId(101);
        c1.setTitle("DBMS");
        c1.setCredits(4);

        Course c2 = new Course();
        c2.setId(102);
        c2.setTitle("AI");
        c2.setCredits(3);

        service.addCourses(1L, Arrays.asList(c1, c2));

        Instructor i = service.getInstructor(1L);

        assertEquals(2, i.getCourses().size());
    }

    @Test
    public void testManyToOne() {

        Course c = service.getInstructor(1L).getCourses().get(0);

        Enrollment e = new Enrollment();
        e.setId(500);
        e.setSemester("Fall 2026");
        e.setGrade("A");
        e.setCourse(c);

        service.addEnrollment(e);

        assertEquals("A", e.getGrade());
    }
}
