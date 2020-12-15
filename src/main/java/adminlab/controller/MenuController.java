package adminlab.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import adminlab.service.MenuService;
import adminlab.util.WebUtil;
import adminlab.model.Menu;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/page")
    public String page(Integer pageNo, Integer pageSize) {
        HttpServletRequest request = WebUtil.getRequest();
        if (pageNo == null) {pageNo = 1;}
        if (pageSize == null) {pageSize = 20;}
        PageHelper.startPage(pageNo, pageSize);
        List<Menu> page = menuService.getByMap(new HashMap<>());
        PageInfo<Menu> pageModel = new PageInfo<>(page);
        request.setAttribute("pageModel", pageModel);
        return "/menu/page";
    }

}
