package ru.gb.homework4.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.homework4.model.Student;
import ru.gb.homework4.repository.StudentRepository;

@Controller
@AllArgsConstructor
public class StudentController {
    private final StudentRepository studentRepository;

    @GetMapping("/students")
    public String getStudents(Model model) {
        model.addAttribute("students", studentRepository.GetStudents());

        return "students";
    }

    @PostMapping("/students")
    public String addStudent(Student student, Model model) {
        studentRepository.addStudent(student);
        model.addAttribute("students", studentRepository.GetStudents());

        return "students";
    }
}
