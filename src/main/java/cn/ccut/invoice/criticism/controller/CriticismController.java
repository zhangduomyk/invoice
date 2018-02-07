package cn.ccut.invoice.criticism.controller;

import cn.ccut.invoice.criticism.model.CriticismCustom;
import cn.ccut.invoice.criticism.model.PageBean;
import cn.ccut.invoice.criticism.service.impl.CriticismServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/criticism")
public class CriticismController {
    @Resource(name = "criticismServiceImpl")
    private CriticismServiceImpl criticismService;

    /**
     * 删除单条记录
     *
     * @return
     */
    @RequestMapping(value = "/deleteOneRecord", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String deleteOneRecord(Integer cid) {

        try {
            criticismService.deleteOneRecord(cid);
        } catch (Exception e) {
            return "删除失败！";
        }

        return "删除成功！";
    }

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

        PageBean pageBean = criticismService.selectAll(pagecode, pageSize);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageBean", pageBean);
        modelAndView.setViewName("/jsps/criticism/cri-list.jsp");

        return modelAndView;
    }

    /**
     * 添加单数据
     *
     * @param
     * @param request
     */
    @RequestMapping("/insertOneRecord")
    public String insertOneRecord(CriticismCustom criticismCustom, HttpServletRequest request) {
        try {
            criticismService.insertOneRecord(criticismCustom);
        } catch (Exception e) {
            return "添加失败！";
        }
        return "添加成功";
    }
}
