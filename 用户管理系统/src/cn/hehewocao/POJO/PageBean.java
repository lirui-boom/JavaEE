package cn.hehewocao.POJO;

import java.util.List;

public class PageBean<T> {
    private int page;   //当前页数
    private int row;    //  分页条数
    private List<T> list;   //查询的每页记录
    private int count;  //总记录数
    private int pages;   //展示数据的总页数

    public PageBean() {
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "page=" + page +
                ", row=" + row +
                ", list=" + list +
                ", count=" + count +
                ", pages=" + pages +
                '}';
    }
}
