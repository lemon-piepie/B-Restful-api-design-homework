package com.thoughtworks.capability.gtb.restfulapidesign.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    //@JsonProperty("studentId")
    private Integer id;

    //@JsonProperty("studentName")
    private String name;

    private String gender;

    //@JsonProperty("studentNote")
    private String note;
}
