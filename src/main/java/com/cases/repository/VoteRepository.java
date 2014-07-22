package com.cases.repository;

/**
 * Created by mario.gray on 6/30/14.
 */
public interface VoteRepository {

    void    castVote(String caseId, String pId, String value );

    void    forfeit(String caseId, String pId);

    void    dismiss(String caseId, String pId);


}
