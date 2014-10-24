package com.cases.model.mongo;

import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by mario.gray on 6/30/14.
 */
@Document  ( collection = "vote" )

@CompoundIndexes({
        @CompoundIndex(name = "vote_ident_idx", def="{'participantUser.id':1,'participantCase.caseId':1}")
})
public class CaseVote implements Serializable {

    @Id
    String voteId;
    @DBRef
    ParticipantUser participantUser;
    @DBRef
    Forum participantCase;
    @Indexed
    String          value;

    Date timestamp;

    public CaseVote () {}


    public String getVoteId() {
        return voteId;
    }

    public void setVoteId(String voteId) {
        this.voteId = voteId;
    }


    public ParticipantUser getParticipantUser() {
        return participantUser;
    }

    public void setParticipantUser(ParticipantUser participantUser) {
        this.participantUser = participantUser;
    }

    public Forum getParticipantCase() {
        return participantCase;
    }

    public void setParticipantCase(Forum participantCase) {
        this.participantCase = participantCase;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
