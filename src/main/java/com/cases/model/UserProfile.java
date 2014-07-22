package com.cases.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;


/**
 * Created by mario.gray on 6/30/14.
 */
//@Entity
public class UserProfile {


    //@GeneratedValue(strategy = GenerationType.AUTO)

    @Id
    Long    userId;

    @Indexed(unique = true)
    String  fbId;
    @Indexed(unique = true)
    String  twitterId;

    @Indexed(unique = true)
    String  fbToken;
    @Indexed(unique = true)
    String  twitterToken;

    String  firstName;
    String  lastName;
    String  smsTelephone;
    @Indexed(unique = true)
    String  email;
    String  password;

    public UserProfile() {}

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFbId() {
        return fbId;
    }

    public void setFbId(String fbId) {
        this.fbId = fbId;
    }

    public String getTwitterId() {
        return twitterId;
    }

    public void setTwitterId(String twitterId) {
        this.twitterId = twitterId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSmsTelephone() {
        return smsTelephone;
    }

    public void setSmsTelephone(String smsTelephone) {
        this.smsTelephone = smsTelephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
