package com.thoughtworks.capability.gtb.restfulapidesign.Service;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    private static Map<Integer, Student> studentMap = new HashMap<>();

    public StudentService(){
        studentMap.put(1, new Student(1,"Alice","female","allergic to nuts"));
        studentMap.put(2, new Student(2,"Tome","male",null));
        studentMap.put(3, new Student(3,"July","female",null));
    }

    public List<Student> getAllStudents() {
        return new ArrayList<Student>(studentMap.values());
    }

    public Student getStudentsById(Integer id){
        return studentMap.get(id);
    }
}
