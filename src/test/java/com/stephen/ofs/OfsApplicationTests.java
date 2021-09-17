package com.stephen.ofs;

import com.stephen.ofs.dao.QueryDao;
import com.stephen.ofs.entity.QueryData;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class OfsApplicationTests {

    @Autowired
    QueryDao queryDao;

    @Test
    void contextLoads() {
        List<QueryData> queryDataList = queryDao.findByCode(1);
        log.info("data: {}", queryDataList);
    }

}
