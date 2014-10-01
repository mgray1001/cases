package com.cases.model;

import java.io.Serializable;

/**
 * Created by mario on 9/9/14.
 */
public class SimpleVote implements Serializable {

    String voterId;
    String value;
    String caseId;

    public SimpleVote() {}

    public SimpleVote(String voterId, String value, String caseId) {
        this.voterId = voterId;
        this.value = value;
        this.caseId = caseId;
    }

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleVote that = (SimpleVote) o;

        if (voterId != null ? !voterId.equals(that.voterId) : that.voterId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return voterId != null ? voterId.hashCode() : 0;
    }
}
