package com.techno.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "event_types")
public class EventTypes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

   // @DateTimeFormat(pattern = "MM/dd/yyyy")
    @Column(name = "created_at")
    private Date createdAt;

   // @DateTimeFormat(pattern = "MM/dd/yyyy")
    @Column(name = "updated_at")
    private Date updatedAt;

}
