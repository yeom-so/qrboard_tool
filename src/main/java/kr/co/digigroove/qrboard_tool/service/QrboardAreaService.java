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
     * QR보드 광고 영역 목록 (영역별 등록된 마지막 광고 데이터 포함)
     * @param qrboardEntity
     * @return
     * @throws Exception
     */
    List<QrboardAreaEntity> selectQrboardAreaEntityList(QrboardEntity qrboardEntity) throws Exception;

    /**
     * QR보드 광고 영역 목록 (영역별 현재 광고 데이터 포함)
     * @param qrboardEntity
     * @return
     * @throws Exception
     */
    List<QrboardAreaEntity> selectQrboardAreaAdvertEntityList(QrboardEntity qrboardEntity) throws Exception;

    /**
     * QR보드 광고판 상세
     * @param qrboardAreaEntity
     * @return
     * @throws Exception
     */
    QrboardAreaEntity selectQrboardAreaEntity(QrboardAreaEntity qrboardAreaEntity) throws Exception;
}
