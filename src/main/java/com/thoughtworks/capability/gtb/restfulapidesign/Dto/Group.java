package com.thoughtworks.capability.gtb.restfulapidesign.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    private Integer id;

    private String name;

    private String note;

    private List<Student> students;
}
