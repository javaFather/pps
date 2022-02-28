package com.wzx.pro.common.util;

import com.google.common.collect.Lists;
import com.wzx.pro.common.enums.ResponseEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 请求返回结果
 *
 * @author
 */
@Data
@ApiModel("返回结果对象")
public class Result<T extends Serializable> implements Serializable {
    private static final long serialVersionUID = -8508268287523566997L;

    /**
     * 通讯结果
     */
    private boolean success = true;
    /**
     * 消息
     */
    @ApiModelProperty("错误消息信息")
    private String message;
    /**
     * 数据
     */
    @ApiModelProperty("数据对象")
    private T data;
    @ApiModelProperty("数据结果集合")
    private List<T> dataList = Lists.newArrayList();
    @ApiModelProperty("状态码")
    private String code;
    @ApiModelProperty("数据总记录数")
    private Long totalCount = 0L;
    /**
     * 构造函数
     */
    public Result() {

    }

    public Result(String code) {
        this.code = code;
    }

    public Result(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(String code, T data) {
        this.code = code;
        this.data = data;
    }

    public Result(String code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public static Result success(){
        Result result = new Result(ResponseEnum.SYS_SUCCESS.getCode(), ResponseEnum.SYS_SUCCESS.getDesc());
        result.setSuccess(true);
        return result;
    }

    public static <T extends Serializable> Result success(T data){
        Result result = new Result(ResponseEnum.SYS_SUCCESS.getCode(), ResponseEnum.SYS_SUCCESS.getDesc());
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public static Result failure(String code, String message){
        Result result = new Result(code, message);
        result.setSuccess(false);
        return result;
    }

    public static Result middle(String code, String message){
        Result result = new Result(code, message);
        result.setSuccess(false);
        return result;
    }

    /**
     * 添加返回数据列表
     * @param data
     */
    public void addDataList(T data){
        this.dataList.add(data);
    }

    /**
     * 添加返回数据列表
     * @param dataList
     */
    public void addDataList(List<T> dataList){
        this.dataList.addAll(dataList);
    }

}
