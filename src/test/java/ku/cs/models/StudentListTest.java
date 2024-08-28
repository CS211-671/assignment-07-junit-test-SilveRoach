package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    @Test
    @DisplayName("เพิ่ม student ไปใน studentList ผ่านการใช้งาน ID, ชื่อ, เเละมีหรือไม่มีคะเเนนได้")
    void testStudentListAddNewStudent() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6655443322", "Bob");
        studentList.addNewStudent("6650403020", "Guy", 50);

        Student s1 = studentList.findStudentById("6655443322");
        Student s2 = studentList.findStudentById("6650403020");

        assertEquals(0.0, s1.getScore());
        assertEquals(50.0, s2.getScore());
    }

    @Test
    @DisplayName("ค้นหา student ใน studentList ผ่านการใช้งานค้นหาจาก ID ได้")
    void testStudentListFindStudentById() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6655443322", "Bob");
        studentList.addNewStudent("6650403020", "Guy", 50);
        studentList.addNewStudent("6419384180", "Jack", 18);

        Student s1 = studentList.findStudentById("6655443322");
        Student s2 = studentList.findStudentById("6650403020");
        Student s3 = studentList.findStudentById("6419384180");
        Student s4 = studentList.findStudentById("641938418x");

        assertEquals("Bob", s1.getName());
        assertEquals("Guy", s2.getName());
        assertEquals("Jack", s3.getName());
        assertNull(s4);
    }

    @Test
    @DisplayName("เพิ่มคะเเนนให้ student ใน studentList ผ่านการใช้งานค้นหาจาก ID ได้")
    void testStudentListGiveScoreToId() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6655443322", "Bob");
        studentList.addNewStudent("6650403020", "Guy", 50);
        studentList.addNewStudent("6419384180", "Jack", 18);

        studentList.giveScoreToId("6655443322",20);
        studentList.giveScoreToId("6655443322",10);
        studentList.giveScoreToId("6650403020",50);
        studentList.giveScoreToId("6419384180",22);
        studentList.giveScoreToId("6419384180",-20);

        Student s1 = studentList.findStudentById("6655443322");
        Student s2 = studentList.findStudentById("6650403020");
        Student s3 = studentList.findStudentById("6419384180");

        assertEquals(30.0, s1.getScore());
        assertEquals(100, s2.getScore());
        assertEquals(40, s3.getScore());
    }

    @Test
    @DisplayName("ดูเกรดของ student ใน studentList ผ่านการใช้งานค้นหาจาก ID ได้")
    void testStudentListViewGradeOfId() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6655443322", "Bob");
        studentList.addNewStudent("6650403020", "Guy", 50);
        studentList.addNewStudent("6419384180", "Jack", 87);

        String actual1 = studentList.viewGradeOfId("6655443322");
        String actual2 = studentList.viewGradeOfId("6650403020");
        String actual3 = studentList.viewGradeOfId("6419384180");

        assertEquals("F", actual1);
        assertEquals("D", actual2);
        assertEquals("A", actual3);
    }
}