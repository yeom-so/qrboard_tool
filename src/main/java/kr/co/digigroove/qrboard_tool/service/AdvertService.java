package kr.co.digigroove.qrboard_tool.service;

import kr.co.digigroove.qrboard_tool.entities.AdvertEntity;
import kr.co.digigroove.qrboard_tool.entities.QrboardEntity;

import java.util.List;

public interface AdvertService {
    /**
     * 광고등록
     * @param advertEntity
     */
    void insertAdvertEntity(AdvertEntity advertEntity) throws Exception;

    /**
     * QR보드에 광고중인 광고수
     * @param qrboardEntity
     * @return
     * @throws Exception
     */
    int selectQrboardAdvertCount(QrboardEntity qrboardEntity) throws Exception;

    /**
     * 광고주용 광고목록
     * @param advertEntity
     * @return
     * @throws Exception
     */
    List<AdvertEntity> selectAdvertEntityList(AdvertEntity advertEntity) throws Exception;

    /**
     * 광고 상세
     * @param advertEntity
     * @return
     * @throws Exception
     */
    AdvertEntity selectAdvertEntity(AdvertEntity advertEntity) throws Exception;

    /**
     * 광고사업자용 QR보드에 등록된 광고 목록
     * @param advertEntity
     * @return
     * @throws Exception
     */
    List<AdvertEntity> selectAdvertApproveEntityList(AdvertEntity advertEntity) throws Exception;

    /**
     * 광고 승인여부 설정
     * @param advertEntity
     * @throws Exception
     */
    void updateAdvertState(AdvertEntity advertEntity) throws Exception;
}
