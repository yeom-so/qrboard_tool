package kr.co.digigroove.qrboard_tool.service.impl;

import kr.co.digigroove.qrboard_tool.constant.Default;
import kr.co.digigroove.qrboard_tool.dao.PermitNumDAO;
import kr.co.digigroove.qrboard_tool.dao.QrboardDAO;
import kr.co.digigroove.qrboard_tool.entities.PermitNumEntity;
import kr.co.digigroove.qrboard_tool.entities.QrboardEntity;
import kr.co.digigroove.qrboard_tool.entities.result.ResultEntity;
import kr.co.digigroove.qrboard_tool.service.QrboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QrboardServiceImpl implements QrboardService {

    @Autowired
    private QrboardDAO qrboardDAO;

    @Autowired
    private PermitNumDAO permitNumDAO;

    /**
     * QR보드목록
     * @param qrboardEntity
     * @return
     * @throws Exception
     */
    @Override
    public List<QrboardEntity> selectQrboardEntityList(QrboardEntity qrboardEntity) throws Exception{
        qrboardEntity.setPageParams();
        qrboardEntity.setDataSize(qrboardDAO.selectQrboardEntityListCount(qrboardEntity));
        return qrboardDAO.selectQrboardEntityList(qrboardEntity);
    }

    /**
     * QR보드등록
     * @param qrboardEntity
     * @throws Exception
     */
    @Override
    public ResultEntity certifyQrboardEntity(QrboardEntity qrboardEntity) throws Exception{
        ResultEntity resultEntity = new ResultEntity();

        QrboardEntity authQrboardEntity = qrboardDAO.selectAuthQrboardEntity(qrboardEntity);
        PermitNumEntity permitNumEntity = new PermitNumEntity();
        permitNumEntity.setUserIdx(qrboardEntity.getUserIdx());
        permitNumEntity.setPermitNum(qrboardEntity.getQrboardPermitNum());
        PermitNumEntity authPermitNumEntity = permitNumDAO.selectPermitNumEntity(permitNumEntity);

        if (authQrboardEntity == null) {	// 해당 인증번호를 가진 QR보드가 존재하지 않은 경우
            resultEntity.setCode(Default.Result.AUTH_NUM_ERR);
        } else if(authPermitNumEntity == null) { // 허가번호가 존재하지 않은 경우
            resultEntity.setCode(Default.Result.PERMIT_NUM_ERR);
        }else{	// QR보드 존재, 허가번호 존재

            // 이미 등록된 QR보드
            if(authQrboardEntity.getQrboardAuthYn().equals("Y")){
                resultEntity.setCode(Default.Result.USE_AUTH_NUM);
            }

            if(authQrboardEntity.getQrboardPermitNum() == null || authQrboardEntity.getQrboardPermitNum().equals("")){	// 등록했던 허가번호가 없음
                if(authPermitNumEntity.getQrboardIdx() == 0){	// 허가번호로 등록했던 QR보드가 없음
                    // 허가번호 인증처리
                    permitNumEntity.setQrboardIdx(authQrboardEntity.getQrboardIdx());
                    permitNumEntity.setPermitNumIdx(authPermitNumEntity.getPermitNumIdx());
                    permitNumDAO.authPermitNumEntity(permitNumEntity);
                    // QR보드 인증
                    qrboardDAO.certifyQrboardEntity(qrboardEntity);
                    resultEntity.setCode(Default.Result.SUCCESS);
                }else{ // 허가번호로 등록했던 기기가 있음
                    if(authQrboardEntity.getQrboardIdx() == authPermitNumEntity.getQrboardIdx()){	// 이전에 등록한 QR보드
                        // 허가번호 인증처리
                        permitNumEntity.setQrboardIdx(authQrboardEntity.getQrboardIdx());
                        permitNumEntity.setPermitNumIdx(authPermitNumEntity.getPermitNumIdx());
                        permitNumDAO.authPermitNumEntity(permitNumEntity);
                        // QR보드 인증
                        qrboardDAO.certifyQrboardEntity(qrboardEntity);
                        resultEntity.setCode(Default.Result.SUCCESS);
                    }else{	// 다른 QR보드가 등록한 허가번호
                        resultEntity.setCode(Default.Result.USE_PERMIT_NUM);
                    }
                }
            }else{	// 기기에 등록했던 허가번호가 존재함
                if(qrboardEntity.getQrboardPermitNum().equals(authQrboardEntity.getQrboardPermitNum())) {	// 이전에 등록한 허가번호와 일치함
                    // 허가번호 인증처리
                    permitNumEntity.setQrboardIdx(authQrboardEntity.getQrboardIdx());
                    permitNumEntity.setPermitNumIdx(authPermitNumEntity.getPermitNumIdx());
                    permitNumDAO.authPermitNumEntity(permitNumEntity);
                    // QR보드 인증
                    qrboardDAO.certifyQrboardEntity(qrboardEntity);
                    resultEntity.setCode(Default.Result.SUCCESS);
                }else{	// 이미 다른 허가번호로 등록된 QR보드
                    resultEntity.setCode(Default.Result.PERMIT_NUM_MISMATCH);
                }
            }
        }

        return resultEntity;
    }

    @Override
    public QrboardEntity selectQrboardEntity(QrboardEntity qrboardEntity) throws Exception {
        return qrboardDAO.selectQrboardEntity(qrboardEntity);
    }

    /**
     * QR보드수정
     * @param qrboardEntity
     * @throws Exception
     */
    @Override
    public void updateQrboardEntity(QrboardEntity qrboardEntity){
        try {
            qrboardDAO.updateQrboardEntity(qrboardEntity);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteQrboardEntity(QrboardEntity qrboardEntity) throws Exception {
        // TODO : 진행중인 광고 유무확인
        // TODO: 허가번호 UPDATE
        qrboardDAO.deleteQrboardEntity(qrboardEntity);
    }

}