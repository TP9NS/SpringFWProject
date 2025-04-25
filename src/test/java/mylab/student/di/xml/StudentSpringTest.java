package mylab.student.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.annotation.Resource;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-student-di.xml")
public class StudentSpringTest {
	@Autowired
	Course course;
	@Resource(name ="gradeService")
	GradeService service;
	@Test
	void testService() {
		assertNotNull(service);
	}
	@Test @Disabled
	void testCourse() {
		assertNotNull(course);
		assertEquals("Java Programming",course.getCourseName());
		assertEquals(3,course.getStudents().size());
		assertEquals("엠마",course.getStudents().get(0).getName());
		
		System.out.println(course.getAverageScore());
		assertEquals(83.333,course.getAverageScore(),0.01);
	}
}
