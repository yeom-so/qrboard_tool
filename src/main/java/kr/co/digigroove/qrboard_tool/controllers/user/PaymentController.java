package kr.co.digigroove.qrboard_tool.controllers.user;

import kr.co.digigroove.qrboard_tool.entities.PaymentEntity;
import kr.co.digigroove.qrboard_tool.entities.UserEntity;
import kr.co.digigroove.qrboard_tool.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = {"/user/payment"})
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    /**
     * 결제 목록 페이지
     * @return
     * @throws Exception
     */
    @RequestMapping(method= RequestMethod.GET)
    public String selectPaymentEntityList(final Model model, HttpSession session, PaymentEntity paymentEntity) throws Exception {
        UserEntity userEntity = (UserEntity) session.getAttribute("user");
        paymentEntity.setUserIdx(userEntity.getUserIdx());
        model.addAttribute("paymentEntityList", paymentService.selectPaymentEntityList(paymentEntity));
        model.addAttribute("currentMenu", "payment");
        return "test/payment";
    }

    /**
     * 결제 상세
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/detail", method=RequestMethod.GET)
    public String selectPaymentEntity(final Model model, PaymentEntity paymentEntity) throws Exception {
        model.addAttribute("paymentEntity", paymentService.selectPaymentEntity(paymentEntity));
        model.addAttribute("currentMenu", "payment");
        return "test/payment_detail";
    }

}
