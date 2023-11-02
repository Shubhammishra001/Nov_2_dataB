package com.Ex_Hand.Ex_Hand.repo;

import com.Ex_Hand.Ex_Hand.Entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface TestRepo extends JpaRepository<TestEntity,Long> {


}
