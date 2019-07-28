package com.cognizant.projects.management.web.vo;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private int userId;

    private String firstName;

    private String lastName;

    private String employeeId;

    private int projectId;

    private int taskId;

    private int empId;
}
