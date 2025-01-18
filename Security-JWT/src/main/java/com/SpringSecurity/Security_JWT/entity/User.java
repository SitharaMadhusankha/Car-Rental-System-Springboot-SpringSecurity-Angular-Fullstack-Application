package com.SpringSecurity.Security_JWT.entity;



import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    private String userName;
    private String userFirstName;
    private String getUserLastName;
    private String userPassword;
    //many to many mapping
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE",joinColumns ={
            @JoinColumn(name ="USER_ID" )
    },
    inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID")
    }
    )
    private Set<Role> role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserFirstName(String sithara) {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getGetUserLastName() {
        return getUserLastName;
    }

    public void setGetUserLastName(String getUserLastName) {
        this.getUserLastName = getUserLastName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }


}
