package kr.co.digigroove.qrboard_tool.controllers.admin;

import kr.co.digigroove.qrboard_tool.entities.QrboardEntity;
import kr.co.digigroove.qrboard_tool.entities.UserEntity;
import kr.co.digigroove.qrboard_tool.service.LayoutService;
import kr.co.digigroove.qrboard_tool.service.QrboardAreaService;
import kr.co.digigroove.qrboard_tool.service.QrboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = {"/admin/qrboard"})
public class AdminQrboardController {

    @Autowired
    private QrboardService qrboardService;

    @Autowired
    private QrboardAreaService qrboardAreaService;

    /**
     * 광고주 QR보드 목록 페이지
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/advert", method=RequestMethod.GET)
    public String selectQrboardEntityAdvertList(final Model model, HttpSession session, QrboardEntity qrboardEntity) throws Exception {
        UserEntity userEntity = (UserEntity) session.getAttribute("user");
        qrboardEntity.setUserIdx(userEntity.getUserIdx());
        model.addAttribute("qrboardEntityList", qrboardService.selectQrboardAdvertEntityList(qrboardEntity));
        return "test/qrboard_advert";
    }

    /**
     * 광고주 QR보드 상세 페이지
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/advert_detail", method=RequestMethod.GET)
    public String selectQrboardAreaAdvertEntityList(final Model model, QrboardEntity qrboardEntity) throws Exception {
        model.addAttribute("qrboardAreaEntityList", qrboardAreaService.selectQrboardAreaAdvertEntityList(qrboardEntity));
        return "test/qrboard_advert_detail";
    }

}
