package com.ssafy.api.service;

import com.ssafy.api.request.AdoptFormReq;
import com.ssafy.api.request.StatusUpdatePutReq;
import com.ssafy.api.response.BoardListData;
import com.ssafy.db.entity.auth.CounselingHistory;
import com.ssafy.db.entity.auth.UserProfile;
import com.ssafy.db.entity.board.Board;

import java.util.List;

public interface AdoptService {

    List<BoardListData> getAdoptBoardList();

    CounselingHistory insertAdoptForm(String userId, AdoptFormReq adoptFormReq);


    CounselingHistory updateStatus(Long id, StatusUpdatePutReq statusUpdatePutReq);

    UserProfile findByUserId(String userId);

    boolean canAdoptForm(String userId, Long boardId);


}
