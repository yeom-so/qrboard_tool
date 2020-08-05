package kr.co.digigroove.qrboard_tool.dao;


import kr.co.digigroove.qrboard_tool.entities.ContentEntity;

public interface ContentDAO {
    /**
     * 광고 콘텐츠 등록
     */
    void insertContentEntity(ContentEntity contentEntity) throws Exception;
}
