package com.thoughtworks.capability.gtb.restfulapidesign.Service;

import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.Dto.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GroupService {

    private static Map<Integer, Group> groupMap = new HashMap<>();

    public GroupService(){
        groupMap.put(1, new Group(1,"fancy team","a team of TLs"));
        groupMap.put(2, new Group(2,"holy family",null));
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
}
