package kr.co.digigroove.qrboard_tool.interceptor;

import kr.co.digigroove.qrboard_tool.entities.UserEntity;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		int isAdmin = 0;

		// 광고사업자용
		if (request.getRequestURI().contains("admin")) {
			isAdmin = 1;
		}

		// 로그인 사용자 정보
		UserEntity loginInfo = (UserEntity) request.getSession().getAttribute("user");
		if (loginInfo == null) {
			response.sendRedirect(request.getContextPath() + "/common/error?isAdmin=" + isAdmin);
			return false;
		}

		return true;
	}
}
