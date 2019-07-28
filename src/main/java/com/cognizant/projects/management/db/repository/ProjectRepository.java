package com.cognizant.projects.management.db.repository;

import com.cognizant.projects.management.db.Entities.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer> {



}
