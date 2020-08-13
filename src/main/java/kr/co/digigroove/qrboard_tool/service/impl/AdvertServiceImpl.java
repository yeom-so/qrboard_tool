package kr.co.digigroove.qrboard_tool.service.impl;

import kr.co.digigroove.qrboard_tool.dao.*;
import kr.co.digigroove.qrboard_tool.entities.*;
import kr.co.digigroove.qrboard_tool.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

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

    /**
     * QR보드에 광고중인 광고수
     * @param qrboardEntity
     * @return
     * @throws Exception
     */
    @Override
    public int selectQrboardAdvertCount(QrboardEntity qrboardEntity) throws Exception {
        return advertDAO.selectQrboardAdvertCount(qrboardEntity);
    }

    /**
     * 광고주용 광고목록
     * @param advertEntity
     * @return
     * @throws Exception
     */
    @Override
    public List<AdvertEntity> selectAdvertEntityList(AdvertEntity advertEntity) throws Exception {
        // TODO: 검색조건
        advertEntity.setStartDate("2020-01-01");
        advertEntity.setEndDate("2020-08-31");
        advertEntity.setSearchAdvertState(-1);
        advertEntity.setSearchKey("qrboardName");
        advertEntity.setSearchValue("로비");
        advertEntity.setDataSize(advertDAO.selectAdvertEntityListCount(advertEntity));
        return advertDAO.selectAdvertEntityList(advertEntity);
    }

    @Override
    public AdvertEntity selectAdvertEntity(AdvertEntity advertEntity) throws Exception {
        return advertDAO.selectAdvertEntity(advertEntity);
    }
}
