package kr.co.digigroove.qrboard_tool.service;

import kr.co.digigroove.qrboard_tool.entities.UserEntity;
import kr.co.digigroove.qrboard_tool.entities.result.ResultEntity;

public interface UserService {
    ResultEntity checkLoginUser(UserEntity userEntity) throws Exception;
}
