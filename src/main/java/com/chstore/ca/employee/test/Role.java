package com.chstore.ca.employee.test;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    private Collection<User> users;
}