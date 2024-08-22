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
        //Student s1 = new Student("6xxxxxxxxx", "kong");
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

}