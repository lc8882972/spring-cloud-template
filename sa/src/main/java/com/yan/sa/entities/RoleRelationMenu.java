package com.yan.sa.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "role_menu")
public class RoleRelationMenu implements Serializable {
    @Id
    @ManyToOne(targetEntity = Role.class)
    @JoinColumn(name = "role_id")
    private Role role;
    @Id
    @ManyToOne(targetEntity = Menu.class)
    @JoinColumn(name = "menu_id")
    private  Menu menu;
}
