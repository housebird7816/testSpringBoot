package com.oakhit.test.servers;

import com.google.gson.Gson;
import com.oakhit.test.bean.UserBean;
import com.oakhit.test.tools.RedisClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServers {

    @Autowired
    private RedisClient redisClient;

    public UserBean findUserById(Long id) {
        UserBean userBean = new UserBean();
        userBean.setId(id);
        userBean.setName("test");
        return userBean;
    }

    /**
     * 设置object对象到redis
     */
    public String setUser(UserBean user) throws Exception {
        boolean isExit = redisClient.setObj("USER:ID:" + user.getId(), user);
        return isExit ? "success" : "fail";
    }

    /**
     * 根据key获取Object对象
     */
    public String getUser(Long id) throws Exception {
        return new Gson().toJson(redisClient.getObj("USER:ID:" + id));
    }

    public String setString(String key, String value) throws Exception {
        boolean isExit = redisClient.setString(key, value);
        return isExit ? "success" : "fail";
    }
}
