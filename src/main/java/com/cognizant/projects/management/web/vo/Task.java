package com.cognizant.projects.management.web.vo;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class Task {
    private int  taskId;
    private int parentId;
    private int projectId;
    private String taskName;
    private Timestamp startDate;
    private Timestamp endDate;
    private int priority;
    private int status;
    private User user;
}
