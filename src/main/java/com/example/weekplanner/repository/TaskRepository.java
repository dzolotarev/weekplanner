package com.example.weekplanner.repository;

import com.example.weekplanner.model.Task;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TaskRepository extends PagingAndSortingRepository<Task, Long>, CrudRepository<Task, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Task t SET t.done = true WHERE t.id= :id")
    void markIsDone(@Param("id") Long id);
}
