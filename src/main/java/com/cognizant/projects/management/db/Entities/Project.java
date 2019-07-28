package com.cognizant.projects.management.db.Entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity(name = "project")
@Data
public class Project {
    @Id
    private int project_ID;
    private String project_name;
    private Timestamp start_date;
    private Timestamp end_date;
    private int priority;
}
