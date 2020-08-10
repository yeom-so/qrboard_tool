package kr.co.digigroove.qrboard_tool.service;

import kr.co.digigroove.qrboard_tool.entities.TemplateShopEntity;

import java.util.List;

public interface TemplateShopService {
    /**
     * 업종템플릿 목록
     * @param templateShopEntity
     * @return
     * @throws Exception
     */
    List<TemplateShopEntity> selectTemplateShopEntityList(TemplateShopEntity templateShopEntity) throws Exception;

    /**
     * 업종템플릿 상세
     * @param templateShopEntity
     * @return
     * @throws Exception
     */
    TemplateShopEntity selectTemplateShopEntity(TemplateShopEntity templateShopEntity) throws Exception;
}
