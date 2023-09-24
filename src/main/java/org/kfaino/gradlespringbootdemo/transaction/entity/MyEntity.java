package org.kfaino.gradlespringbootdemo.transaction.entity;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "my_entity")
public class MyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}


