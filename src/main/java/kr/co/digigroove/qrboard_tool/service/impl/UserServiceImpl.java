package kr.co.digigroove.qrboard_tool.service.impl;

import kr.co.digigroove.commons.utils.HashUtils;
import kr.co.digigroove.qrboard_tool.constant.Default;
import kr.co.digigroove.qrboard_tool.dao.UserDAO;
import kr.co.digigroove.qrboard_tool.entities.UserEntity;
import kr.co.digigroove.qrboard_tool.entities.result.UserResultEntity;
import kr.co.digigroove.qrboard_tool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Value("#{serviceProp[hash_salt]}")
    private String hashSalt;

    @Override
    public UserResultEntity checkLoginUser(UserEntity userEntity) throws Exception {

        UserResultEntity userResultEntity = new UserResultEntity();

        // 로그인을 시도한 사용자정보
        UserEntity loginUserInfo = userDAO.selectLoginUserEntity(userEntity);
        // 비밀번호 암호화
        String password = HashUtils.encryptSHA256(userEntity.getUserPw(), hashSalt);

        if(loginUserInfo == null) {
            userResultEntity.setCode(Default.Result.EMPTY_USER);
        }else{
            // 사용자 상태 (0: 대기, 1: 승인, 2: 탈퇴) 체크
            if(loginUserInfo.getUserState() == 1){
                if(loginUserInfo.getUserPw().equals(password)){
                    userResultEntity.setCode(Default.Result.SUCCESS);
                    userResultEntity.setLoginInfo(loginUserInfo);
                }else{
                    userResultEntity.setCode(Default.Result.MISMATCH);
                }
            }else if(loginUserInfo.getUserState() == 0){
                userResultEntity.setCode(Default.Result.NOT_APPROVE);
            }else if(loginUserInfo.getUserState() == 2){
                userResultEntity.setCode(Default.Result.WITHDRAW);
            }
        }

        return userResultEntity;
    }

}
