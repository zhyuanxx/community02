package com.yzh.community.entity;

public class Page {
    //当前页码
    private int current=1;
    //每页行数
    private int limit=10;
    //数据总数，计算总页数
    private int rows;
    //记录路径
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current>=1){
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit>=1&&limit<=100){
            this.limit = limit;
        }

    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if (rows>0){
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    //获取起始行
    public int  getOffset(){
        return limit*(current-1);
    }
    //获得总页数
    public int getTotal(){
        if (rows%limit==0){
            return rows/limit;
        }else {
            return rows/limit+1;
        }
    }
    /**
     * 获得起始页码
     */
    public int getFrom(){
        int from=current-2;
        return from>1?from:1;
    }
    /**
     * 获得结束页码
     */
    public int getTo(){
        int to=current+2;
        int p=getTotal();
        return to<p?to:p;
    }
}
