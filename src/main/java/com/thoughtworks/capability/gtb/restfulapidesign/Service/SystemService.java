package com.thoughtworks.capability.gtb.restfulapidesign.Service;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Student;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SystemService {
    private static Map<Integer, Student> studentMap = new HashMap<>();
    private static Map<Integer, Group> groupMap = new HashMap<>();

    public SystemService(){
        studentMap.put(1, new Student(1,"Alice","female","allergic to nuts"));
        studentMap.put(2, new Student(2,"Tom","male",null));
        studentMap.put(3, new Student(3,"July","female",null));
        studentMap.put(4, new Student(4,"Lily","female",null));
        studentMap.put(5, new Student(5,"Tony","male",null));
        studentMap.put(6, new Student(6,"Martin","male",null));
        studentMap.put(7, new Student(7,"Harry","male","like nuts"));
        studentMap.put(8, new Student(8,"John","male",null));

        groupMap.put(1, new Group(1,"fancy team","a team of TLs",null));
        groupMap.put(2, new Group(2,"holy family",null,null));
        groupMap.put(3, new Group(3,"team3",null,null));
        groupMap.put(4, new Group(4,"team4",null,null));
        groupMap.put(5, new Group(5,"team5","a team full of happiness",null));
        groupMap.put(6, new Group(6,"team6",null,null));
    }

    public List<Student> getAllStudents() {
        return new ArrayList<Student>(studentMap.values());
    }

    public Student getStudentById(Integer id){
        return studentMap.get(id);
    }

    public void addNewStudent(Student student){
        studentMap.put(student.getId(),student);
    }

    public void deleteStudentById(Integer id){
        studentMap.remove(id);
    }

    public void updateStudentById(Integer id,Student updateImfo) {
        Student student = studentMap.get(id);
        if (student != null){
            student.setGender(updateImfo.getGender());
            student.setName(updateImfo.getName());
            student.setNote(updateImfo.getNote());
        }
    }

    public List<Student> getStudentsByGender(String gender) {
        List<Student> studentsByGender = new ArrayList<Student>();
        studentMap.forEach( (index,student) -> {
            if (student.getGender().equals(gender)){
                studentsByGender.add(student);
            }
        });
        return studentsByGender;
    }

    public List<Group> getAllGroups() {
        return new ArrayList<Group>(groupMap.values());
    }

    public void updateGroupsById(Integer id,Group updateImfo) {
        Group group = groupMap.get(id);
        if (group != null){
            group.setName(updateImfo.getName());
            group.setNote(updateImfo.getNote());
        }
    }

    public void divideStudentToGroup() {
        int[] studentInEachGroup = this.getEachNumberOfStudentsInGroup();
//        List<Integer> studentRandomIndex = this.randomStudentIndex();

        groupMap.forEach ((groupId, group) -> {
            List<Student> studentsInThisGroup = new ArrayList<Student>();
            int indexStart = 0;
            for (int k =2; k <= groupId;k++){
                indexStart += studentInEachGroup[k-2];
            }
            for (int j=1; j<=studentInEachGroup[groupId-1]; j++) {
//               studentsInThisGroup.add(studentMap.get(studentRandomIndex.get(groupId+1)));
                studentsInThisGroup.add(studentMap.get(j+indexStart));
            }
            groupMap.get(groupId).setStudents(studentsInThisGroup);
        });
    }

//    public List<Integer> randomStudentIndex(){
//        int studentAmount = studentMap.size();
//        List<Integer> studentRandomIndex = new ArrayList<Integer>();
//        studentMap.forEach((index,student) -> {
//            int randomIndex = (int)(Math.random()*studentAmount+1);
//            if (studentRandomIndex==null && studentRandomIndex.indexOf(randomIndex)==-1){
//                studentRandomIndex.add(randomIndex);
//            }
//        });
//        return studentRandomIndex;
//    }

    public int[] getEachNumberOfStudentsInGroup(){
        int studentAmount = studentMap.size();
        int basicNumber = studentAmount/6;
        int restNumber = studentAmount%6;
        int groupNumber = groupMap.size();

        int[] studentInEachGroup = new int[groupNumber];
        for (int i = 0; i < groupNumber; i++){
            int needMoreStudent = i < restNumber? 1 : 0;
            studentInEachGroup[i] = basicNumber+needMoreStudent;
        }
        return studentInEachGroup;
    }
}
