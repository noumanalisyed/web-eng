package com.techno.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "events")
public class Events implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "tournament_id", nullable = false)
    private Long tournamentId;

    @Column(name = "start_date", nullable = false)
   // @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    //@DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date endDate;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "created_at")
    //@DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date createdAt;

    @Column(name = "updated_at")
    //@DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date updatedAt;

    @Column(name = "activated", nullable = false)
    private Integer activated;

    @Column(name = "event_type_id")
    private Long eventTypeId;

}
