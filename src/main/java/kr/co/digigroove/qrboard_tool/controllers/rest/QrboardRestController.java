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
@RequestMapping(value="/qrboardRest")
public class QrboardRestController implements Serializable{

	private static final Logger LOGGER = LoggerFactory.getLogger(QrboardRestController.class);

	@Autowired
	private QrboardService qrboardService;

	@Autowired
	private QrboardAreaService qrboardAreaService;

	@Autowired
	private AdvertService advertService;

	/**
	 * QR보드 등록
	 * @param qrboardEntity
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/certifyQrboardEntity", method= RequestMethod.POST)
	public AngularResultEntity certifyQrboardEntity(QrboardEntity qrboardEntity, HttpSession session) throws Exception{
		AngularResultEntity angularResultEntity = new AngularResultEntity();

		try {
			UserEntity userEntity = (UserEntity) session.getAttribute("user");
			qrboardEntity.setUserIdx(userEntity.getUserIdx());
			QrboardEntity authQrboardEntity = qrboardService.certifyQrboardEntity(qrboardEntity);
			// 인증성공
			if(authQrboardEntity.getResult().equals(Default.Result.SUCCESS)){
				// 광고영역 생성
				qrboardAreaService.insertQrboardAreaEntity(qrboardService.selectQrboardEntity(authQrboardEntity));
				angularResultEntity.setResult(Default.Result.SUCCESS);
				angularResultEntity.setMessage("QR보드 등록 성공");
			}else if(authQrboardEntity.getResult().equals(Default.Result.FAIL)){
				angularResultEntity.setResult(Default.Result.FAIL);
				if(authQrboardEntity.getSubResult().equals(Default.Result.AUTH_NUM_ERR)){
					angularResultEntity.setMessage("올바른 인증번호를 입력하세요.");
				}else if(authQrboardEntity.getSubResult().equals(Default.Result.PERMIT_NUM_ERR)){
					angularResultEntity.setMessage("올바른 허가번호를 입력하세요.");
				}else if(authQrboardEntity.getSubResult().equals(Default.Result.PERMIT_NUM_MISMATCH)){
					angularResultEntity.setMessage("올바른 허가번호를 입력하세요.");
				}else if(authQrboardEntity.getSubResult().equals(Default.Result.USE_PERMIT_NUM)){
					angularResultEntity.setMessage("이미 등록된 허가번호입니다.");
				}else if(authQrboardEntity.getSubResult().equals(Default.Result.USE_AUTH_NUM)){
					angularResultEntity.setMessage("이미 등록된 인증번호입니다.");
				}
			}
		} catch (Exception e) {
			angularResultEntity.setResult(Default.Result.FAIL);
			angularResultEntity.setMessage("오류가 발생하였습니다.");
		}

		return angularResultEntity;
	}

	/**
	 * QR보드 상세
	 * @param qrboardEntity
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/selectQrboardEntity", method= RequestMethod.POST)
	public AngularResultEntity selectQrboardEntity(QrboardEntity qrboardEntity) throws Exception{
		AngularResultEntity angularResultEntity = new AngularResultEntity();

		try {
			angularResultEntity.setEntity(qrboardService.selectQrboardEntity(qrboardEntity));
			angularResultEntity.setResult(Default.Result.SUCCESS);
			angularResultEntity.setMessage("성공");
		} catch (Exception e) {
			angularResultEntity.setResult(Default.Result.FAIL);
			angularResultEntity.setMessage("실패");
		}

		return angularResultEntity;
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
