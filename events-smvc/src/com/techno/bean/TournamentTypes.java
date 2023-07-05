package com.techno.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "tournament_types")
public class TournamentTypes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "created_at")
   // @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date createdAt;

    @Column(name = "updated_at")
   // @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date updatedAt;

}
