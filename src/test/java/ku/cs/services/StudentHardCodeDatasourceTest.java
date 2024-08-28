package ku.cs.services;

import ku.cs.models.StudentList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {
    @Test
    @DisplayName("Test readData in StudentHardCodeDatasource")
    void testReadData() {
        StudentHardCodeDatasource datasource = new StudentHardCodeDatasource();

        StudentList studentList = datasource.readData();

        assertEquals("6410400001", studentList.findStudentById("6410400001").getId());
        assertEquals("First", studentList.findStudentById("6410400001").getName());

        assertEquals("6410400002", studentList.findStudentById("6410400002").getId());
        assertEquals("Second", studentList.findStudentById("6410400002").getName());

        assertEquals("6410400003", studentList.findStudentById("6410400003").getId());
        assertEquals("Third", studentList.findStudentById("6410400003").getName());

        assertEquals("6410400004", studentList.findStudentById("6410400004").getId());
        assertEquals("Fourth", studentList.findStudentById("6410400004").getName());
    }
}