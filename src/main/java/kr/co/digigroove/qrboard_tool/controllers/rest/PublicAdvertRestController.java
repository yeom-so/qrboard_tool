package kr.co.digigroove.qrboard_tool.controllers.rest;

import kr.co.digigroove.qrboard_tool.constant.Default;
import kr.co.digigroove.qrboard_tool.entities.PublicAdvertEntity;
import kr.co.digigroove.qrboard_tool.entities.result.AngularResultEntity;
import kr.co.digigroove.qrboard_tool.service.PublicAdvertService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@RequestMapping(value="/publicAdvertRest")
public class PublicAdvertRestController implements Serializable{

	private static final Logger LOGGER = LoggerFactory.getLogger(PublicAdvertRestController.class);

	@Autowired
	private PublicAdvertService publicAdvertService;


	/**
     * 공용광고 상세
	 * @param publicAdvertEntity
     * @return
     */
	@RequestMapping(value="/selectPublicAdvertEntity")
	public AngularResultEntity selectPublicAdvertEntity(PublicAdvertEntity publicAdvertEntity) {
		AngularResultEntity angularResultEntity = new AngularResultEntity();

		try {
			angularResultEntity.setEntity(publicAdvertService.selectPublicAdvertEntity(publicAdvertEntity));
			angularResultEntity.setResult(Default.Result.SUCCESS);
			angularResultEntity.setMessage("성공");
		} catch (Exception e) {
			angularResultEntity.setResult(Default.Result.FAIL);
			angularResultEntity.setMessage("실패");
		}

		return angularResultEntity;
	}



}
