package com.cognizant.projects.management.db.repository;

import com.cognizant.projects.management.db.Entities.Task;
import com.cognizant.projects.management.db.Entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
