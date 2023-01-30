package com.atomstroyrezerv.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "purpose")
@Data
public class Purpose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;

}
