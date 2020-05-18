package io.github.fpure.admin.mapper;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import io.github.fpure.admin.model.Menu;

public class MenuMapperTest {
    
    @Autowired
    private MenuMapper menuMapper;

    @Test
    void getById() {
        menuMapper.getById(0L);
    }

    @Test
    void getByMap() {
        menuMapper.getByMap(new HashMap<>());
    }

    @Test
    void save() {
        menuMapper.save(new Menu());
    }

    @Test
    void delete() {
        menuMapper.delete(0L);
    }
}