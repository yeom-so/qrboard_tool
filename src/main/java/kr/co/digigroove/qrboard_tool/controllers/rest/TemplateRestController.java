package kr.co.digigroove.qrboard_tool.controllers.rest;

import kr.co.digigroove.qrboard_tool.constant.Default;
import kr.co.digigroove.qrboard_tool.entities.TemplateEntity;
import kr.co.digigroove.qrboard_tool.entities.TemplateShopEntity;
import kr.co.digigroove.qrboard_tool.entities.result.AngularResultEntity;
import kr.co.digigroove.qrboard_tool.service.TemplateService;
import kr.co.digigroove.qrboard_tool.service.TemplateShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@RequestMapping(value="/templateRest")
public class TemplateRestController implements Serializable{

	private static final Logger LOGGER = LoggerFactory.getLogger(TemplateRestController.class);

	@Autowired
	private TemplateService templateService;

	@RequestMapping(value="/selectTemplateEntityList")
	public AngularResultEntity selectTemplateEntityList(TemplateEntity templateEntity) {
		AngularResultEntity angularResultEntity = new AngularResultEntity();

		try {
			angularResultEntity.setEntityList(templateService.selectTemplateEntityList(templateEntity));
			angularResultEntity.setResult(Default.Result.SUCCESS);
			angularResultEntity.setMessage("성공");
		} catch (Exception e) {
			angularResultEntity.setResult(Default.Result.FAIL);
			angularResultEntity.setMessage("실패");
		}

		return angularResultEntity;
	}

}
