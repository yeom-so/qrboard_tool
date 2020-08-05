package kr.co.digigroove.qrboard_tool.service.impl;

import kr.co.digigroove.qrboard_tool.dao.TemplateShopDAO;
import kr.co.digigroove.qrboard_tool.entities.TemplateShopEntity;
import kr.co.digigroove.qrboard_tool.service.TemplateShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateShopService {

    @Autowired
    private TemplateShopDAO templateShopDAO;

    /**
     * 업종템플릿목록
     * @param templateShopEntity
     * @return
     * @throws Exception
     */
    @Override
    public List<TemplateShopEntity> selectTemplateShopEntityList(TemplateShopEntity templateShopEntity) throws Exception {
        return templateShopDAO.selectTemplateShopEntityList(templateShopEntity);
    }
}
