package kr.co.digigroove.qrboard_tool.service;

import kr.co.digigroove.qrboard_tool.entities.PaymentEntity;

import java.util.List;

public interface PaymentService {

    /**
     * 광고주용 결제목록
     * @param paymentEntity
     * @return
     * @throws Exception
     */
    List<PaymentEntity> selectPaymentEntityList(PaymentEntity paymentEntity) throws Exception;

    /**
     * 결제 상세
     * @param paymentEntity
     * @return
     * @throws Exception
     */
    PaymentEntity selectPaymentEntity(PaymentEntity paymentEntity) throws Exception;

    /**
     * 광고주용 결제목록
     * @param paymentEntity
     * @return
     * @throws Exception
     */
    List<PaymentEntity> selectMyPaymentEntityList(PaymentEntity paymentEntity) throws Exception;

    /**
     * 광고사업자용 QR보드에 등록된 총 수익
     * @param paymentEntity
     * @return
     * @throws Exception
     */
    int selectTotalPayment(PaymentEntity paymentEntity) throws Exception;

}
