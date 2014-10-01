package com.cases.repository;

import com.cases.model.CaseVote;
import com.cases.model.SimpleVote;
import org.springframework.data.repository.query.Param;

/**
 * Created by mario.gray on 6/30/14.
 */
public interface IVoteRepository {


    CaseVote findByUser(String userId);
    //
    void    forfeit(String caseId, Long participantId);
    //
    void    dismiss(String caseId, Long participantId);

    void    castVote(String caseId, String participantId, String value );


}
