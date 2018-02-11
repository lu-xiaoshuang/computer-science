/*
 *  Copyright (C) 2018 Xiaoshuang LU
 *  All rights reserved.
 */

package root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyController.class);

    @RequestMapping("/test/{id}")
    @ResponseBody
    public String test(HttpServletRequest httpServletRequest, @PathVariable String id) {
        return "test";
    }
}
