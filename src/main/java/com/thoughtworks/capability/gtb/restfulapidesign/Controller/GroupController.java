package com.thoughtworks.capability.gtb.restfulapidesign.Controller;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Group;

import com.thoughtworks.capability.gtb.restfulapidesign.Service.SystemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupController {
    private final SystemService systemService;

    public GroupController(SystemService groupService) {
        this.systemService = groupService;
    }

    @GetMapping("/groups")
    public List<Group> getAllStudents() {
        this.systemService.divideStudentToGroup();
        return this.systemService.getAllGroups();
    }


    @PatchMapping("/update-group/{index}")
    public void updateStudent(@PathVariable Integer index,
                              @RequestBody Group group){
        this.systemService.updateGroupsById(index, group);
    }
}
