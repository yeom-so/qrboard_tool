package kr.co.digigroove.qrboard_tool.service.impl;

import kr.co.digigroove.qrboard_tool.dao.*;
import kr.co.digigroove.qrboard_tool.entities.*;
import kr.co.digigroove.qrboard_tool.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertServiceImpl implements AdvertService {

    @Autowired
    private AdvertDAO advertDAO;

    @Autowired
    private LayoutDAO layoutDAO;

    @Autowired
    private TemplateDAO templateDAO;

    @Autowired
    private ContentDAO contentDAO;

    @Autowired
    private ContentTextDAO contentTextDAO;

    @Autowired
    private ContentImageDAO contentImageDAO;

    @Autowired
    private ContentBackgroundDAO contentBackgroundDAO;

    /**
     * 광고영역 생성
     * @param qrboardEntity
     */
    @Override
    public void insertAdvertEntity(QrboardEntity qrboardEntity){

        try {
            // 레이아웃 정보
            LayoutEntity layoutEntity = layoutDAO.selectLayoutEntity(qrboardEntity.getLayoutIdx());
            // 템플릿 정보
            TemplateEntity templateEntity = templateDAO.selectTemplateEntity(qrboardEntity.getTemplateIdx());

            // 레이아웃의 광고영역 개수
            int advertCount = layoutEntity.getLayoutX() * layoutEntity.getLayoutY();
            for(int i=0; i<advertCount; i++){
                // TODO: QR코드 생성
                // 광고 콘텐츠 등록
                ContentEntity contentEntity = new ContentEntity();
                contentDAO.insertContentEntity(contentEntity);

                // 광고 콘텐츠 텍스트 등록
                for(int text=0; text<templateEntity.getTemplateText(); text++){
                    ContentTextEntity contentTextEntity = new ContentTextEntity();
                    contentTextEntity.setContentIdx(contentEntity.getContentIdx());
                    contentTextDAO.insertContentTextEntity(contentTextEntity);
                }

                // 광고 콘텐츠 이미지 등록
                for(int image=0; image<templateEntity.getTemplateImage(); image++){
                    ContentImageEntity contentImageEntity = new ContentImageEntity();
                    contentImageEntity.setContentIdx(contentEntity.getContentIdx());
                    contentImageEntity.setContentImageGroupIdx(0);
                    contentImageDAO.insertContentImageEntity(contentImageEntity);
                }

                // 광고 콘텐츠 배경 등록
                for(int background=0; background<templateEntity.getTemplateBackground(); background++){
                    ContentBackgroundEntity contentBackgroundEntity = new ContentBackgroundEntity();
                    contentBackgroundEntity.setContentIdx(contentEntity.getContentIdx());
                    contentBackgroundDAO.insertContentBackgroundEntity(contentBackgroundEntity);
                }

                // 광고 등록
                AdvertEntity advertEntity = new AdvertEntity();
                advertEntity.setQrboardIdx(qrboardEntity.getQrboardIdx());
                advertEntity.setContentIdx(contentEntity.getContentIdx());
                advertEntity.setAdvertSeq(i);
                advertDAO.insertAdvertEntity(advertEntity);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
