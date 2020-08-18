package kr.co.digigroove.qrboard_tool.service;

import kr.co.digigroove.qrboard_tool.entities.PublicAdvertEntity;

import java.util.List;

public interface PublicAdvertService {
    /**
     * 공용광고 목록
     * @param publicAdvertEntity
     * @return
     * @throws Exception
     */
    List<PublicAdvertEntity> selectPublicAdvertEntityList(PublicAdvertEntity publicAdvertEntity) throws Exception;

    /**
     * 공용광고 상세
     * @param publicAdvertEntity
     * @return
     * @throws Exception
     */
    PublicAdvertEntity selectPublicAdvertEntity(PublicAdvertEntity publicAdvertEntity) throws Exception;
}
