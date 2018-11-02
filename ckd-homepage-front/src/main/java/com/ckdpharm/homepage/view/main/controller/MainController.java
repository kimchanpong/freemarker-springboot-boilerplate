package com.ckdpharm.homepage.view.main.controller;

import com.ckdpharm.homepage.common.view.ModuleAndView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class MainController {

    @GetMapping(value = "/main")
    public ModelAndView main(ModuleAndView model) {
        model.setTemplate("main/main");
        return model.render();
    }
}
