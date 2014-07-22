package com.cases.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by mario.gray on 6/30/14.
 */
//@Entity
public class Case implements Serializable{

    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    String      caseId;

    String      description;
    String      jid;

    ParticipantUser plantiff;
    ParticipantUser defendant;

    Date    start;
    long    maxDurationMS;

    public Case() {}


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

    public ParticipantUser getPlantiff() {
        return plantiff;
    }

    public void setPlantiff(ParticipantUser plantiff) {
        this.plantiff = plantiff;
    }

    public ParticipantUser getDefendant() {
        return defendant;
    }

    public void setDefendant(ParticipantUser defendant) {
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
}
