package kr.co.digigroove.qrboard_tool.service.impl;

import kr.co.digigroove.qrboard_tool.dao.TemplateDAO;
import kr.co.digigroove.qrboard_tool.entities.TemplateEntity;
import kr.co.digigroove.qrboard_tool.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateDAO templateDAO;

    /**
     * 기본템플릿목록
     * @return
     * @throws Exception
     */
    @Override
    public List<TemplateEntity> selectTemplateEntityList(TemplateEntity templateEntity) throws Exception {
        return templateDAO.selectTemplateEntityList(templateEntity);
    }

}
