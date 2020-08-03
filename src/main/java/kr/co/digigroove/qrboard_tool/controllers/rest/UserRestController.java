package kr.co.digigroove.qrboard_tool.controllers.rest;

import kr.co.digigroove.qrboard_tool.constant.Default;
import kr.co.digigroove.qrboard_tool.entities.UserEntity;
import kr.co.digigroove.qrboard_tool.entities.result.UserResultEntity;
import kr.co.digigroove.qrboard_tool.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

@RestController
@RequestMapping(value="/userRest")
public class UserRestController implements Serializable{

	private static final Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);

	@Autowired
	private UserService userService;

	/**
	 * 로그인
	 * @param userEntity
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/loginUser")
	public UserResultEntity loginSubmit(UserEntity userEntity, HttpSession session) {
		UserResultEntity result = new UserResultEntity();

		System.out.println("userEmail ::" + userEntity.getUserEmail());

		try {
			result = (UserResultEntity) userService.checkLoginUser(userEntity);
			if(result.getCode().equals(Default.Result.MISMATCH)){
				result.setUrl("/");
				result.setMessage("비번이 안맞음!!");
			}else if(result.getCode().equals(Default.Result.SUCCESS)){
				result.setUrl("/");
				session.setAttribute("User", result.getLoginInfo());
				result.setCode(Default.Result.SUCCESS);
				result.setMessage("로그인 성공!!");
				result.setLoginInfo(result.getLoginInfo());
			}else if(result.getCode().equals(Default.Result.EMPTY_USER)){
				result.setUrl("/");
				result.setMessage("일치하는 사용자가 없습니다.");
			}else if(result.getCode().equals(Default.Result.NOT_APPROVE)){
				result.setUrl("/");
				result.setMessage("승인 대기중인 사용자");
			}else if(result.getCode().equals(Default.Result.WITHDRAW)){
				result.setUrl("/");
				result.setMessage("탈퇴한 사용자");
			}
		} catch (Exception e) {
			result.setCode(Default.Result.FAIL);
			result.setMessage("오류가 발생하였습니다.");
			LOGGER.error("UserRestController.loginSubmit:Failed", e);
		}
		return result;
	}

	@RequestMapping(value="/test")
	public UserResultEntity test(UserEntity userEntity) {
		UserResultEntity result = new UserResultEntity();
		System.out.println("userEmail ::" + userEntity.getUserEmail());
		result.setCode(Default.Result.SUCCESS);
		return result;
	}

}
