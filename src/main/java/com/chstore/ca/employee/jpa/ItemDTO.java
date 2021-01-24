package com.chstore.ca.employee.jpa;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
public class ItemDTO implements Serializable {

    private String name;
}