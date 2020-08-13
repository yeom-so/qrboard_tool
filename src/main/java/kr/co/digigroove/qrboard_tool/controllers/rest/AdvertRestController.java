package kr.co.digigroove.qrboard_tool.controllers.rest;

import kr.co.digigroove.qrboard_tool.constant.Default;
import kr.co.digigroove.qrboard_tool.entities.AdvertEntity;
import kr.co.digigroove.qrboard_tool.entities.UserEntity;
import kr.co.digigroove.qrboard_tool.entities.result.AngularResultEntity;
import kr.co.digigroove.qrboard_tool.service.AdvertService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.Serializable;

@RestController
@RequestMapping(value="/advertRest")
public class AdvertRestController implements Serializable{

	private static final Logger LOGGER = LoggerFactory.getLogger(AdvertRestController.class);

	@Autowired
	private AdvertService advertService;

	/**
	 * 광고 등록
	 * @param advertEntity
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertAdvertEntity", method= RequestMethod.POST)
	public AngularResultEntity insertAdvertEntity(@RequestBody AdvertEntity advertEntity, HttpSession session) throws Exception{
		AngularResultEntity angularResultEntity = new AngularResultEntity();

		try {
			UserEntity userEntity = (UserEntity) session.getAttribute("user");
			advertEntity.setUserIdx(userEntity.getUserIdx());
			advertService.insertAdvertEntity(advertEntity);
			angularResultEntity.setResult(Default.Result.SUCCESS);
			angularResultEntity.setMessage("광고 등록 성공");
		} catch (Exception e) {
			angularResultEntity.setResult(Default.Result.FAIL);
			angularResultEntity.setMessage("오류가 발생하였습니다.");
		}

		return angularResultEntity;
	}

	/**
	 * 광고 승인여부 설정
	 * @param advertEntity
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateAdvertState", method= RequestMethod.POST)
	public AngularResultEntity updateAdvertState( AdvertEntity advertEntity) throws Exception{
		AngularResultEntity angularResultEntity = new AngularResultEntity();

		try {
			advertService.updateAdvertState(advertEntity);
			angularResultEntity.setResult(Default.Result.SUCCESS);
			angularResultEntity.setMessage("광고 승인여부 설정 완료");
		} catch (Exception e) {
			angularResultEntity.setResult(Default.Result.FAIL);
			angularResultEntity.setMessage("오류가 발생하였습니다.");
		}

		return angularResultEntity;
	}


}
