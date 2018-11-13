package com.ckdpharm.homepage.service.main;

import com.ckdpharm.homepage.common.util.MessageUtil;
import com.ckdpharm.homepage.dao.main.MainDao;
import com.ckdpharm.homepage.model.common.ResultListModel;
import com.ckdpharm.homepage.model.common.ResultModel;
import com.ckdpharm.homepage.model.main.MainPO;
import com.ckdpharm.homepage.model.main.MainSO;
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
    public ResultListModel<MainVO> selectListModel() {
        ResultListModel<MainVO> result = new ResultListModel<MainVO>();
        List<MainVO> selectList = this.selectList();
        result.setResultList(selectList);
        result.setSuccess(selectList == null ? false : true);
        result.setMessage(MessageUtil.getMessage("common.processed"));
        return result;
    }

    @Override
    public List<MainVO> selectList() {
        return mainDao.selectList();
    }

    @Override
    public ResultModel<MainVO> selectVoModel(MainSO so) {
        ResultModel<MainVO> result = new ResultModel<MainVO>();
        MainVO selectVo = this.selectVo(so);
        result.setData(selectVo);
        result.setSuccess(selectVo == null ? false : true);
        result.setMessage(MessageUtil.getMessage("common.processed"));
        return result;
    }

    @Override
    public MainVO selectVo(MainSO so) {
        return mainDao.selectVo(so);
    }

    @Override
    public boolean insertVo(MainPO po) {
        return mainDao.insertVo(po) > 0;
    }

    @Override
    public boolean updateVo(MainPO po) {
        return mainDao.updateVo(po) > 0;
    }

    @Override
    public boolean deleteVo(MainPO po) {
        return mainDao.deleteVo(po) > 0;
    }
}
