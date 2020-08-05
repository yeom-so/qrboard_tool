package kr.co.digigroove.qrboard_tool.dao;


import kr.co.digigroove.qrboard_tool.entities.ContentBackgroundEntity;

public interface ContentBackgroundDAO {
    /**
     * 광고 콘텐츠 배경화면 등록
     */
    void insertContentBackgroundEntity(ContentBackgroundEntity contentBackgroundEntity) throws Exception;
}
