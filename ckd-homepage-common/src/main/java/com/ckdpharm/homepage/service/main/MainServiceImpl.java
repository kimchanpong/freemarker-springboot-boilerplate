package com.ckdpharm.homepage.service.main;

import com.ckdpharm.homepage.dao.main.MainDao;
import com.ckdpharm.homepage.model.main.MainVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service("mainService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class MainServiceImpl implements MainService {
    @Autowired
    private MainDao mainDao;

    @Override
    public List<MainVO> selectMain() {
        return mainDao.selectMain();
    }
}
