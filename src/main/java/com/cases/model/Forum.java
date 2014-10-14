package com.cases.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by mario.gray on 6/30/14.
 */
//@Entity
@Document( collection = "cases" )
public class Forum implements Serializable{


    @Id
    String      caseId;
    @Indexed
    String      description;
    @Indexed(unique = true)
    String      jid;
    @DBRef
    UserProfile plantiff;
    @DBRef
    UserProfile defendant;
    @Indexed
    Date    start;
    @Indexed
    Date    end;


    long    maxDurationMS;

    public Forum() {}

    public Forum(String desc, UserProfile p, UserProfile d) {
        this.description = desc;
        this.plantiff = p;
        this.defendant = d;
        this.start = new Date();
    }


    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJid() {
        return jid;
    }

    public void setJid(String jid) {
        this.jid = jid;
    }

    public UserProfile getPlantiff() {
        return plantiff;
    }

    public void setPlantiff(UserProfile plantiff) {
        this.plantiff = plantiff;
    }

    public UserProfile getDefendant() {
        return defendant;
    }

    public void setDefendant(UserProfile defendant) {
        this.defendant = defendant;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public long getMaxDurationMS() {
        return maxDurationMS;
    }

    public void setMaxDurationMS(long maxDurationMS) {
        this.maxDurationMS = maxDurationMS;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
