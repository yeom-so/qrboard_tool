package kr.co.digigroove.qrboard_tool.controllers.rest;

import kr.co.digigroove.qrboard_tool.constant.Default;
import kr.co.digigroove.qrboard_tool.entities.QrboardEntity;
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
@RequestMapping(value="/templateShopRest")
public class TemplateShopRestController implements Serializable{

	private static final Logger LOGGER = LoggerFactory.getLogger(TemplateShopRestController.class);

	@Autowired
	private TemplateShopService templateShopService;


	@RequestMapping(value="/selectTemplateShopEntityList")
	public AngularResultEntity selectTemplateShopEntityList(TemplateShopEntity templateShopEntity) {
		AngularResultEntity angularResultEntity = new AngularResultEntity();

		try {
			angularResultEntity.setEntityList(templateShopService.selectTemplateShopEntityList(templateShopEntity));
			angularResultEntity.setResult(Default.Result.SUCCESS);
			angularResultEntity.setMessage("성공");
		} catch (Exception e) {
			angularResultEntity.setResult(Default.Result.FAIL);
			angularResultEntity.setMessage("실패");
		}

		return angularResultEntity;
	}

	@RequestMapping(value="/selectTemplateShopEntity")
	public AngularResultEntity selectTemplateShopEntity(TemplateShopEntity templateShopEntity) {
		AngularResultEntity angularResultEntity = new AngularResultEntity();

		try {
			angularResultEntity.setEntity(templateShopService.selectTemplateShopEntity(templateShopEntity));
			angularResultEntity.setResult(Default.Result.SUCCESS);
			angularResultEntity.setMessage("성공");
		} catch (Exception e) {
			angularResultEntity.setResult(Default.Result.FAIL);
			angularResultEntity.setMessage("실패");
		}

		return angularResultEntity;
	}



}
