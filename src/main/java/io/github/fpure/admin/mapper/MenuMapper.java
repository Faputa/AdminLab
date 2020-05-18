package io.github.fpure.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import io.github.fpure.admin.model.Menu;

@Mapper
public interface MenuMapper {

    Long save(Menu menu);

    int delete(Long id);

    int update(Menu menu);

    Menu getById(Long id);

    List<Menu> getByMap(Map<String, Object> map);
}