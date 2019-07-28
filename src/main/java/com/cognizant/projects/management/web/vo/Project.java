package com.cognizant.projects.management.web.vo;


import lombok.Getter;
import lombok.Setter;


import java.sql.Timestamp;

@Getter
@Setter
public class Project {
    private int projectID;
    private String projectName;
    private Timestamp startDate;
    private Timestamp endDate;
    private int priority;
    private User user;
}
