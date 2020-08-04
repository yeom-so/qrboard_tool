package kr.co.digigroove.qrboard_tool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"", "/", "/user"})
public class UserController {

    /**
     * 로그인 페이지
     * @return
     * @throws Exception
     */
    @RequestMapping(method= RequestMethod.GET)
    public String login() throws Exception {
        return "login";
    }

    /**
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/user", method=RequestMethod.GET)
    public String test() throws Exception {
        return "user/user";
    }

}
