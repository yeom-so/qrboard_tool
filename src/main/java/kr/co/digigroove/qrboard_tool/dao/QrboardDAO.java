package kr.co.digigroove.qrboard_tool.dao;

import kr.co.digigroove.qrboard_tool.entities.QrboardEntity;

import java.util.List;

public interface QrboardDAO {
    /**
     * QR보드 목록개수조회
     * @param qrboardEntity
     * @return
     * @throws Exception
     */
    int selectQrboardEntityListCount(QrboardEntity qrboardEntity) throws Exception;

    /**
     * QR보드 목록조회
     * @param qrboardEntity
     * @return
     */
    List<QrboardEntity> selectQrboardEntityList(QrboardEntity qrboardEntity);

    /**
     * QR보드등록
     * @param qrboardEntity
     * @throws Exception
     */
    void certifyQrboardEntity(QrboardEntity qrboardEntity) throws Exception;

    /**
     * QR보드상세
     * @param qrboardEntity
     * @return
     * @throws Exception
     */
    QrboardEntity selectQrboardEntity(QrboardEntity qrboardEntity) throws Exception;

    /**
     * QR보드 수정
     * @param qrboardEntity
     * @throws Exception
     */
    void updateQrboardEntity(QrboardEntity qrboardEntity) throws Exception;

    /**
     * QR보드 삭제
     * @param qrboardEntity
     * @throws Exception
     */
    void deleteQrboardEntity(QrboardEntity qrboardEntity) throws Exception;

    /**
     * QR보드 인증번호 유무체크
     * @param qrboardEntity
     * @return
     * @throws Exception
     */
    QrboardEntity selectAuthQrboardEntity(QrboardEntity qrboardEntity) throws Exception;
}
