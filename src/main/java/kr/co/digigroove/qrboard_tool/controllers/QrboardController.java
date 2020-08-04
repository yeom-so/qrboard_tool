package kr.co.digigroove.qrboard_tool.controllers;

import kr.co.digigroove.qrboard_tool.entities.QrboardEntity;
import kr.co.digigroove.qrboard_tool.entities.UserEntity;
import kr.co.digigroove.qrboard_tool.service.LayoutService;
import kr.co.digigroove.qrboard_tool.service.QrboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = {"/qrboard"})
public class QrboardController {

    @Autowired
    private QrboardService qrboardService;

    @Autowired
    private LayoutService layoutService;

    /**
     * QR보드 목록 페이지
     * @return
     * @throws Exception
     */
    @RequestMapping(method= RequestMethod.GET)
    public String selectQrboardEntityList(final Model model, HttpSession session, QrboardEntity qrboardEntity) throws Exception {
        UserEntity userEntity = (UserEntity) session.getAttribute("user");
        qrboardEntity.setUserIdx(userEntity.getUserIdx());
        model.addAttribute("qrboardEntityList", qrboardService.selectQrboardEntityList(qrboardEntity));
        model.addAttribute("layoutEntityList", layoutService.selectLayoutEntityList());
        return "user/qrboard";
    }

    /**
     * QR보드 목록 페이지
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/detail", method=RequestMethod.GET)
    public String selectQrboardEntity(final Model model, HttpSession session, QrboardEntity qrboardEntity) throws Exception {
        model.addAttribute("qrboardEntity", qrboardService.selectQrboardEntity(qrboardEntity));
        return "user/qrboard_detail";
    }
}
