package ru.gb.homework4.repository;

import org.springframework.stereotype.Repository;
import ru.gb.homework4.model.Student;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> GetStudents() {
        return students;
    }
}