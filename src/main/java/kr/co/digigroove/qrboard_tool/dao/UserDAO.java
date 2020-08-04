package kr.co.digigroove.qrboard_tool.dao;

import kr.co.digigroove.qrboard_tool.entities.UserEntity;

public interface UserDAO {
    /**
     * 로그인 사용자 정보 상세
     * @param userEntity
     * @return
     * @throws Exception
     */
    UserEntity selectLoginUserEntity(UserEntity userEntity) throws Exception;

    /**
     * 유료회원변경
     * @param userEntity
     * @throws Exception
     */
    void updatePayUserEntity(UserEntity userEntity) throws Exception;

    /**
     * 회원상세
     * @param userEntity
     * @return
     * @throws Exception
     */
    UserEntity selectUserEntity(UserEntity userEntity) throws Exception;

    /**
     * 내정보변경
     * @param userEntity
     * @throws Exception
     */
    void updateUserEntity(UserEntity userEntity) throws Exception;

    /**
     * 회원가입
     * @param userEntity
     * @throws Exception
     */
    void insertUserEntity(UserEntity userEntity) throws Exception;
}
