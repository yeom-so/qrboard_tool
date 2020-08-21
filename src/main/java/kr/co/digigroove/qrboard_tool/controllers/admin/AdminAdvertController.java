package kr.co.digigroove.qrboard_tool.controllers.admin;

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
@RequestMapping(value = {"/admin/advert"})
public class AdminAdvertController {

    @Autowired
    private AdvertService advertService;

    @Autowired
    private QrboardAreaService qrboardAreaService;

    @Autowired
    private TemplateShopService templateShopService;

    @Autowired
    private PublicAdvertService publicAdvertService;

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
        return "test/advert_approve";
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
        return "test/advert_my";
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

        return "test/advert_mycreate";
    }

}
