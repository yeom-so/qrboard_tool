package kr.co.digigroove.qrboard_tool.dao;


import kr.co.digigroove.qrboard_tool.entities.ContentTextEntity;

public interface ContentTextDAO {
    /**
     * 광고 콘텐츠 텍스트 등록
     */
    void insertContentTextEntity(ContentTextEntity contentTextEntity) throws Exception;
}
