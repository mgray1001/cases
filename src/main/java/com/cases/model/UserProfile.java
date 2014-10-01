package com.cases.model;

import io.baratine.core.ServiceRef;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


/**
 * Created by mario.gray on 6/30/14.
 */
//@Entity
@Document  (collection = "user" )
public class UserProfile implements Serializable{


    //@GeneratedValue(strategy = GenerationType.AUTO)

    @Id
    ObjectId    userId;


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

    public UserProfile(String e, String fn, String ln) {
        this.email = e;
        this.firstName = fn;
        this.lastName = ln;
    }
    public UserProfile() {}

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserProfile that = (UserProfile) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return userId != null ? userId.hashCode() : 0;
    }
}
