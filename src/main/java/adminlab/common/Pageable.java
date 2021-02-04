package adminlab.common;

import org.apache.ibatis.session.RowBounds;

public class Pageable<T> {

    private int pageNum = 1;
    private int pageSize = 10;
    private T query;

    public Pageable() {
    }

    public Pageable(Integer pageNum, Integer pageSize) {
        this(pageNum, pageSize, null);
    }

    public Pageable(Integer pageNum, Integer pageSize, T query) {
        this.pageNum = pageNum != null ? pageNum : 1;
        this.pageSize = pageSize != null ? pageSize : 10;
        this.query = query;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public T getQuery() {
        return query;
    }

    public void setQuery(T query) {
        this.query = query;
    }

    public RowBounds getRowBounds() {
        return new RowBounds((pageNum - 1) * pageSize, pageSize);
    }

}
