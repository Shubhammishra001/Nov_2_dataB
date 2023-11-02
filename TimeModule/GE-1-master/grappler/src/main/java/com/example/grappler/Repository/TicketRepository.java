package com.example.grappler.Repository;

import com.example.grappler.Entity.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Tickets,Long> {
    List<Tickets> getTicketsByUserId(Long userids);
}
