package com.cases.repository.impl.mongo;

import com.cases.model.Case;
import com.cases.model.ChatLine;
import com.cases.model.ParticipantUser;
import com.cases.repository.ICaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mario on 9/16/14.
 */
public class CaseMongoRepositoryImpl implements ICaseRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    public void chatToCase(@Param("particId") String partUserId, @Param("text") String text) {
        ParticipantUser p = mongoTemplate.findById(partUserId, ParticipantUser.class);
        mongoTemplate.save(new ChatLine(p, text));
    }


    public List<ChatLine> findChatsByCase(@Param("caseId") String caseId) {
        Query query  = new Query(Criteria.where("user.participantCase.caseId").is(caseId));


        return mongoTemplate.find(query, ChatLine.class);

    }
}
