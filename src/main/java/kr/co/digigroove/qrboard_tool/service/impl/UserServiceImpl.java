package kr.co.digigroove.qrboard_tool.service.impl;

import kr.co.digigroove.commons.utils.HashUtils;
import kr.co.digigroove.qrboard_tool.constant.Default;
import kr.co.digigroove.qrboard_tool.dao.UserDAO;
import kr.co.digigroove.qrboard_tool.entities.UserEntity;
import kr.co.digigroove.qrboard_tool.entities.result.ResultEntity;
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

    /**
     * 로그인
     * @param userEntity
     * @return
     * @throws Exception
     */
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

    @Override
    public ResultEntity insertUserEntity(UserEntity userEntity) throws Exception {
        ResultEntity resultEntity = new ResultEntity();

        // 이메일 중복체크
        UserEntity userInfo = userDAO.selectLoginUserEntity(userEntity);

        if(userInfo != null) {
            resultEntity.setCode(Default.Result.USE_EMAIL);
        }else{
            // 비밀번호 암호화
            userEntity.setUserPw(HashUtils.encryptSHA256(userEntity.getUserPw(), hashSalt));
            // 사용자 등급에 따른 데이터 변경
            if(userEntity.getUserGrade() == Default.UserGrade.ADVERTISER_ADMIN){    // 광고사업주
                userEntity.setUserType(Default.UserType.PAID_MEMBER);
                userEntity.setUserState(Default.UserState.WAIT);
            }else if(userEntity.getUserGrade() == Default.UserGrade.ADVERTISER){    // 광고주
                userEntity.setUserType(Default.UserType.FREE_MEMBER);
                userEntity.setUserState(Default.UserState.APPROVE);
            }
            // 회원가입
            userDAO.insertUserEntity(userEntity);
            resultEntity.setCode(Default.Result.SUCCESS);
        }

        return resultEntity;
    }

    /**
     * 유료회원변경
     * @param userEntity
     * @return
     * @throws Exception
     */
    @Override
    public UserEntity updatePayUserEntity(UserEntity userEntity) throws Exception {
        // 유료회원
        userEntity.setUserType(Default.UserType.PAID_MEMBER);
        userDAO.updatePayUserEntity(userEntity);
        // 회원상세
        return userDAO.selectUserEntity(userEntity);
    }

    /**
     * 내정보변경
     * @param userEntity
     * @return
     * @throws Exception
     */
    @Override
    public UserEntity updateUserEntity(UserEntity userEntity) throws Exception{
        if(userEntity.getUserPw() != null && !userEntity.getUserPw().equals("")){
            // 변경할 비밀번호 암호화
            userEntity.setUserPw(HashUtils.encryptSHA256(userEntity.getUserPw(), hashSalt));
        }
        userDAO.updateUserEntity(userEntity);
        // 회원상세
        return userDAO.selectUserEntity(userEntity);
    }

}
