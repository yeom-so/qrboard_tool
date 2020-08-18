package kr.co.digigroove.qrboard_tool.service.impl;

import kr.co.digigroove.qrboard_tool.dao.PublicAdvertDAO;
import kr.co.digigroove.qrboard_tool.entities.PublicAdvertEntity;
import kr.co.digigroove.qrboard_tool.service.PublicAdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicAdvertServiceImpl implements PublicAdvertService {

    @Autowired
    private PublicAdvertDAO publicAdvertDAO;

    /**
     * 공용광고 목록
     * @param publicAdvertEntity
     * @return
     * @throws Exception
     */
    @Override
    public List<PublicAdvertEntity> selectPublicAdvertEntityList(PublicAdvertEntity publicAdvertEntity) throws Exception{
        return publicAdvertDAO.selectPublicAdvertEntityList(publicAdvertEntity);
    }

    /**
     * 공용광고 상세
     * @param publicAdvertEntity
     * @return
     * @throws Exception
     */
    @Override
    public PublicAdvertEntity selectPublicAdvertEntity(PublicAdvertEntity publicAdvertEntity) throws Exception {
        return publicAdvertDAO.selectPublicAdvertEntity(publicAdvertEntity);
    }


}
