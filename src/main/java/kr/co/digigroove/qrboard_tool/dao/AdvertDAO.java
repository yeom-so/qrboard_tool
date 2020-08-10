package kr.co.digigroove.qrboard_tool.dao;


import kr.co.digigroove.qrboard_tool.entities.AdvertEntity;

public interface AdvertDAO {
    /**
     * 광고등록
     * @param advertEntity
     */
    void insertAdvertEntity(AdvertEntity advertEntity);
}
