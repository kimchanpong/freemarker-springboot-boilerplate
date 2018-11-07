package com.ckdpharm.homepage.common.view;

import com.ckdpharm.homepage.common.util.HttpUtil;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public class ModuleAndView extends ModelAndView {
    /**
     * 레이아웃을 메인 템플릿으로 사용하여 body 속에 템플릿을 include 하는 방식으로 페이지를 완성한다.
     */

    // 템플릿
    private String template;

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
        HttpServletRequest request = HttpUtil.getHttpServletRequest();
        String devicePath = request.getRequestURI().startsWith("/m/") ? "mobile" : "pc";

        /**
            freemarker는 include가 삽입되는 파일의 디렉토리 경로를 기본으로 두고있다.
            예를들어 footer.ftl을 layout.ftl에 include할때 layouts디렉토리가 자동으로 잡히기때문에
            layouts이후이 디렉토리명부터 기술한다
         */
        String style = "include/style.ftl";
        String footer = "include/footer.ftl";
        String script = "include/script.ftl";
        String layout = devicePath + "/layouts/layout";
        String body = "/" + devicePath + "/modules/views/" + this.template + ".ftl";

        if (!showLayout) {
            this.setViewName(body);
        } else {
            this.addObject("style", style);
            this.addObject("body", body);
            this.addObject("footer", footer);
            this.addObject("script", script);
            this.setViewName(layout);
        }
        return this;
    }
}
