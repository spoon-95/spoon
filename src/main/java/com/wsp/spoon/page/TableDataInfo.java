package com.wsp.spoon.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 表格分页数据对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableDataInfo implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 总记录数 */
    private long count;

    /** 列表数据 */
    private List<?> data;

    /** 消息状态码 */
    private int code;

    /** 消息内容 */
    private String msg;


    /**
     * 分页
     * 
     * @param list 列表数据
     * @param count 总记录数
     */
    public TableDataInfo(List<?> list, int count)
    {
        this.data = list;
        this.count = count;
    }

}