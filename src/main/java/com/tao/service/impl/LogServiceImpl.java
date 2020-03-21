package com.tao.service.impl;

import com.tao.dto.LogDTO;
import com.tao.entity.LogEntity;
import com.tao.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @author shentao
 * @date 2020-03-21
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<LogEntity> listLog(LogDTO logDTO) {
        Query query = new Query();
        Criteria criteria = new Criteria();

        //等级用精确查询
        if(!StringUtils.isEmpty(logDTO.getLevel())){
            criteria.and("level").is(logDTO.getLevel());
        }
        //方法用模糊查询
        if(!StringUtils.isEmpty(logDTO.getMethod())){
            Pattern method = Pattern.compile("^.*" + logDTO.getMethod() + ".*$", Pattern.CASE_INSENSITIVE);
            criteria.and("logger").regex(method);
        }
        if(!StringUtils.isEmpty(logDTO.getMessage())) {
            //信息用模糊查询
            Pattern message = Pattern.compile("^.*" + logDTO.getMessage() + ".*$", Pattern.CASE_INSENSITIVE);
            criteria.and("message").regex(message);
        }
        //开始结束时间
        if(!StringUtils.isEmpty(logDTO.getStartTime()) && !StringUtils.isEmpty(logDTO.getEndTime())){
            criteria.andOperator(Criteria.where("timestamp").gte(logDTO.getStartTime()), Criteria.where("timestamp").lte(logDTO.getEndTime()));
        }

        return mongoTemplate.find(query.addCriteria(criteria).skip(logDTO.getPageNum()).limit(logDTO.getPageSize()), LogEntity.class, "log_fms");
    }

}
