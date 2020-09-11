package com.thoughtworks.capability.gtb.restfulapidesign.Controller;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService ;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return this.studentService.getAllStudents();
    }

    @GetMapping("/students/{index}")
    public Student getStudentById(@PathVariable Integer index) {
        return this.studentService.getStudentById(index);
    }

    @PostMapping("/new-student")
    public void getStudentById(@RequestBody  Student student) {
        this.studentService.addNewStudent(student);
    }

    @DeleteMapping("/delete/{index}")
    public void deleteUser(@PathVariable Integer index){
        this.studentService.deleteStudentById(index);
    }
}
