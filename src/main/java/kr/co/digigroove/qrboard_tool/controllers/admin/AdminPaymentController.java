package kr.co.digigroove.qrboard_tool.controllers.admin;

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
@RequestMapping(value = {"/admin/payment"})
public class AdminPaymentController {

    @Autowired
    private PaymentService paymentService;

    /**
     * 광고사업자용 결제 목록 페이지
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/my", method=RequestMethod.GET)
    public String selectMyPaymentEntityList(final Model model, HttpSession session, PaymentEntity paymentEntity) throws Exception {
        UserEntity userEntity = (UserEntity) session.getAttribute("user");
        paymentEntity.setUserIdx(userEntity.getUserIdx());
        model.addAttribute("paymentEntityList", paymentService.selectMyPaymentEntityList(paymentEntity));
        model.addAttribute("totalPayment", paymentService.selectTotalPayment(paymentEntity));
        return "test/payment_my";
    }

}
