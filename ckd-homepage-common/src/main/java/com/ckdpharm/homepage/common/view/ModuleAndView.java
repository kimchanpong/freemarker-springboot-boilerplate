package com.ckdpharm.homepage.common.view;

import org.springframework.web.servlet.ModelAndView;

public class ModuleAndView extends ModelAndView {
    /**
     * 레이아웃을 메인 템플릿으로 사용하여 body 속에 템플릿을 include 하는 방식으로 페이지를 완성한다.
     */

    // 템플릿
    private String template = "";

    public ModuleAndView(String template) {
        this.template = template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public ModelAndView render() {
        return this.render(true);
    }

    public ModelAndView render(boolean showLayout) {
        String layout = "layouts/default/layout";
        String body = "/modules/views/" + this.template + ".ftl";

        if (!showLayout) {
            this.setViewName(body);
        } else {
            this.addObject("body", body);
            this.setViewName(layout);
        }
        return this;
    }
}
