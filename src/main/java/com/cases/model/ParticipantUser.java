package com.cases.model;

import com.cases.CaseOneController;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by mario.gray on 6/30/14.
 */
@Document( collection="participant" )
public class ParticipantUser implements Serializable{


    @Id
    ObjectId    id;
    @DBRef
    UserProfile userProfile;
    @DBRef
    Case        participantCase;

    String      jabberId;
    @Indexed
    Role        role;

    public ParticipantUser ()  {} ;

    public ParticipantUser(UserProfile prof, Case pCase, Role role) {
        this.userProfile = prof;
        this.participantCase = pCase;
        this.role = role;

    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public Case getParticipantCase() {
        return participantCase;
    }

    public void setParticipantCase(Case participantCase) {
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
}
