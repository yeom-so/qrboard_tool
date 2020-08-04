package kr.co.digigroove.qrboard_tool.service;

import kr.co.digigroove.qrboard_tool.entities.LayoutEntity;

import java.util.List;

public interface LayoutService {
    /**
     * 레이아웃 목록
     * @return
     * @throws Exception
     */
    List<LayoutEntity> selectLayoutEntityList() throws Exception;
}
