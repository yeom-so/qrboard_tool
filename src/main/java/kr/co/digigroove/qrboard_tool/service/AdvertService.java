package kr.co.digigroove.qrboard_tool.service;

import kr.co.digigroove.qrboard_tool.entities.AdvertEntity;
import kr.co.digigroove.qrboard_tool.entities.QrboardEntity;

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
}
