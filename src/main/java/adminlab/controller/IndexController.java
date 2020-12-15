package adminlab.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import adminlab.model.Menu;
import adminlab.service.MenuService;

@Controller
public class IndexController {

    @Autowired
    private MenuService menuService;

    @RequestMapping({ "/", "/index" })
    public String index(HttpServletRequest request) {
        List<Menu> menuList = menuService.getByMap(new HashMap<>());
        request.setAttribute("menuTree", menuTree(menuList));
        return "index";
    }

    private List<Menu> menuTree(List<Menu> menuList) {
        List<Menu> rootMenu = new ArrayList<Menu>();
        Map<Long, Menu> map = new HashMap<Long, Menu>();
        for (Menu menu : menuList) {
            if (menu.getPid() == null) {
                rootMenu.add(menu);
            }
            map.put(menu.getId(), menu);
        }
        for (Menu menu : menuList) {
            Menu pMenu = map.get(menu.getPid());
            if (pMenu != null) {
                if (pMenu.getSubNodeList() == null) {
                    pMenu.setSubNodeList(new ArrayList<Menu>());
                }
                pMenu.getSubNodeList().add(menu);
            }
        }
        return rootMenu;
    }
}