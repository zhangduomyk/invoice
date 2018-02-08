package cn.ccut.invoice.opinion.controller;

import cn.ccut.invoice.opinion.model.OpinionCustom;
import cn.ccut.invoice.opinion.model.PageBean;
import cn.ccut.invoice.opinion.service.impl.OpinionServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/opinion")
public class OpinionController {
    @Resource(name = "opinionServiceImpl")
    private OpinionServiceImpl opinionService;

    /**
     * 分页显示数据
     *
     * @return
     */
    @RequestMapping("/pageRecord")
    public ModelAndView pageRecord(String pageCode, HttpServletRequest request) throws Exception {
        int pageSize = 10;
        int pagecode = 1;

        if (pageCode != null) {
            pagecode = Integer.parseInt(pageCode);
        }

        PageBean pageBean = opinionService.selectAll(pagecode, pageSize);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageBean", pageBean);
        modelAndView.setViewName("/jsps/criticism/opi-list.jsp");

        return modelAndView;
    }

    /**
     * 添加单数据
     *
     * @param
     * @param request
     */
    @RequestMapping("/insertOneRecord")
    public ModelAndView insertOneRecord(OpinionCustom opinionCustom, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            opinionService.insertOneRecord(opinionCustom);
        } catch (Exception e) {
            modelAndView.addObject("msg", "反馈失败！");
            modelAndView.setViewName("/jsps/succes/addopi-succes.jsp");
            return modelAndView;
        }
        modelAndView.addObject("msg", "反馈成功！");
        modelAndView.setViewName("/jsps/succes/addopi-succes.jsp");
        return modelAndView;
    }
}
