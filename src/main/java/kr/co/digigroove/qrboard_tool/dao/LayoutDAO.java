package kr.co.digigroove.qrboard_tool.dao;


import kr.co.digigroove.qrboard_tool.entities.LayoutEntity;

import java.util.List;

public interface LayoutDAO {
    /**
     * 레이아웃 목록
     * @return
     * @throws Exception
     */
    List<LayoutEntity> selectLayoutEntityList() throws Exception;

    /**
     * 레이아웃 상세
     */
    LayoutEntity selectLayoutEntity(int layoutIdx) throws Exception;
}
