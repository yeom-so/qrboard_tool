package kr.co.digigroove.qrboard_tool.service.impl;

import kr.co.digigroove.qrboard_tool.dao.*;
import kr.co.digigroove.qrboard_tool.entities.*;
import kr.co.digigroove.qrboard_tool.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class AdvertServiceImpl implements AdvertService {

    @Autowired
    private AdvertDAO advertDAO;

    @Autowired
    private ContentDAO contentDAO;

    @Autowired
    private ContentTextDAO contentTextDAO;

    @Autowired
    private ContentImageDAO contentImageDAO;

    @Autowired
    private ContentBackgroundDAO contentBackgroundDAO;

    /**
     * 광고 등록
     * @param advertEntity
     */
    @Override
    public void insertAdvertEntity(AdvertEntity advertEntity) {
        try {

            // 광고 콘텐츠 등록
            ContentEntity contentEntity = new ContentEntity();
            contentDAO.insertContentEntity(contentEntity);

            // 광고 콘텐츠 텍스트 등록
            for(ContentTextEntity contentTextEntity : advertEntity.getContentTextEntityList()){
                contentTextEntity.setContentIdx(contentEntity.getContentIdx());
                contentTextDAO.insertContentTextEntity(contentTextEntity);
            }

            // 광고 콘텐츠 이미지 등록
            int contentImageGroupIdx = 0;
            for(ContentImageEntity contentImageEntity : advertEntity.getContentImageEntityList()){
                contentImageEntity.setContentIdx(contentEntity.getContentIdx());
                if(contentImageEntity.getContentImageGroupIdx() == 0){
                    // bundle
                    contentImageDAO.insertContentImageEntity(contentImageEntity);
                    contentImageGroupIdx = contentImageEntity.getContentImageIdx();
                }else{
                    // slide
                    contentImageEntity.setContentImageGroupIdx(contentImageGroupIdx);
                    contentImageDAO.insertContentImageEntity(contentImageEntity);
                }
            }

            // 광고 콘텐츠 배경 등록
            for(ContentBackgroundEntity contentBackgroundEntity : advertEntity.getContentBackgroundEntityList()){
                contentBackgroundEntity.setContentIdx(contentEntity.getContentIdx());
                contentBackgroundDAO.insertContentBackgroundEntity(contentBackgroundEntity);
            }

            // 광고 등록
            advertEntity.setContentIdx(contentEntity.getContentIdx());
            advertDAO.insertAdvertEntity(advertEntity);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int selectQrboardAdvertCount(QrboardEntity qrboardEntity) throws Exception {
        return advertDAO.selectQrboardAdvertCount(qrboardEntity);
    }
}
