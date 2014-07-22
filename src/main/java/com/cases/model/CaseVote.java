package com.cases.model;

import org.springframework.data.mongodb.core.index.Indexed;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by mario.gray on 6/30/14.
 */
//@Entity
public class CaseVote implements Serializable {

    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    Long            voteId;

    @Indexed(unique = true)
    ParticipantUser participantUser;
    @Indexed(unique = true)
    Case            participantCase;
    String          value;

    // String       chatConversationId;
    public CaseVote () {}


    public Long getVoteId() {
        return voteId;
    }

    public void setVoteId(Long voteId) {
        this.voteId = voteId;
    }


    public ParticipantUser getParticipantUser() {
        return participantUser;
    }

    public void setParticipantUser(ParticipantUser participantUser) {
        this.participantUser = participantUser;
    }

    public Case getParticipantCase() {
        return participantCase;
    }

    public void setParticipantCase(Case participantCase) {
        this.participantCase = participantCase;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
