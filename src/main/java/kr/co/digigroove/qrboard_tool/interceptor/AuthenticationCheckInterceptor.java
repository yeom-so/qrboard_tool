package kr.co.digigroove.qrboard_tool.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationCheckInterceptor extends HandlerInterceptorAdapter {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationCheckInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//		if (loginInfo == null) {
//			boolean isAjax = REQ_HEADER1.equalsIgnoreCase(ajaxHeader) || REQ_HEADER2.equalsIgnoreCase(ajaxHeader);
//			if (isAjax) response.sendRedirect(request.getContextPath() + "/common/errorAjax?code=error.need.login");
//			else        response.sendRedirect(request.getContextPath() + "/common/error?code=error.need.login&redirect=login&isAdmin=" + isAdmin);
//			return false;
//		}
//		else {
//			UserEntity currentInfo = userService.retrieveUserEntity(loginInfo);
//			final boolean isNotFoundInfo     = currentInfo == null;
//			if (isNotFoundInfo) {
//				request.getSession().removeAttribute(loginNm);
//				response.sendRedirect(request.getContextPath() + "/common/error?code=error.account.changed&redirect=login&isAdmin=" + isAdmin);
//				return false;
//			}
//		}

		return true;
	}
}
