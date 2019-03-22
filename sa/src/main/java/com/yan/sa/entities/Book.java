package com.yan.sa.entities;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "book")
@Entity
@Data
public class Book {
    @Id
    private  int id;
    private  String name;
}
