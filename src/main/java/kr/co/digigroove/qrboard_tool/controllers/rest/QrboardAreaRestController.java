package kr.co.digigroove.qrboard_tool.controllers.rest;

import kr.co.digigroove.qrboard_tool.constant.Default;
import kr.co.digigroove.qrboard_tool.entities.QrboardEntity;
import kr.co.digigroove.qrboard_tool.entities.UserEntity;
import kr.co.digigroove.qrboard_tool.entities.result.AngularResultEntity;
import kr.co.digigroove.qrboard_tool.entities.result.ResultEntity;
import kr.co.digigroove.qrboard_tool.service.AdvertService;
import kr.co.digigroove.qrboard_tool.service.QrboardAreaService;
import kr.co.digigroove.qrboard_tool.service.QrboardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.Serializable;

@RestController
@RequestMapping(value="/qrboardAreaRest")
public class QrboardAreaRestController implements Serializable{

	private static final Logger LOGGER = LoggerFactory.getLogger(QrboardAreaRestController.class);

	@Autowired
	private QrboardAreaService qrboardAreaService;

	@RequestMapping(value="/selectQrboardAreaEntityList")
	public AngularResultEntity selectQrboardAreaEntityList(QrboardEntity qrboardEntity) {
		AngularResultEntity angularResultEntity = new AngularResultEntity();

		try {
			angularResultEntity.setEntityList(qrboardAreaService.selectQrboardAreaEntityList(qrboardEntity));
			angularResultEntity.setResult(Default.Result.SUCCESS);
			angularResultEntity.setMessage("성공");
		} catch (Exception e) {
			angularResultEntity.setResult(Default.Result.FAIL);
			angularResultEntity.setMessage("실패");
		}

		return angularResultEntity;
	}

}
