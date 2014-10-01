package com.cases.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by mario.gray on 6/30/14.
 */
@Document  ( collection = "vote" )

@CompoundIndexes({
        @CompoundIndex(name = "vote_ident_idx", def="{'participantUser.id':1,'participantCase.caseId':1}")
})

public class CaseVote implements Serializable {

    @Id
    ObjectId voteId;
    @DBRef
    ParticipantUser participantUser;
    @DBRef
    Case            participantCase;
    @Indexed
    String          value;

    public CaseVote () {}


    public ObjectId getVoteId() {
        return voteId;
    }

    public void setVoteId(ObjectId voteId) {
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
