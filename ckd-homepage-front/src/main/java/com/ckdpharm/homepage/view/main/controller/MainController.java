package com.ckdpharm.homepage.view.main.controller;

import com.ckdpharm.homepage.common.view.ModuleAndView;
import com.ckdpharm.homepage.model.main.MainVO;
import com.ckdpharm.homepage.service.main.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Controller
public class MainController {
    @Resource(name = "mainService")
    private MainService mainService;

    @GetMapping(value = "/main")
    public ModelAndView main(ModuleAndView model) {
        model.setTemplate("main/main");
        model.addObject("list", mainService.selectList());
        return model.render();
    }
}
