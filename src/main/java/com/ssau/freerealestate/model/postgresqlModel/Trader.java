package com.ssau.freerealestate.model.postgresqlModel;

import org.hibernate.annotations.Type;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "traders")
public class Trader implements Serializable {

    @Id
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "userid")
    private User user;

    @Column(name = "name")
    private String name;

    @Column(name = "info")
    private String info;

    @Column(name = "image")
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
