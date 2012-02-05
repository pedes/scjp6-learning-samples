package net.mgorski.scjp.performance;

import java.io.Serializable;

public class Profile implements Serializable {
    
    private static final long serialVersionUID = -1490845219870943611L;
    
    private int id;
    private String name;
    private String surname;
    private int[] friendIds;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public int[] getFriendIds() {
        return friendIds;
    }
    public void setFriendIds(int[] friendIds) {
        this.friendIds = friendIds;
    }
    
    
}
