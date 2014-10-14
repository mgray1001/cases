package com.cases.repository;

import com.cases.model.ChatLine;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/**
 * Created by mario.gray on 6/30/14.
 */

public interface ICaseRepository {

    public void chatToCase(String partUserId, String text);

    public List<ChatLine> findChatsByCase(String caseId);

    //List<Forum> getAllOpenCases(int start, int end);

//    boolean    visitCase(String pid, String caseId);

//    boolean    leaveCase(String pid, String caseId);






}
