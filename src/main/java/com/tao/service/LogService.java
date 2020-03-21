package com.tao.service;

import com.tao.dto.LogDTO;
import com.tao.entity.LogEntity;

import java.util.List;

/**
 * @author shentao
 * @date 2020-03-21
 */
public interface LogService {

    List<LogEntity> listLog(LogDTO logDTO);

}
