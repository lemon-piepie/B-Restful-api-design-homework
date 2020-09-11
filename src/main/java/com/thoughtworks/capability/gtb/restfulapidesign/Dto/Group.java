package com.thoughtworks.capability.gtb.restfulapidesign.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    //@JsonProperty("groupId")
    private Integer id;

    //@JsonProperty("groupName")
    private String name;

    //@JsonProperty("groupNote")
    private String note;
}
