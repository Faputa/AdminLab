package io.github.fpure.adminlab.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.fpure.adminlab.mapper.MenuMapper;
import io.github.fpure.adminlab.model.Menu;

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

    public Menu getById(Long id) {
        return menuMapper.getById(id);
    }

    public List<Menu> getByMap(Map<String, Object> map) {
        return menuMapper.getByMap(map);
    }
}