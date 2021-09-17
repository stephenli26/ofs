package com.stephen.ofs.controller;

import com.stephen.ofs.dao.QueryDao;
import com.stephen.ofs.entity.QueryData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "query")
public class QueryController {

    @Autowired
    QueryDao queryDao;

    @GetMapping(value = "data")
    @ResponseBody
    public Map<String, Object> getData() {
        List<QueryData> list = queryDao.findByCode(1);
        Map<String, Object> data = new HashMap<>();
        data.put("list", list);
        return data;
    }

    @GetMapping(value = "show")
    public String page() {
        return "page";
    }
}
