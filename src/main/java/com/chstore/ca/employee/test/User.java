package com.chstore.ca.employee.test;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    private Collection<Role> roles;

    public Collection<Role> getRoles() {
        return roles;
    }
}