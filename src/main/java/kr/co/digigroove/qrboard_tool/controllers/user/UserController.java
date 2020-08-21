package kr.co.digigroove.qrboard_tool.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"", "/", "/user"})
public class UserController {

    /**
     * 로그인
     * @return
     * @throws Exception
     */
    @RequestMapping(method= RequestMethod.GET)
    public String login() throws Exception {
        return "user_login";
    }

    /**
     * 회원가입 > 약관동의
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/term", method=RequestMethod.GET)
    public String term() throws Exception {
        return "user_term";
    }

    /**
     * 회원가입
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/join", method=RequestMethod.GET)
    public String join() throws Exception {
        return "user_join";
    }

    /**
     * 메인
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/main", method=RequestMethod.GET)
    public String main() throws Exception {
        return "user_main";
    }

    /**
     * 정보변경
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/mypage", method=RequestMethod.GET)
    public String mypage(final Model model) throws Exception {
        model.addAttribute("currentMenu", "mypage");
        return "user/mypage";
    }

}
