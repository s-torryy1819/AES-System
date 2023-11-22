package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mentoring")
public class Mentoring {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer mentoringId;

    private String specialisation;
    private Integer numOfMonths;
    private Integer hoursOfWork;

    @OneToOne(mappedBy = "mentor")
    private Employee mentor;

    @OneToOne(mappedBy = "mentee")
    private Employee mentee;

    public Mentoring() {
    }

    public Mentoring(String specialisation, Integer numOfMonths, Integer hoursOfWork, Employee mentor,
            Employee mentee) {
        this.specialisation = specialisation;
        this.numOfMonths = numOfMonths;
        this.hoursOfWork = hoursOfWork;
        this.mentor = mentor;
        this.mentee = mentee;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public Integer getNumOfMonths() {
        return numOfMonths;
    }

    public void setNumOfMonths(Integer numOfMonths) {
        this.numOfMonths = numOfMonths;
    }

    public Integer getHoursOfWork() {
        return hoursOfWork;
    }

    public void setHoursOfWork(Integer hoursOfWork) {
        this.hoursOfWork = hoursOfWork;
    }

    public Employee getMentor() {
        return mentor;
    }

    public void setMentor(Employee mentor) {
        this.mentor = mentor;
    }

    public Employee getMentee() {
        return mentee;
    }

    public void setMentee(Employee mentee) {
        this.mentee = mentee;
    }

    public Integer getMentoringId() {
        return mentoringId;
    }

    public void setMentoringId(Integer mentoringId) {
        this.mentoringId = mentoringId;
    }

}
