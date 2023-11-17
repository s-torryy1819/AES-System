package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mentoring")
public class Mentoring {

    @Id
    private Integer mentoringId;

    private String specialisation;
    private Integer num_of_months;
    private Integer hours_of_work;

    @OneToOne(mappedBy = "mentor")
    private Employee mentor;

    @OneToOne(mappedBy = "mentee")
    private Employee mentee;

}
