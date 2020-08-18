package kr.co.digigroove.qrboard_tool.controllers;

import kr.co.digigroove.qrboard_tool.constant.Default;
import kr.co.digigroove.qrboard_tool.entities.*;
import kr.co.digigroove.qrboard_tool.service.*;
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

    @Autowired
    private QrboardAreaService qrboardAreaService;

    @Autowired
    private TemplateShopService templateShopService;

    @Autowired
    private PublicAdvertService publicAdvertService;

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
        advertEntity.setSearchAdvertType(Default.SearchAdvertType.ADVERTISER);
        model.addAttribute("advertEntityList", advertService.selectAdvertApproveEntityList(advertEntity));
        return "user/advert_approve";
    }

    /**
     * 광고사업자용 QR보드에 등록된 내 광고 목록
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/my", method=RequestMethod.GET)
    public String selectMyAdvertEntityList(final Model model, HttpSession session, AdvertEntity advertEntity) throws Exception {
        UserEntity userEntity = (UserEntity) session.getAttribute("user");
        advertEntity.setUserIdx(userEntity.getUserIdx());
        advertEntity.setSearchAdvertType(Default.SearchAdvertType.ADVERTISER_ADMIN);
        model.addAttribute("advertEntityList", advertService.selectAdvertApproveEntityList(advertEntity));
        return "user/advert_my";
    }

    /**
     * 내QR보드에 광고 등록
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/mycreate", method=RequestMethod.GET)
    public String insertMyAdvertEntity(final Model model, QrboardAreaEntity qrboardAreaEntity) throws Exception {
        qrboardAreaEntity = qrboardAreaService.selectQrboardAreaEntity(qrboardAreaEntity);
        model.addAttribute("qrboardAreaEntity", qrboardAreaService.selectQrboardAreaEntity(qrboardAreaEntity));

        // 업종템플릿 목록
        TemplateShopEntity templateShopEntity = new TemplateShopEntity();
        templateShopEntity.setTemplateIdx(qrboardAreaEntity.getTemplateIdx());
        model.addAttribute("templateShopEntityList", templateShopService.selectTemplateShopEntityList(templateShopEntity));

        // 공용광고 목록
        PublicAdvertEntity publicAdvertEntity = new PublicAdvertEntity();
        publicAdvertEntity.setTemplateIdx(qrboardAreaEntity.getTemplateIdx());
        model.addAttribute("publicAdvertEntityList", publicAdvertService.selectPublicAdvertEntityList(publicAdvertEntity));

        return "user/advert_mycreate";
    }

}
