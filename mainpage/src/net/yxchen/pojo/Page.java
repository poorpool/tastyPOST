package net.yxchen.pojo;

import java.util.List;

public class Page<T> {
    public static final Integer PAGE_SIZE = 10;
    private Integer pageTotal;//总页码
    private Integer pageNo;//当前页码。一定要在 pageTotal 之后设置
    private Integer pageSize = PAGE_SIZE;//一页显示多少个
    private Integer pageTotalCount;//总记录数
    private List<T> items;//分页的数据
    private String url;//请求分页条的 servlet 的 url

    public Page() {
    }

    public Page(Integer pageTotal, Integer pageNo, Integer pageSize, Integer pageTotalCount, List<T> items, String url) {
        this.pageTotal = pageTotal;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.pageTotalCount = pageTotalCount;
        this.items = items;
        this.url = url;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    /**
     * 设置当前页码。为了避免越界，必须在设置了 pageTotal 以后才能调用
     * @param pageNo 当前页码
     */
    public void setPageNo(Integer pageNo) {
        if (pageNo < 1) {
            this.pageNo = 1;
        } else if (pageNo > pageTotal) {
            this.pageNo = pageTotal;
        } else {
            this.pageNo = pageNo;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageTotal=" + pageTotal +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", pageTotalCount=" + pageTotalCount +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}
