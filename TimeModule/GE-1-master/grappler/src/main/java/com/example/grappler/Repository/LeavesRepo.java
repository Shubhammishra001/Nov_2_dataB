package com.example.grappler.Repository;

import com.example.grappler.Entity.Leaves;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeavesRepo extends JpaRepository<Leaves, Long> {
    //Leaves findByDayAndUserId(String day, Long id);
    //List<Leaves> findByDayAndUser_Id(String day, Long userId);


    List<Leaves> findByUserIdAndDay(Long userId, String day);
}
