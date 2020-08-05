package kr.co.digigroove.qrboard_tool.dao;


import kr.co.digigroove.qrboard_tool.entities.PermitNumEntity;
import kr.co.digigroove.qrboard_tool.entities.QrboardEntity;

public interface PermitNumDAO {
    /**
     * 허가번호 유무체크
     * @param permitNumEntity
     * @return
     * @throws Exception
     */
    PermitNumEntity selectPermitNumEntity(PermitNumEntity permitNumEntity) throws Exception;

    /**
     * 허가번호 인증처리
     * @param permitNumEntity
     * @throws Exception
     */
    void authPermitNumEntity(PermitNumEntity permitNumEntity) throws Exception;

    /**
     * 허가번호 인증해제
     * @param qrboardEntity
     * @throws Exception
     */
    void unauthPermitNumEntity(QrboardEntity qrboardEntity) throws Exception;
}
