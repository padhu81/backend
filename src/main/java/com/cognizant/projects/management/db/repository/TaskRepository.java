package com.cognizant.projects.management.db.repository;

import com.cognizant.projects.management.db.Entities.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Integer> {

    List<Task> findByProjectId(int projectId);


}
