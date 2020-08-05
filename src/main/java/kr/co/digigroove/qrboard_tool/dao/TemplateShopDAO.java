package kr.co.digigroove.qrboard_tool.dao;


import kr.co.digigroove.qrboard_tool.entities.TemplateShopEntity;

import java.util.List;

public interface TemplateShopDAO {
    /**
     * 업종템플릿 목록
     * @param templateShopEntity
     * @return
     * @throws Exception
     */
    List<TemplateShopEntity> selectTemplateShopEntityList(TemplateShopEntity templateShopEntity) throws Exception;
}
