package com.cases.repository.impl.mongo;

import com.cases.model.CaseVote;
import com.cases.repository.IVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.repository.query.Param;

/**
 * Created by mario on 10/1/14.
 */
public class VoteMongoRepositoryImpl implements IVoteRepository {
    @Autowired
    MongoTemplate   mongoTemplate;


    public CaseVote findByUser(@Param("userId")String userId) {
        return new CaseVote();
    }
    //
    public void    forfeit(@Param("caseId")String caseId, @Param("userId")Long userId) {

    }
    //
    public void    dismiss(@Param("caseId")String caseId, @Param("userId")Long pId) {

    }

    public void    castVote(String caseId, String pId, String value ) {

    }

}
