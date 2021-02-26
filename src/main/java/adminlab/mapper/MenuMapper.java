package adminlab.mapper;

import java.util.List;

import com.github.pagehelper.PageRowBounds;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import adminlab.common.Page;
import adminlab.common.Pageable;
import adminlab.model.Menu;

@Mapper
public interface MenuMapper {

    int save(Menu menu);

    int delete(Long id);

    int update(Menu menu);

    Menu get(Long id);

    List<Menu> list(Menu menu);

    List<Menu> list(Menu menu, RowBounds rowBounds);

    default Page<Menu> page(Pageable<Menu> pageable) {
        Page<Menu> page = new Page<>(pageable.getPageNum(), pageable.getPageSize());
        PageRowBounds pageRowBounds = pageable.getPageRowBounds();
        page.setList(list(pageable.getQuery(), pageRowBounds));
        page.setTotal(pageRowBounds.getTotal());
        return page;
    }

}
