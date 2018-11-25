package com.ssau.freerealestate.model.postgresqlModel;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "posts")
public class Post implements Serializable{

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "isvalid")
    private boolean isValid;

    @OneToOne
    @JoinColumn(name = "realestateid")
    private RealEstate realEstate;

    @Column(name = "date")
    private Date date;

    @Column(name = "views")
    private int views;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public RealEstate getRealEstate() {
        return realEstate;
    }

    public void setRealEstate(RealEstate realEstate) {
        this.realEstate = realEstate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
