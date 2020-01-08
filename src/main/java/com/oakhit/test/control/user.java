package com.oakhit.test.control;


import com.oakhit.test.bean.UserBean;
import com.oakhit.test.servers.UserServers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user/")
@RestController
public class user {

    @Autowired
    private UserServers userServers;

    @PostMapping("findUserById")
    public UserBean findUserById(Long id) {
        return userServers.findUserById(id);
    }

    /**
     * 设置object对象到redis
     */
    @PostMapping("setUser")
    public String setUser(@RequestBody UserBean user) throws Exception {
        return userServers.setUser(user);
    }

    /**
     * 根据key获取Object对象
     */
    @PostMapping("getUser")
    public String getUser(Long id) throws Exception {
        return userServers.getUser(id);
    }

    @PostMapping("setString")
    public String setString(String key, String value) throws Exception {
        return userServers.setString(key, value);
    }
}
