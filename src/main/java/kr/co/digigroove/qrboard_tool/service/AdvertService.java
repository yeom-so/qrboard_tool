package kr.co.digigroove.qrboard_tool.service;

import kr.co.digigroove.qrboard_tool.entities.AdvertEntity;

public interface AdvertService {
    /**
     * 광고등록
     * @param advertEntity
     */
    void insertAdvertEntity(AdvertEntity advertEntity) throws Exception;
}
