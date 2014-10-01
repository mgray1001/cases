package com.cases.repository;

import com.cases.model.Case;
import com.cases.model.ChatLine;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mario.gray on 6/30/14.
 */

@NoRepositoryBean
public interface ICaseRepository {

    public void chatToCase(String partUserId, String text);

    public List<ChatLine> findChatsByCase(String caseId);

    //List<Case> getAllOpenCases(int start, int end);

//    boolean    visitCase(String pid, String caseId);

//    boolean    leaveCase(String pid, String caseId);






}
