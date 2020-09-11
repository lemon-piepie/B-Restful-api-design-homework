package com.thoughtworks.capability.gtb.restfulapidesign.Controller;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.Service.GroupService;
import com.thoughtworks.capability.gtb.restfulapidesign.Service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/groups")
    public List<Group> getAllStudents() {
        return this.groupService.getAllGroups();
    }


    @PatchMapping("/update-group/{index}")
    public void updateStudent(@PathVariable Integer index,
                              @RequestBody Group group){
        this.groupService.updateGroupsById(index, group);
    }
}
