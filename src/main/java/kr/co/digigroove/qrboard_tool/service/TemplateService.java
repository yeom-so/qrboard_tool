package kr.co.digigroove.qrboard_tool.service;

import kr.co.digigroove.qrboard_tool.entities.TemplateEntity;

import java.util.List;

public interface TemplateService {
    /**
     * 기본템플릿 목록
     * @param templateEntity
     * @return
     * @throws Exception
     */
    List<TemplateEntity> selectTemplateEntityList(TemplateEntity templateEntity) throws Exception;
}
