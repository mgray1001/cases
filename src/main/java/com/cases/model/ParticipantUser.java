package com.cases.model;

import com.cases.CaseOneController;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created by mario.gray on 6/30/14.
 */
//@Entity
public class ParticipantUser implements Serializable{


    UserProfile userProfile;
    Case        participantCase;
    String      jabberId;
    Role        role;

    public ParticipantUser ()  {} ;

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
