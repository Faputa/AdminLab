package adminlab.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import adminlab.common.Page;
import adminlab.common.Pageable;
import adminlab.model.Menu;
import adminlab.service.MenuService;
import adminlab.util.WebUtil;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/page")
    public String page(Integer pageNo, Integer pageSize) {
        HttpServletRequest request = WebUtil.getRequest();
        Page<Menu> page = menuService.page(new Pageable<>(pageNo, pageSize));
        request.setAttribute("pageModel", page);
        return "/menu/page";
    }

}
