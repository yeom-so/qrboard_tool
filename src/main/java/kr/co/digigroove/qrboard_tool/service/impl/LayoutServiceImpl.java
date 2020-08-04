package kr.co.digigroove.qrboard_tool.service.impl;

import kr.co.digigroove.qrboard_tool.dao.LayoutDAO;
import kr.co.digigroove.qrboard_tool.entities.LayoutEntity;
import kr.co.digigroove.qrboard_tool.service.LayoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LayoutServiceImpl implements LayoutService {

    @Autowired
    private LayoutDAO layoutDAO;

    /**
     * 레이아웃목록
     * @return
     * @throws Exception
     */
    @Override
    public List<LayoutEntity> selectLayoutEntityList() throws Exception {
        return layoutDAO.selectLayoutEntityList();
    }
}
