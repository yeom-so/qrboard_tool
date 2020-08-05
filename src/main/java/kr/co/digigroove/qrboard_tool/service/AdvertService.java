package kr.co.digigroove.qrboard_tool.service;

import kr.co.digigroove.qrboard_tool.entities.QrboardEntity;

public interface AdvertService {
    /**
     * 광고영역 생성
     * @param qrboardEntity
     */
    void insertAdvertEntity(QrboardEntity qrboardEntity) throws Exception;
}
