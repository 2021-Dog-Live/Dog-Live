package com.ssafy.api.controller;

import com.ssafy.api.request.AdoptFormReq;
import com.ssafy.api.service.AdoptService;
import com.ssafy.common.model.response.BaseResponseBody;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 유기동물 입양 API 요청 처리를 위한 컨트롤러 정의.
 */
@CrossOrigin(origins={"*"}, maxAge=6000)
@Api(value = "유기동물 입양 API", tags = {"Adopt"})
@RestController
@RequestMapping("/api/v1/adopt")
public class AdoptController {

    @Autowired
    AdoptService adoptService;

    @PostMapping("/form/{userId}")
    @ApiOperation(value = "입양신청서 등록", notes = "입양신청서를 작성하고 저장한다")
    @ApiResponses({
            @ApiResponse(code = 204, message = "성공"),
            @ApiResponse(code = 401, message = "인증 실패"),
            @ApiResponse(code = 404, message = "사용자 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<? extends BaseResponseBody> insertAdoptForm(@PathVariable("userId") String id, @RequestBody @ApiParam(value="입양신청 등록 정보", required = true) AdoptFormReq adoptFormReq){

        adoptService.insertAdoptForm(id, adoptFormReq);

        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "입양신청서가 정상적으로 등록되었습니다"));
    }
}
