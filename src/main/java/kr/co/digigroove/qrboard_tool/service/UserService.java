package kr.co.digigroove.qrboard_tool.service;

import kr.co.digigroove.qrboard_tool.entities.UserEntity;
import kr.co.digigroove.qrboard_tool.entities.result.ResultEntity;

public interface UserService {
    /**
     * 로그인
     * @param userEntity
     * @return
     * @throws Exception
     */
    ResultEntity checkLoginUser(UserEntity userEntity) throws Exception;

    /**
     * 회원가입
     * @param userEntity
     * @return
     * @throws Exception
     */
    ResultEntity insertUserEntity(UserEntity userEntity) throws Exception;

    /**
     * 유료회원변경
     * @param userEntity
     * @throws Exception
     */
    UserEntity updatePayUserEntity(UserEntity userEntity) throws Exception;

    /**
     * 내정보변경
     * @param userEntity
     * @throws Exception
     */
    UserEntity updateUserEntity(UserEntity userEntity) throws Exception;
}
