package com.akakour.lab.json.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/json")
public class JsonController {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private class Books {
        private String name;
        private String description;
        private String author;
        private Integer pageNo;
        private Integer version;
    }


    /**
     * [
     *     {
     *         "author": "绿野山人",
     *         "description": "如何傍上富婆，走上人生巅峰",
     *         "name": "如何傍上富婆",
     *         "pageNo": 120,
     *         "version": 1
     *     },
     *     {
     *         "author": "叶凡",
     *         "description": "",
     *         "name": "遮天",
     *         "pageNo": 1200,
     *         "version": 1
     *     }
     * ]
     * @return
     */
    @RequestMapping("/getAllBookList")
    public List<Books> getAllList() {
        List<Books> ret = new ArrayList<>();
        ret.add(new Books("如何傍上富婆", "如何傍上富婆，走上人生巅峰", "绿野山人", 120, 1));
        ret.add(new Books("遮天", null, "叶凡", 1200, 1));
        return ret;
    }

    /**
     * {
     *     null: {
     *         "author": "",
     *         "description": "",
     *         "name": "圣牧",
     *         "pageNo": 0,
     *         "version": 1
     *     },
     *     "1": {
     *         "author": "绿野山人",
     *         "description": "如何傍上富婆，走上人生巅峰",
     *         "name": "如何傍上富婆",
     *         "pageNo": 120,
     *         "version": 1
     *     },
     *     "2": {
     *         "author": "叶凡",
     *         "description": "",
     *         "name": "遮天",
     *         "pageNo": 1200,
     *         "version": 1
     *     },
     *     "4": null
     * }
     * @return
     */
    @PostMapping("/getAllBookMap")
    public Map<String, Books> getAllMap() {
        Map<String, Books> ret = new HashMap<>();
        ret.put("1", new Books("如何傍上富婆", "如何傍上富婆，走上人生巅峰", "绿野山人", 120, 1));
        ret.put("2", new Books("遮天", null, "叶凡", 1200, 1));
        ret.put(null, new Books("圣牧", "", "", null, 1));
        ret.put("4", null);
        return ret;
    }

    /**
     * {
     *     "author": "叶凡",
     *     "description": "",
     *     "name": "遮天",
     *     "pageNo": 1200,
     *     "version": 1
     * }
     * @return
     */
    @PostMapping("/getOneBook")
    public Books getOne() {
        return new Books("遮天", null, "叶凡", 1200, 1);
    }

    /**
     * {}
     * @return
     */
    @PostMapping("/getEmptyMap")
    public  Map<String, Books> getEnptyMap() {
        return new HashMap<>();
    }
}
