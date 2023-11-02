package com.example.grappler.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Entity
@Data
@ToString
public class Leaves {
@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @JsonProperty("date")
    private LocalDate Date;
    private String leavetype;
    private String  duration;
    private String approve;
    private String  day;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

}
