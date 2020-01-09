package com.oakhit.test.control;

import com.oakhit.test.bean.UserBean;
import com.oakhit.test.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usersql/")
@ResponseBody
public class userSql {
    @Autowired
    private UserMapper userMapper;

    @PostMapping(value = "add")
    public String save(@RequestBody UserBean user) {
//        userMapper.insert(user);
        return "true";
    }

    @PostMapping("getUsers")
    public List<UserBean> getUsers() {
        List<UserBean> users = userMapper.getAll();
        return users;
    }

    @PostMapping("getUser")
    public UserBean getUser(Long id) {
        UserBean user = userMapper.getOne(id);
        return user;
    }


    @PostMapping(value = "update")
    public void update(UserBean user) {
        userMapper.update(user);
    }

    @PostMapping(value = "delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
    }

}
