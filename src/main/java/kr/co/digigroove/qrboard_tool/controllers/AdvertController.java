package kr.co.digigroove.qrboard_tool.controllers;

import kr.co.digigroove.qrboard_tool.entities.AdvertEntity;
import kr.co.digigroove.qrboard_tool.entities.QrboardEntity;
import kr.co.digigroove.qrboard_tool.entities.TemplateShopEntity;
import kr.co.digigroove.qrboard_tool.entities.UserEntity;
import kr.co.digigroove.qrboard_tool.service.AdvertService;
import kr.co.digigroove.qrboard_tool.service.TemplateShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = {"/advert"})
public class AdvertController {

    @Autowired
    private AdvertService advertService;

    @Autowired
    private TemplateShopService templateShopService;

    /**
     * 광고 목록 페이지
     * @return
     * @throws Exception
     */
    @RequestMapping(method= RequestMethod.GET)
    public String selectAdvertEntityList(final Model model, HttpSession session, AdvertEntity advertEntity) throws Exception {
        UserEntity userEntity = (UserEntity) session.getAttribute("user");
        advertEntity.setUserIdx(userEntity.getUserIdx());
        return "user/qrboard";
    }

}
