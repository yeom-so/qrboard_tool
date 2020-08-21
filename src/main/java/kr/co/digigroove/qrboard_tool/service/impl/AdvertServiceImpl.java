package kr.co.digigroove.qrboard_tool.service.impl;

import kr.co.digigroove.qrboard_tool.dao.*;
import kr.co.digigroove.qrboard_tool.entities.*;
import kr.co.digigroove.qrboard_tool.service.AdvertService;
import kr.co.digigroove.qrboard_tool.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class AdvertServiceImpl implements AdvertService {

    @Autowired
    private AdvertDAO advertDAO;

    @Autowired
    private ContentDAO contentDAO;

    @Autowired
    private ContentTextDAO contentTextDAO;

    @Autowired
    private ContentImageDAO contentImageDAO;

    @Autowired
    private ContentBackgroundDAO contentBackgroundDAO;

    @Autowired
    private PaymentDAO paymentDAO;

    /**
     * 광고 등록
     * @param advertEntity
     */
    @Override
    public void insertAdvertEntity(AdvertEntity advertEntity) {
        try {

            // 광고 콘텐츠 등록
            ContentEntity contentEntity = new ContentEntity();
            contentDAO.insertContentEntity(contentEntity);

            // 광고 콘텐츠 텍스트 등록
            for(ContentTextEntity contentTextEntity : advertEntity.getContentTextEntityList()){
                contentTextEntity.setContentIdx(contentEntity.getContentIdx());
                contentTextDAO.insertContentTextEntity(contentTextEntity);
            }

            // 광고 콘텐츠 이미지 등록
            int contentImageGroupIdx = 0;
            for(ContentImageEntity contentImageEntity : advertEntity.getContentImageEntityList()){
                contentImageEntity.setContentIdx(contentEntity.getContentIdx());
                if(contentImageEntity.getContentImageGroupIdx() == 0){
                    // bundle
                    contentImageDAO.insertContentImageEntity(contentImageEntity);
                    contentImageGroupIdx = contentImageEntity.getContentImageIdx();
                }else{
                    // slide
                    contentImageEntity.setContentImageGroupIdx(contentImageGroupIdx);
                    contentImageDAO.insertContentImageEntity(contentImageEntity);
                }
            }

            // 광고 콘텐츠 배경 등록
            for(ContentBackgroundEntity contentBackgroundEntity : advertEntity.getContentBackgroundEntityList()){
                contentBackgroundEntity.setContentIdx(contentEntity.getContentIdx());
                contentBackgroundDAO.insertContentBackgroundEntity(contentBackgroundEntity);
            }

            // 광고 등록
            advertEntity.setContentIdx(contentEntity.getContentIdx());
            advertDAO.insertAdvertEntity(advertEntity);

            // 결제 등록
            PaymentEntity paymentEntity = advertEntity.getPaymentEntity();
            paymentEntity.setAdvertIdx(advertEntity.getAdvertIdx());
            paymentEntity.setUserIdx(advertEntity.getUserIdx());
            paymentDAO.insertPaymentEntity(paymentEntity);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * QR보드에 광고중인 광고수
     * @param qrboardEntity
     * @return
     * @throws Exception
     */
    @Override
    public int selectQrboardAdvertCount(QrboardEntity qrboardEntity) throws Exception {
        return advertDAO.selectQrboardAdvertCount(qrboardEntity);
    }

    /**
     * 광고주용 광고목록
     * @param advertEntity
     * @return
     * @throws Exception
     */
    @Override
    public AdvertEntity selectAdvertEntityList(AdvertEntity advertEntity) throws Exception {
        // TODO: 검색조건
        advertEntity.setStartDate("2020-01-01");
        advertEntity.setEndDate("2020-08-31");
        advertEntity.setSearchAdvertState(-1);
        advertEntity.setSearchKey("qrboardName");
        advertEntity.setSearchValue("로비");
        // 페이징처리
        advertEntity.setPageParams();
        advertEntity.setDataSize(advertDAO.selectAdvertEntityListCount(advertEntity));
        advertEntity.setAdvertPageEntityList(advertDAO.selectAdvertEntityList(advertEntity));
        return advertEntity;
    }

    /**
     * 광고 상세
     * @param advertEntity
     * @return
     * @throws Exception
     */
    @Override
    public AdvertEntity selectAdvertEntity(AdvertEntity advertEntity) throws Exception {
        return advertDAO.selectAdvertEntity(advertEntity);
    }

    /**
     * 광고사업자용 QR보드에 등록된 광고 목록
     * @param advertEntity
     * @return
     * @throws Exception
     */
    @Override
    public List<AdvertEntity> selectAdvertApproveEntityList(AdvertEntity advertEntity) throws Exception {
        // TODO: 검색조건
        advertEntity.setStartDate("2020-01-01");
        advertEntity.setEndDate("2020-08-31");
        advertEntity.setSearchAdvertState(-1);
        advertEntity.setSearchKey("qrboardName");
        advertEntity.setSearchValue("로비");
        advertEntity.setDataSize(advertDAO.selectAdvertApproveEntityListCount(advertEntity));
        return advertDAO.selectAdvertApproveEntityList(advertEntity);
    }

    /**
     * 광고 승인여부 설정
     * @param advertEntity
     * @throws Exception
     */
    @Override
    public void updateAdvertState(AdvertEntity advertEntity) throws Exception {
        // TODO: 문자
        // TODO: PUSH
        // 결제취소
        if(advertEntity.getAdvertState() == 1){
            String token = PaymentUtils.getImportToken();
            PaymentEntity paymentEntity = new PaymentEntity();
            paymentEntity.setAdvertIdx(advertEntity.getAdvertIdx());
            paymentEntity = paymentDAO.selectPaymentEntity(paymentEntity);
            int res = PaymentUtils.cancelPayment(token, paymentEntity.getImpUid(), paymentEntity.getMerchantUid());
            if(res > 0){
                // 결제취소 성공
                paymentEntity.setPaymentStatus("cancelled");
                paymentDAO.updatePaymentEntity(paymentEntity);
                advertDAO.updateAdvertState(advertEntity);
            }
        }else{
            advertDAO.updateAdvertState(advertEntity);
        }
    }
}
