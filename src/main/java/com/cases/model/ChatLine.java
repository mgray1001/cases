package com.cases.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by mario on 9/16/14.
 */
@Document( collection = "chat")
public class ChatLine implements Serializable {

    @Indexed
    @DBRef
    ParticipantUser user;

    @Indexed
    @DBRef
    Forum relCase;

    String          value;

    public ChatLine(ParticipantUser user, String value) {
        this.user = user;
        this.relCase = user.participantCase;
        this.value = value;
    }
    public ParticipantUser getUser() {
        return user;
    }

    public void setUser(ParticipantUser user) {
        this.user = user;
    }

    public Forum getRelCase() {
        return relCase;
    }

    public void setRelCase(Forum relCase) {
        this.relCase = relCase;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}


