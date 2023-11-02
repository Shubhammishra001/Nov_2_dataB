package com.example.grappler.Service;

import com.example.grappler.Entity.Leaves;
import com.example.grappler.Repository.LeavesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeavesService {

    @Autowired
    private LeavesRepo leavesRepo;


    public List<Leaves> findAll() {
    List<Leaves> leaves=leavesRepo.findAll();
   return leaves;

    }

    public Leaves save(Leaves leave) {
        return leavesRepo.save(leave);
    }
}
