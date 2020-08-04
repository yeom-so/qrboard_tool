package kr.co.digigroove.qrboard_tool.dao;


import kr.co.digigroove.qrboard_tool.entities.LayoutEntity;

import java.util.List;

public interface LayoutDAO {
    List<LayoutEntity> selectLayoutEntityList() throws Exception;
}
