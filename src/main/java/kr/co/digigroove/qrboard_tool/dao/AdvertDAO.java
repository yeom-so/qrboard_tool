package kr.co.digigroove.qrboard_tool.dao;


import kr.co.digigroove.qrboard_tool.entities.AdvertEntity;
import kr.co.digigroove.qrboard_tool.entities.QrboardEntity;

public interface AdvertDAO {
    /**
     * 광고등록
     * @param advertEntity
     */
    void insertAdvertEntity(AdvertEntity advertEntity);

    /**
     * QR보드에 광고중인 광고수
     * @param qrboardEntity
     * @return
     */
    int selectQrboardAdvertCount(QrboardEntity qrboardEntity);
}
