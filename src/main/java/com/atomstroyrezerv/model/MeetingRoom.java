package com.atomstroyrezerv.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "meeting_room")
@Data
public class MeetingRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;

}
