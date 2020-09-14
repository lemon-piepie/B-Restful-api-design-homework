package com.thoughtworks.capability.gtb.restfulapidesign.Controller;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.Service.SystemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final SystemService systemService; ;

    public StudentController(SystemService systemService) {
        this.systemService = systemService;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(@RequestParam(value="gender", required = false) String gender) {
        if (gender != null){
            return this.systemService.getStudentsByGender(gender);
        }
        return this.systemService.getAllStudents();
    }

    @GetMapping("/students/{index}")
    public Student getStudentById(@PathVariable Integer index) {
        return this.systemService.getStudentById(index);
    }

    @PostMapping("/students")
    public void getStudentById(@RequestBody  Student student) {
        this.systemService.addNewStudent(student);
    }

    @DeleteMapping("/students/{index}")
    public void deleteUser(@PathVariable Integer index){
        this.systemService.deleteStudentById(index);
    }

    @PatchMapping("/students/{index}")
    public void updateStudent(@PathVariable Integer index,
                              @RequestBody Student student){
        this.systemService.updateStudentById(index, student);
    }

}
