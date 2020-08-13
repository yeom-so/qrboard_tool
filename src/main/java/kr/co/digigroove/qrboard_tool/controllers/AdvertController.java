package kr.co.digigroove.qrboard_tool.controllers;

import kr.co.digigroove.qrboard_tool.entities.AdvertEntity;
import kr.co.digigroove.qrboard_tool.entities.QrboardEntity;
import kr.co.digigroove.qrboard_tool.entities.UserEntity;
import kr.co.digigroove.qrboard_tool.service.AdvertService;
import kr.co.digigroove.qrboard_tool.service.QrboardService;
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
        return "user/advert";
    }

    /**
     * 광고 등록
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/create", method=RequestMethod.GET)
    public String insertAdvertEntity(final Model model, QrboardEntity qrboardEntity) throws Exception {
        // 모든 QR보드 목록
        model.addAttribute("qrboardEntityList", qrboardService.selectQrboardEntityListAll(qrboardEntity));
        return "user/advert_create";
    }

    /**
     * 광고 상세
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/detail", method=RequestMethod.GET)
    public String selectAdvertEntity(final Model model, AdvertEntity advertEntity) throws Exception {
        model.addAttribute("advertEntity", advertService.selectAdvertEntity(advertEntity));
        return "user/advert_detail";
    }

    /**
     * 광고사업자용 QR보드에 등록된 광고 목록
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/approve", method=RequestMethod.GET)
    public String selectAdvertApproveEntityList(final Model model, HttpSession session, AdvertEntity advertEntity) throws Exception {
        UserEntity userEntity = (UserEntity) session.getAttribute("user");
        advertEntity.setUserIdx(userEntity.getUserIdx());
        model.addAttribute("advertEntityList", advertService.selectAdvertApproveEntityList(advertEntity));
        return "user/advert_approve";
    }
}
