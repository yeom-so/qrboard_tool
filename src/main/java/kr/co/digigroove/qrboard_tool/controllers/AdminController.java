package kr.co.digigroove.qrboard_tool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"/admin"})
public class AdminController {

    /**
     * 로그인 페이지
     * @return
     * @throws Exception
     */
    @RequestMapping(method= RequestMethod.GET)
    public String login() throws Exception {
        return "admin_login";
    }

    @RequestMapping(value="/main", method=RequestMethod.GET)
    public String main() throws Exception {
        return "admin/main";
    }

}
