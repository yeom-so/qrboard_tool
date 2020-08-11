package kr.co.digigroove.qrboard_tool.service.impl;

import kr.co.digigroove.qrboard_tool.dao.LayoutDAO;
import kr.co.digigroove.qrboard_tool.dao.QrboardAreaDAO;
import kr.co.digigroove.qrboard_tool.dao.TemplateDAO;
import kr.co.digigroove.qrboard_tool.entities.*;
import kr.co.digigroove.qrboard_tool.service.QrboardAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QrboardAreaServiceImpl implements QrboardAreaService {

    @Autowired
    private QrboardAreaDAO qrboardAreaDAO;

    @Autowired
    private LayoutDAO layoutDAO;

    @Autowired
    private TemplateDAO templateDAO;

    /**
     * QR보드 광고 영역 생성
     * @param qrboardEntity
     * @throws Exception
     */
    @Override
    public void insertQrboardAreaEntity(QrboardEntity qrboardEntity) throws Exception {

        // 레이아웃 정보
        LayoutEntity layoutEntity = layoutDAO.selectLayoutEntity(qrboardEntity.getLayoutIdx());

        // 레이아웃의 광고영역 개수
        int advertCount = layoutEntity.getLayoutX() * layoutEntity.getLayoutY();
        for(int i=0; i<advertCount; i++){
            // TODO: QR코드 생성
            // QR보드 광고 영역 생성
            QrboardAreaEntity qrboardAreaEntity = new QrboardAreaEntity();
            qrboardAreaEntity.setQrboardIdx(qrboardEntity.getQrboardIdx());
            qrboardAreaEntity.setQrboardAreaSeq(i + 1);     // 영역번호는 1부터 시작
            // TODO: QR코드 이미지 경로
            qrboardAreaEntity.setQrboardAreaCodeImagePath("");
            qrboardAreaDAO.insertQrboardAreaEntity(qrboardAreaEntity);
        }

    }

    /**
     * QR보드 광고 영역 목록 (영역별 등록된 마지막 광고 데이터 포함)
     * @param qrboardEntity
     * @throws Exception
     */
    @Override
    public List<QrboardAreaEntity> selectQrboardAreaEntityList(QrboardEntity qrboardEntity) throws Exception {
        return qrboardAreaDAO.selectQrboardAreaEntityList(qrboardEntity);
    }

    /**
     * QR보드 광고 영역 목록 (영역별 현재 광고 데이터 포함)
     * @param qrboardEntity
     * @return
     * @throws Exception
     */
    @Override
    public List<QrboardAreaEntity> selectQrboardAreaAdvertEntityList(QrboardEntity qrboardEntity) throws Exception {
        return qrboardAreaDAO.selectQrboardAreaAdvertEntityList(qrboardEntity);
    }
}
