package com.ckdpharm.homepage.service.main;


import com.ckdpharm.homepage.model.main.MainPO;
import com.ckdpharm.homepage.model.main.MainSO;
import com.ckdpharm.homepage.model.main.MainVO;

import java.util.List;

public interface MainService {
    public List<MainVO> selectList();
    public MainVO selectVo(MainSO so);
    public boolean insertVo(MainPO po);
    public boolean updateVo(MainPO po);
    public boolean deleteVo(MainPO po);
}
