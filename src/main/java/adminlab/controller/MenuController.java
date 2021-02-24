package adminlab.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import adminlab.common.Page;
import adminlab.common.Pageable;
import adminlab.model.Menu;
import adminlab.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/page")
    public Page<Menu> page(Integer pageNo, Integer pageSize) {
        return menuService.page(new Pageable<>(pageNo, pageSize));
    }

    @RequestMapping("/tree")
    public List<Menu> tree(HttpServletRequest request) {
        List<Menu> menuList = menuService.list(null);
        return toTree(menuList);
    }

    private List<Menu> toTree(List<Menu> menuList) {
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
