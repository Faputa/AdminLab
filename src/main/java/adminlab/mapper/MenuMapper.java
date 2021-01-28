package adminlab.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import adminlab.common.Page;
import adminlab.common.PageQuery;
import adminlab.model.Menu;

@Mapper
public interface MenuMapper {

    int save(Menu menu);

    int delete(Long id);

    int update(Menu menu);

    Menu get(Long id);

    List<Menu> list(Menu menu);

    List<Menu> list(Menu menu, RowBounds rowBounds);

    int count(Menu menu);

    default Page<Menu> page(PageQuery<Menu> pq) {
        Page<Menu> page = new Page<>(pq.getPageNum(), pq.getPageSize());
        page.setList(list(pq.getQuery(), pq.getRowBounds()));
        page.setTotal(count(pq.getQuery()));
        return page;
    }

}
