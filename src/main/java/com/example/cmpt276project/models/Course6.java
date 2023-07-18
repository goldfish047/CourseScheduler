package com.example.cmpt276project.models;

import jakarta.persistence.*;

@Entity
@Table(name="course6")
public class Course6 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name; 

    private int section; 

    private boolean open = false; //boolean value that indicates whether a class has a prof assigned or not
    
    // booleans that indicate when the class will be held 
    private boolean eve_mon; 
    private boolean pm_mon; 
    private boolean am_mon; 

    private boolean eve_tues; 
    private boolean pm_tues; 
    private boolean am_tues; 

    private boolean eve_weds; 
    private boolean pm_weds; 
    private boolean am_weds; 

    private boolean eve_thurs; 
    private boolean pm_thurs; 
    private boolean am_thurs;

    private boolean pm_fri;
    private boolean am_fri;

    public Course6() {
    }
    public Course6(String name, int section, boolean open, boolean eve_mon, boolean pm_mon, boolean am_mon,
            boolean eve_tues, boolean pm_tues, boolean am_tues, boolean eve_weds, boolean pm_weds, boolean am_weds,
            boolean eve_thurs, boolean pm_thurs, boolean am_thurs, boolean pm_fri, boolean am_fri) {
        this.name = name;
        this.section = section;
        this.open = open;
        this.eve_mon = eve_mon;
        this.pm_mon = pm_mon;
        this.am_mon = am_mon;
        this.eve_tues = eve_tues;
        this.pm_tues = pm_tues;
        this.am_tues = am_tues;
        this.eve_weds = eve_weds;
        this.pm_weds = pm_weds;
        this.am_weds = am_weds;
        this.eve_thurs = eve_thurs;
        this.pm_thurs = pm_thurs;
        this.am_thurs = am_thurs;
        this.pm_fri = pm_fri;
        this.am_fri = am_fri;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSection() {
        return section;
    }
    public void setSection(int section) {
        this.section = section;
    }
    public boolean isOpen() {
        return open;
    }
    public void setOpen(boolean open) {
        this.open = open;
    }
    public boolean isEve_mon() {
        return eve_mon;
    }
    public void setEve_mon(boolean eve_mon) {
        this.eve_mon = eve_mon;
    }
    public boolean isPm_mon() {
        return pm_mon;
    }
    public void setPm_mon(boolean pm_mon) {
        this.pm_mon = pm_mon;
    }
    public boolean isAm_mon() {
        return am_mon;
    }
    public void setAm_mon(boolean am_mon) {
        this.am_mon = am_mon;
    }
    public boolean isEve_tues() {
        return eve_tues;
    }
    public void setEve_tues(boolean eve_tues) {
        this.eve_tues = eve_tues;
    }
    public boolean isPm_tues() {
        return pm_tues;
    }
    public void setPm_tues(boolean pm_tues) {
        this.pm_tues = pm_tues;
    }
    public boolean isAm_tues() {
        return am_tues;
    }
    public void setAm_tues(boolean am_tues) {
        this.am_tues = am_tues;
    }
    public boolean isEve_weds() {
        return eve_weds;
    }
    public void setEve_weds(boolean eve_weds) {
        this.eve_weds = eve_weds;
    }
    public boolean isPm_weds() {
        return pm_weds;
    }
    public void setPm_weds(boolean pm_weds) {
        this.pm_weds = pm_weds;
    }
    public boolean isAm_weds() {
        return am_weds;
    }
    public void setAm_weds(boolean am_weds) {
        this.am_weds = am_weds;
    }
    public boolean isEve_thurs() {
        return eve_thurs;
    }
    public void setEve_thurs(boolean eve_thurs) {
        this.eve_thurs = eve_thurs;
    }
    public boolean isPm_thurs() {
        return pm_thurs;
    }
    public void setPm_thurs(boolean pm_thurs) {
        this.pm_thurs = pm_thurs;
    }
    public boolean isAm_thurs() {
        return am_thurs;
    }
    public void setAm_thurs(boolean am_thurs) {
        this.am_thurs = am_thurs;
    }
    public boolean isPm_fri() {
        return pm_fri;
    }
    public void setPm_fri(boolean pm_fri) {
        this.pm_fri = pm_fri;
    }
    public boolean isAm_fri() {
        return am_fri;
    }
    public void setAm_fri(boolean am_fri) {
        this.am_fri = am_fri;
    }



}
