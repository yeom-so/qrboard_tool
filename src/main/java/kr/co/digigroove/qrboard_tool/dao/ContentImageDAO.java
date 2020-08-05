package kr.co.digigroove.qrboard_tool.dao;


import kr.co.digigroove.qrboard_tool.entities.ContentImageEntity;

public interface ContentImageDAO {
    /**
     * 광고 콘텐츠 이미지 등록
     */
    void insertContentImageEntity(ContentImageEntity contentImageEntity) throws Exception;
}
