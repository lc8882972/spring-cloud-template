package com.yan.sa.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  long id;
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RoleRelationMenu> roleList;
    private  String name;
    private  String url;
    private  String description;
    private  Long parentNode;
    private Date createTime;
    private  boolean enabled;
}
