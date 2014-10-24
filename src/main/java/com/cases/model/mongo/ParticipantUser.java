package com.cases.model.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by mario.gray on 6/30/14.
 */
@Document( collection="participant" )
public class ParticipantUser implements Serializable{


    @Id
    String    id;
    @DBRef
    UserProfile userProfile;
    @DBRef
    Forum participantCase;

    String      jabberId;
    @Indexed
    Role        role;

    Date created;
    public ParticipantUser ()  {} ;

    public ParticipantUser(UserProfile prof, Forum pCase, Role role) {
        this.userProfile = prof;
        this.participantCase = pCase;
        this.role = role;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public Forum getParticipantCase() {
        return participantCase;
    }

    public void setParticipantCase(Forum participantCase) {
        this.participantCase = participantCase;
    }

    public String getJabberId() {
        return jabberId;
    }

    public void setJabberId(String jabberId) {
        this.jabberId = jabberId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
