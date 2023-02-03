package com.atomstroyrezerv.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "event")
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "start_time", nullable = false)
    private Date startTime;
    @Column(name = "end_time", nullable = false)
    private Date endTime;
    @Column(nullable = false)
    private String name;
    @Column(name = "creation_time", nullable = false)
    private Date creationTime;
    @Column(nullable = false)
    private int purpose;
    @Column(name = "meeting_room", nullable = false)
    private int meetingRoom;
    @Column(name = "initial_state", nullable = false)
    private int initialState;
    @Column(nullable = false)
    private String applicant;
    @Column(name = "participants_list", nullable = false)
    private String participantsList;
    @Column(name = "last_version", nullable = false)
    private boolean lastVersion;

}
