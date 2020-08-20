package kr.co.digigroove.qrboard_tool.controllers.rest;

import kr.co.digigroove.qrboard_tool.constant.Default;
import kr.co.digigroove.qrboard_tool.entities.UserEntity;
import kr.co.digigroove.qrboard_tool.entities.result.AngularResultEntity;
import kr.co.digigroove.qrboard_tool.entities.result.ResultEntity;
import kr.co.digigroove.qrboard_tool.entities.result.UserResultEntity;
import kr.co.digigroove.qrboard_tool.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@RequestMapping(value="/login")
	public UserResultEntity login(UserEntity userEntity, HttpSession session) {
		UserResultEntity userResultEntity = new UserResultEntity();

		try {
			userResultEntity = (UserResultEntity) userService.checkLoginUser(userEntity);
			if(userResultEntity.getCode().equals(Default.Result.MISMATCH)){
				userResultEntity.setUrl("/");
				userResultEntity.setMessage("비밀번호가 일치하지않습니다.");
			}else if(userResultEntity.getCode().equals(Default.Result.SUCCESS)){
				userResultEntity.setUrl("/");
				session.setAttribute("user", userResultEntity.getLoginInfo());
				userResultEntity.setCode(Default.Result.SUCCESS);
				if(userEntity.getUserGrade() == Default.UserGrade.ADVERTISER_ADMIN){
					// TODO: QR보드관리 목록으로 이동
					userResultEntity.setUrl("/admin/main");
				}else if(userEntity.getUserGrade() == Default.UserGrade.ADVERTISER){
					userResultEntity.setUrl("/user/main");
				}
				userResultEntity.setLoginInfo(userResultEntity.getLoginInfo());
			}else if(userResultEntity.getCode().equals(Default.Result.EMPTY_USER)){
				userResultEntity.setUrl("/");
				userResultEntity.setMessage("일치하는 사용자가 없습니다.");
			}else if(userResultEntity.getCode().equals(Default.Result.NOT_APPROVE)){
				userResultEntity.setUrl("/");
				userResultEntity.setMessage("승인 대기중인 사용자입니다.");
			}
//			else if(userResultEntity.getCode().equals(Default.Result.WITHDRAW)){
//				userResultEntity.setUrl("/");
//				userResultEntity.setMessage("탈퇴한 사용자");
//			}
		} catch (Exception e) {
			userResultEntity.setCode(Default.Result.FAIL);
			userResultEntity.setMessage("오류가 발생하였습니다.");
			LOGGER.error("UserRestController.loginSubmit:Failed", e);
		}

		return userResultEntity;
	}

	/**
	 * 로그아웃
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public ResultEntity logout(HttpSession session) {
		ResultEntity resultEntity = new ResultEntity();

		try {
			UserEntity userEntity = (UserEntity) session.getAttribute("user");
			if(userEntity.getUserGrade() == Default.UserGrade.ADVERTISER_ADMIN){
				resultEntity.setUrl("/admin");
			}else if(userEntity.getUserGrade() == Default.UserGrade.ADVERTISER){
				resultEntity.setUrl("/");
			}
			session.removeAttribute("user");
			resultEntity.setCode(Default.Result.SUCCESS);
			resultEntity.setMessage("로그아웃");
		} catch (Exception e) {
			resultEntity.setCode(Default.Result.FAIL);
			resultEntity.setMessage("오류가 발생했습니다.");
		}

		return resultEntity;
	}

	/**
	 * 회원가입
	 * @param userEntity
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertUserEntity", method= RequestMethod.POST)
	public ResultEntity insertUserEntity(UserEntity userEntity) throws Exception{
		ResultEntity resultEntity = new ResultEntity();

		try {
			resultEntity = userService.insertUserEntity(userEntity);
			if(resultEntity.getCode().equals(Default.Result.USE_EMAIL)){
				resultEntity.setMessage("사용중인 이메일주소입니다.");
			}else if(resultEntity.getCode().equals(Default.Result.SUCCESS)){
				resultEntity.setCode(Default.Result.SUCCESS);
				resultEntity.setMessage("회원가입 완료");
			}
		} catch (Exception e) {
			resultEntity.setCode(Default.Result.FAIL);
			resultEntity.setMessage("오류가 발생하였습니다.");
		}

		return resultEntity;
	}

	/**
	 * 유료회원변경
	 * @param userEntity
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/updatePayUserEntity")
	public AngularResultEntity updatePayUserEntity(UserEntity userEntity, HttpSession session) {
		AngularResultEntity angularResultEntity = new AngularResultEntity();

		try {
			session.setAttribute("user", userService.updatePayUserEntity(userEntity));
			angularResultEntity.setResult(Default.Result.SUCCESS);
			angularResultEntity.setMessage("성공");
		} catch (Exception e) {
			angularResultEntity.setResult(Default.Result.FAIL);
			angularResultEntity.setMessage("실패");
		}

		return angularResultEntity;
	}


	/**
	 * 내정보변경
	 * @param userEntity
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/updateUserEntity")
	public AngularResultEntity updateUserEntity(UserEntity userEntity, HttpSession session) {
		AngularResultEntity angularResultEntity = new AngularResultEntity();

		try {
			session.setAttribute("user", userService.updateUserEntity(userEntity));
			angularResultEntity.setResult(Default.Result.SUCCESS);
			angularResultEntity.setMessage("성공");
		} catch (Exception e) {
			angularResultEntity.setResult(Default.Result.FAIL);
			angularResultEntity.setMessage("실패");
		}

		return angularResultEntity;
	}

}
