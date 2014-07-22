package com.cases.repository;

import com.cases.model.Case;

import java.util.List;

/**
 * Created by mario.gray on 6/30/14.
 */

public interface ICaseRepository {

    List<Case> getCasesByParticipantId(String pid, int start, int end);

    List<Case> getMyCases(String pid, int start, int end);

    List<Case> getAllOpenCases(int start, int end);


    boolean putCase(Case c);

//    boolean    visitCase(String pid, String caseId);

//    boolean    leaveCase(String pid, String caseId);






}
