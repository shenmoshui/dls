package com.tao.dto;

import lombok.Data;

/**
 * @author shentao
 * @date 2020-03-21
 */
@Data
public class LogDTO {

    private Integer pageNum;

    private Integer pageSize;

    private String level;

    private String method;

    private String message;

    private String startTime;

    private String endTime;
}
