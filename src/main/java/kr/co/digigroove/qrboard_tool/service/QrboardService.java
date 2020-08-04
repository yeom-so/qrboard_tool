package kr.co.digigroove.qrboard_tool.service;

import kr.co.digigroove.qrboard_tool.entities.QrboardEntity;
import kr.co.digigroove.qrboard_tool.entities.result.ResultEntity;

import java.util.List;

public interface QrboardService {
    /**
     * QR보드목록
     * @param qrboardEntity
     * @return
     * @throws Exception
     */
    List<QrboardEntity> selectQrboardEntityList(QrboardEntity qrboardEntity) throws Exception;

    /**
     * QR보드등록
     * @param qrboardEntity
     * @throws Exception
     */
    ResultEntity certifyQrboardEntity(QrboardEntity qrboardEntity) throws Exception;

    /**
     * QR보드상세
     * @param qrboardEntity
     * @return
     * @throws Exception
     */
    QrboardEntity selectQrboardEntity(QrboardEntity qrboardEntity) throws Exception;

    /**
     * QR보드수정
     * @param qrboardEntity
     * @throws Exception
     */
    void updateQrboardEntity(QrboardEntity qrboardEntity) throws Exception;

    /**
     * QR보드삭제
     * @param qrboardEntity
     * @throws Exception
     */
    void deleteQrboardEntity(QrboardEntity qrboardEntity) throws Exception;
}
