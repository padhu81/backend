package com.cognizant.projects.management.db.Entities;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "User")
@Getter
@Setter
@Data
public class User {
    @Id
    private int User_ID;
    private String firstName;
    private String lastName;
    private int employeeId;
    private int Task_ID;
    private int Project_ID;
}
