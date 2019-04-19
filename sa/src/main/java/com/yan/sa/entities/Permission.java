package com.yan.sa.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "permission")
public class Permission implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
    @Id
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
