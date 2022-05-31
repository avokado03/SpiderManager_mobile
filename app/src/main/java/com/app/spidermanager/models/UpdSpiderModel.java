package com.app.spidermanager.models;

import java.util.Date;

public class UpdSpiderModel {
    private final int id;
    private String name, type;
    private byte[] photo;
    private boolean sex;
    private Date lastFeedingDate, lastMoltingDate;

    public UpdSpiderModel(int id, String name, String type,
                          byte[] photo, boolean sex,
                          Date lastFeedingDate, Date lastMoltingDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.photo = photo;
        this.sex = sex;
        this.lastFeedingDate = lastFeedingDate;
        this.lastMoltingDate = lastMoltingDate;
    }


}
