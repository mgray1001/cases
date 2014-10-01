package com.cases.repository;

import com.cases.model.CaseVote;
import com.cases.model.SimpleVote;
import org.springframework.data.repository.query.Param;

/**
 * Created by mario.gray on 6/30/14.
 */
public interface IVoteRepository {


    CaseVote findByUser(@Param("userId")String userId);
        //
    void    forfeit(@Param("caseId")String caseId, @Param("userId")Long userId);
    //
    void    dismiss(@Param("caseId")String caseId, @Param("userId")Long pId);

    void    castVote(String caseId, String pId, String value );


}
