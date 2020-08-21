package kr.co.digigroove.qrboard_tool.controllers.user;

import kr.co.digigroove.qrboard_tool.entities.*;
import kr.co.digigroove.qrboard_tool.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = {"/user/advert"})
public class AdvertController {

    @Autowired
    private QrboardService qrboardService;

    @Autowired
    private AdvertService advertService;

    /**
     * 광고 목록 페이지
     * @return
     * @throws Exception
     */
    @RequestMapping(method= RequestMethod.GET)
    public String selectAdvertEntityList(final Model model, HttpSession session, AdvertEntity advertEntity) throws Exception {
        UserEntity userEntity = (UserEntity) session.getAttribute("user");
        advertEntity.setUserIdx(userEntity.getUserIdx());
        model.addAttribute("advertEntityList", advertService.selectAdvertEntityList(advertEntity));
        model.addAttribute("currentMenu", "advert");
        return "user/advert/ad_list";
    }

    /**
     * 광고 등록
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/create", method=RequestMethod.GET)
    public String insertAdvertEntity(final Model model, QrboardEntity qrboardEntity) throws Exception {
        model.addAttribute("qrboardEntityList", qrboardService.selectQrboardEntityListAll(qrboardEntity));
        model.addAttribute("currentMenu", "advert");
        return "test/advert_create";
    }

    /**
     * 광고 상세
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/detail", method=RequestMethod.GET)
    public String selectAdvertEntity(final Model model, AdvertEntity advertEntity) throws Exception {
        model.addAttribute("advertEntity", advertService.selectAdvertEntity(advertEntity));
        model.addAttribute("currentMenu", "advert");
        return "test/advert_detail";
    }

}
