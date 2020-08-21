package kr.co.digigroove.qrboard_tool.service.impl;

import kr.co.digigroove.qrboard_tool.dao.PaymentDAO;
import kr.co.digigroove.qrboard_tool.entities.PaymentEntity;
import kr.co.digigroove.qrboard_tool.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDAO paymentDAO;

    @Override
    public PaymentEntity selectPaymentEntityList(PaymentEntity paymentEntity) throws Exception {
        // TODO: 검색조건
        paymentEntity.setStartDate("2020-01-01");
        paymentEntity.setEndDate("2020-08-31");
        paymentEntity.setSearchAdvertState(-1);
        paymentEntity.setSearchKey("qrboardName");
        paymentEntity.setSearchValue("로비");
        // 페이징처리
        paymentEntity.setPageParams();
        paymentEntity.setDataSize(paymentDAO.selectPaymentEntityListCount(paymentEntity));
        paymentEntity.setPaymentPageEntityList(paymentDAO.selectPaymentEntityList(paymentEntity));
        return paymentEntity;
    }

    @Override
    public PaymentEntity selectPaymentEntity(PaymentEntity paymentEntity) throws Exception {
        return paymentDAO.selectPaymentEntity(paymentEntity);
    }

    @Override
    public List<PaymentEntity> selectMyPaymentEntityList(PaymentEntity paymentEntity) throws Exception {
        // TODO: 검색조건
        paymentEntity.setStartDate("2020-01-01");
        paymentEntity.setEndDate("2020-08-31");
        paymentEntity.setSearchAdvertState(-1);
        paymentEntity.setSearchKey("qrboardName");
        paymentEntity.setSearchValue("로비");
        paymentEntity.setDataSize(paymentDAO.selectMyPaymentEntityListCount(paymentEntity));
        return paymentDAO.selectMyPaymentEntityList(paymentEntity);
    }

    @Override
    public int selectTotalPayment(PaymentEntity paymentEntity) throws Exception {
        return paymentDAO.selectTotalPayment(paymentEntity);
    }
}
