package cn.tongyl.febs.common.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author create by Tunyl on 2021/9/5
 * @version 1.0
 */
@Data
@ToString
public class QueryRequest {
    private static final long serialVersionUID = -4423343L;
    /**
     * 当前页面的数量
     */
    private int pageSize = 10;
    /**
     * 当前页码
     */
    private int pageNum = 1;
    /**
     * 排序字段
     */
    private String field;
    /**
     * 排序规则,asc升序，desc降序
     */
    private String order;
}
