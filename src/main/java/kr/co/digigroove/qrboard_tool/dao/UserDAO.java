package kr.co.digigroove.qrboard_tool.dao;

import kr.co.digigroove.qrboard_tool.entities.UserEntity;

public interface UserDAO {
    UserEntity selectLoginUserEntity(UserEntity userEntity) throws Exception;
}
