package com.ckdpharm.homepage.view.main.controller;

import com.ckdpharm.homepage.common.view.ModuleAndView;
import com.ckdpharm.homepage.model.common.ResultListModel;
import com.ckdpharm.homepage.model.common.ResultModel;
import com.ckdpharm.homepage.model.main.MainPO;
import com.ckdpharm.homepage.model.main.MainSO;
import com.ckdpharm.homepage.model.main.MainVO;
import com.ckdpharm.homepage.service.main.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Controller
@RequestMapping({"/", "/m"})
public class MainController {
    @Resource(name = "mainService")
    private MainService mainService;

    @RequestMapping({"/", "/main"})
    public ModelAndView main(ModuleAndView model) {
        model.setTemplate("main/main");
        return model.render();
    }

    @GetMapping("/main")
    public @ResponseBody ResultListModel<MainVO> selectList() {
        List<MainVO> getList = mainService.selectList();
        ResultListModel<MainVO> result = new ResultListModel<>();
        result.setResultList(getList);
        return result;
    }

    @GetMapping("/main/{id}")
    public @ResponseBody ResultModel<MainVO> select(@PathVariable Integer id) {
        MainSO so = new MainSO();
        so.setId(id);
        MainVO vo = mainService.selectVo(so);
        ResultModel<MainVO> result = new ResultModel();
        result.setData(vo);
        return result;
    }

    @PostMapping("/main")
    public @ResponseBody ResultModel<MainPO> insert(MainPO po) {
        ResultModel<MainPO> result = new ResultModel();
        result.setSuccess(mainService.insertVo(po));
        return result;
    }

    @PutMapping("/main/{id}")
    public @ResponseBody ResultModel<MainPO> update(@PathVariable Integer id, MainPO po) {
        ResultModel<MainPO> result = new ResultModel();
        po.setId(id);
        result.setSuccess(mainService.updateVo(po));
        return result;
    }

    @DeleteMapping("/main/{id}")
    public @ResponseBody ResultModel<MainPO> delete(@PathVariable Integer id, MainPO po) {
        ResultModel<MainPO> result = new ResultModel();
        po.setId(id);
        result.setSuccess(mainService.deleteVo(po));
        return result;
    }
}
