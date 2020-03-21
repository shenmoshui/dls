package com.tao;

import com.tao.dto.LogDTO;
import com.tao.entity.LogEntity;
import com.tao.service.LogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DlsApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private LogService logService;

    @Test
    public void listLog(){
        LogDTO logDTO = new LogDTO();
        logDTO.setPageNum(0);
        logDTO.setPageSize(10);
        logDTO.setLevel("DEBUG");
        logDTO.setMethod("listMenu");
        logDTO.setMessage("TOTAL");
        logDTO.setStartTime("2020-01-15 16:52:59");
        logDTO.setEndTime("2020-01-15 16:52:59");

        List<LogEntity> log_fms = logService.listLog(logDTO);
        System.out.println(log_fms);
    }

}
