package kr.co.digigroove.qrboard_tool.dao;


import kr.co.digigroove.qrboard_tool.entities.QrboardAreaEntity;
import kr.co.digigroove.qrboard_tool.entities.QrboardEntity;

import java.util.List;

public interface QrboardAreaDAO {
    /**
     * QR보드 영역 등록
     * @param qrboardAreaEntity
     * @throws Exception
     */
    void insertQrboardAreaEntity(QrboardAreaEntity qrboardAreaEntity) throws Exception;

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

}
