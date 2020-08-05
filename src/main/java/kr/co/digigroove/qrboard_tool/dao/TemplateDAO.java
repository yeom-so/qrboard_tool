package kr.co.digigroove.qrboard_tool.dao;

import kr.co.digigroove.qrboard_tool.entities.TemplateEntity;

import java.util.List;

public interface TemplateDAO {
    /**
     * 기본템플릿목록
     * @param templateEntity
     * @return
     * @throws Exception
     */
    List<TemplateEntity> selectTemplateEntityList(TemplateEntity templateEntity) throws Exception;

    /**
     * 기본템플릿상세
     * @param templateIdx
     * @return
     * @throws Exception
     */
    TemplateEntity selectTemplateEntity(int templateIdx) throws Exception;
}
