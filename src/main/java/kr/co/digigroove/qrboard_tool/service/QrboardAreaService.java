package kr.co.digigroove.qrboard_tool.service;

import kr.co.digigroove.qrboard_tool.entities.QrboardAreaEntity;
import kr.co.digigroove.qrboard_tool.entities.QrboardEntity;

import java.util.List;

public interface QrboardAreaService {
    /**
     * QR보드 광고 영역 생성
     * @param qrboardEntity
     * @throws Exception
     */
    void insertQrboardAreaEntity(QrboardEntity qrboardEntity) throws Exception;

    /**
     * QR보드 광고 영역 목록
     * @param qrboardEntity
     * @return
     * @throws Exception
     */
    List<QrboardAreaEntity> selectQrboardAreaEntityList(QrboardEntity qrboardEntity) throws Exception;
}
