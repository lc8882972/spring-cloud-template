package com.yan.sa.entities;

import lombok.Data;
import javax.persistence.*;

@Table(name = "book")
@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  int id;
    private  String name;
}
