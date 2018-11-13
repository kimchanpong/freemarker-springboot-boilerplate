package com.ckdpharm.homepage.service.main;


import com.ckdpharm.homepage.model.common.ResultListModel;
import com.ckdpharm.homepage.model.common.ResultModel;
import com.ckdpharm.homepage.model.main.MainPO;
import com.ckdpharm.homepage.model.main.MainSO;
import com.ckdpharm.homepage.model.main.MainVO;

import java.util.List;

public interface MainService {
    public ResultListModel<MainVO> selectListModel();
    public List<MainVO> selectList();
    public ResultModel<MainVO> selectVoModel(MainSO so);
    public MainVO selectVo(MainSO so);
    public boolean insertVo(MainPO po);
    public boolean updateVo(MainPO po);
    public boolean deleteVo(MainPO po);
}
