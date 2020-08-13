package kr.co.digigroove.qrboard_tool.dao;


import kr.co.digigroove.qrboard_tool.entities.AdvertEntity;
import kr.co.digigroove.qrboard_tool.entities.QrboardEntity;

import java.util.List;

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

    /**
     * 광고주용 광고목록 개수
     * @param advertEntity
     * @return
     * @throws Exception
     */
    int selectAdvertEntityListCount(AdvertEntity advertEntity) throws Exception;

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
}
