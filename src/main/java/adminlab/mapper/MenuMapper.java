package adminlab.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import adminlab.model.Menu;

@Mapper
public interface MenuMapper {

    int save(Menu menu);

    int delete(Long id);

    int update(Menu menu);

    Menu getById(Long id);

    List<Menu> getByMap(Map<String, Object> map);
}
