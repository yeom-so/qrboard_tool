package kr.co.digigroove.qrboard_tool.controllers;

import kr.co.digigroove.qrboard_tool.entities.result.ErrorResultEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/common")
public class CommonController {

	private static final class Url {
		private static final String USER = "/";
		private static final String ADMIN = "/admin";
	}

	/**
	 * 에러 페이지
	 * @param errorResult
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String userError(@ModelAttribute ErrorResultEntity errorResult) throws Exception {
		errorResult.setMessage("세션이 만료되어 로그인 화면으로 돌아갑니다.");
		errorResult.setUrl(errorResult.getIsAdmin() == 1 ? Url.ADMIN : Url.USER);
		return "error";
	}

}
