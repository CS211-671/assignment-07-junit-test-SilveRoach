package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student s1;

    @BeforeEach
    void init() {
        s1 = new Student("6xxxxxxxxx", "kong");
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 40 เเละ 30 คะแนน")
    void testAddScore() {
        s1.addScore(40);
        assertEquals(40, s1.getScore());
        s1.addScore(30);
        assertEquals(70, s1.getScore());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 60 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testCalculateGrade() {
        Student s1 = new Student("6xxxxxxxxx", "kong", 50);
        s1.addScore(10);
        assertEquals("C", s1.grade());
    }

    @Test
    @DisplayName("ทดสอบการการเปลี่ยนชื่อเป็น 'Mobile'")
    void testChangeName() {
        s1.changeName("Mobile");
        assertEquals("Mobile", s1.getName());
    }

    @Test
    @DisplayName("ทดสอบการการเปรียบเทียบ ID ของ Student")
    void testIsId() {
        Student s2 = new Student("6650403022", "Ball");
        assertTrue(s2.isId("6650403022"));
    }

    @Test
    @DisplayName("ทดสอบการทำ toString ของ s1 เเละ s2")
    void testToString() {
        Student s2 = new Student("6650403022", "Ball", 95);

        String result1 = s1.toString();
        String result2 = s2.toString();

        String expected1 = "{id: '6xxxxxxxxx', name: 'kong', score: 0.0}";
        String expected2 = "{id: '6650403022', name: 'Ball', score: 95.0}";
        assertEquals(expected1, result1);
        assertEquals(expected2, result2);
    }

    @Test
    @DisplayName("ทดสอบ constructor เเบบมีเเละไม่มี score")
    void testConstructor() {
        Student s2 = new Student("6650403022", "Ball", 95);
        Student s3 = new Student("6655443322", "Apple");

        double result1 = s1.getScore();
        double result2 = s2.getScore();
        double result3 = s3.getScore();

        double expected1 = 0.0;
        double expected2 = 95.0;
        double expected3 = 0.0;
        assertEquals(expected1, result1);
        assertEquals(expected2, result2);
        assertEquals(expected3, result3);
    }
}