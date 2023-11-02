package com.example.grappler.Service;
import com.example.grappler.Entity.Tickets;
import com.example.grappler.Exception.TicketNotFoundException;
import com.example.grappler.Repository.ProjectRepository;
import com.example.grappler.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
    public class TicketService {
        @Autowired
        private TicketRepository ticketsRepository;

        @Autowired
        private ProjectRepository projectRepository;

        public List<Tickets> getAllTickets() {
            return ticketsRepository.findAll();
        }
        public Tickets getTicketById(Long ticketId) {
            return ticketsRepository.findById(ticketId)
                    .orElseThrow(() -> new TicketNotFoundException("Ticket not found"));
        }

        public Tickets createTicket(Tickets ticket) {
            return ticketsRepository.save(ticket);
        }

        public Tickets updateTicket(Long ticketId, Tickets updatedTicket) {
            if (!ticketsRepository.existsById(ticketId)) {
                throw new TicketNotFoundException("Ticket not found");
            }

            updatedTicket.setTicketId(ticketId);
            return ticketsRepository.save(updatedTicket);
        }

        public void deleteTicket(Long ticketId) {
            if (!ticketsRepository.existsById(ticketId)) {
                throw new TicketNotFoundException("Ticket not found");
            }
            ticketsRepository.deleteById(ticketId);
        }

        public List<Tickets> getTicketsByProjectId(Long projectId) {
            return projectRepository.findByProjectId(projectId);
        }
    @GetMapping("/user/{id}")
    public ResponseEntity<List<Tickets>> getTicketsByUserId(@PathVariable Long id) {
        try {
            List<Tickets> tickets = ticketsRepository.getTicketsByUserId(id);
            if (tickets.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                //logger.info("Retrieved tickets for User ID: {}", id);
                return new ResponseEntity<>(tickets, HttpStatus.OK);
            }
        } catch (Exception e) {
            //logger.error("Failed to retrieve tickets for User ID: {}", id, e);
            throw new RuntimeException("Failed to retrieve the tickets.", e);
        }
    }

    }



