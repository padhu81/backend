package com.cognizant.projects.management.db.Entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "Task")
@Data
public class Task {
    @Id
    private int task_id;
    private int parent_id;

    @Column(name = "project_id", nullable = false)
    private int projectId;
    private String task_name;
    private Timestamp start_date;
    private Timestamp end_date;
    private int priority;
    private int status;
}
