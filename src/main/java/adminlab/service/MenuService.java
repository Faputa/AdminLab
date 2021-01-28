package adminlab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import adminlab.common.Page;
import adminlab.common.PageQuery;
import adminlab.mapper.MenuMapper;
import adminlab.model.Menu;

@Service
public class MenuService {
    
    @Autowired
    private MenuMapper menuMapper;

    public int save(Menu menu) {
        return menuMapper.save(menu);
    }

    public int delete(Long id) {
        return menuMapper.delete(id);
    }

    public int update(Menu menu) {
        return menuMapper.update(menu);
    }

    public Menu get(Long id) {
        return menuMapper.get(id);
    }

    public List<Menu> list(Menu menu) {
        return menuMapper.list(menu);
    }

    public Page<Menu> page(PageQuery<Menu> pq) {
        return menuMapper.page(pq);
    }

}
