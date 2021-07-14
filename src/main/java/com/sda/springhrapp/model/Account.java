package com.sda.springhrapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  Integer id;
    @Column(name="creationDate")
    private Date creationDate;
    @OneToOne(mappedBy = "account") // Name of the field which reflects it. This one is from the Employee class, not from the Database.
    private Employee employee;

}
