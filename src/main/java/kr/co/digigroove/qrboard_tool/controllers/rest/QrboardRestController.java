package kr.co.digigroove.qrboard_tool.controllers.rest;

import kr.co.digigroove.qrboard_tool.constant.Default;
import kr.co.digigroove.qrboard_tool.entities.QrboardEntity;
import kr.co.digigroove.qrboard_tool.entities.UserEntity;
import kr.co.digigroove.qrboard_tool.entities.result.ResultEntity;
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
@RequestMapping(value="/qrboardRest")
public class QrboardRestController implements Serializable{

	private static final Logger LOGGER = LoggerFactory.getLogger(QrboardRestController.class);

	@Autowired
	private QrboardService qrboardService;

	/**
	 * QR보드 등록
	 * @param qrboardEntity
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/certifyQrboardEntity", method= RequestMethod.POST)
	public ResultEntity certifyQrboardEntity(QrboardEntity qrboardEntity, HttpSession session) throws Exception{
		ResultEntity resultEntity = new ResultEntity();

		try {
			UserEntity userEntity = (UserEntity) session.getAttribute("user");
			qrboardEntity.setUserIdx(userEntity.getUserIdx());
			qrboardService.certifyQrboardEntity(qrboardEntity);
			resultEntity.setCode(Default.Result.SUCCESS);
			resultEntity.setMessage("QR보드 등록 완료");
		} catch (Exception e) {
			resultEntity.setCode(Default.Result.FAIL);
			resultEntity.setMessage("오류가 발생하였습니다.");
		}

		return resultEntity;
	}

	/**
	 * QR보드 수정
	 * @param qrboardEntity
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateQrboardEntity", method= RequestMethod.POST)
	public ResultEntity updateQrboardEntity(QrboardEntity qrboardEntity) throws Exception{
		ResultEntity resultEntity = new ResultEntity();

		try {
			qrboardService.updateQrboardEntity(qrboardEntity);
			resultEntity.setCode(Default.Result.SUCCESS);
			resultEntity.setMessage("QR보드 수정 완료");
		} catch (Exception e) {
			resultEntity.setCode(Default.Result.FAIL);
			resultEntity.setMessage("오류가 발생하였습니다.");
		}

		return resultEntity;
	}

	/**
	 * QR보드 삭제
	 * @param qrboardEntity
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteQrboardEntity", method= RequestMethod.POST)
	public ResultEntity deleteQrboardEntity(QrboardEntity qrboardEntity) throws Exception{
		ResultEntity resultEntity = new ResultEntity();

		try {
			qrboardService.deleteQrboardEntity(qrboardEntity);
			resultEntity.setCode(Default.Result.SUCCESS);
			resultEntity.setMessage("QR보드 삭제 완료");
		} catch (Exception e) {
			resultEntity.setCode(Default.Result.FAIL);
			resultEntity.setMessage("오류가 발생하였습니다.");
		}

		return resultEntity;
	}

}
