package com.example.grappler.Controller;

import com.example.grappler.Entity.Leaves;
import com.example.grappler.Entity.Users;
import com.example.grappler.Repository.LeavesRepo;
import com.example.grappler.Repository.UserRepository;
import com.example.grappler.Service.LeavesService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leave")
public class LeavesController {

@Autowired
    private LeavesService leavesService;
@Autowired
private LeavesRepo leavesRepo;
@Autowired
private UserRepository userrepo;
@GetMapping
    public List<Leaves> getAllLeaves() {
        return leavesRepo.findAll();
    }


    // POST Request - Create a new leave
    @PostMapping
    public Leaves createLeave(@RequestBody Leaves leave) {
        System.out.println("\n ------------------------------------------------------------- save leaves "+leave);
        return leavesRepo.save(leave);
    }

    @PostMapping("/users/{userId}")
    public Leaves createLeave(@PathVariable Long userId, @RequestBody Leaves leave) {
        Users user = userrepo.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));

      if(user!=null) {
          leave.setUser(user);
          return leavesRepo.save(leave);

      }
      return null;

      }
    @GetMapping("/searchByDayAndId")
    public ResponseEntity<String> searchByDayAndId(@RequestParam String day, @RequestParam Long userId) {
        List<Leaves> userLeaves = leavesRepo.findByUserIdAndDay(userId, day);
            System.out.println(" test"+ userLeaves);
        if (!userLeaves.isEmpty()) {
            return ResponseEntity.ok("User with ID " + userId + " is on leave on " + day);
        } else {
            System.out.println("User with ID " + userId + " is working");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("" + userId + " is working");
        }
    }


}
