package com.oakhit.test.bean;

import com.oakhit.test.enums.UserSexEnum;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserBean extends BaseBean {
    private String name;
    private Long id;
    private static final long serialVersionUID = 1L;
    private String userName;
    private String passWord;
    private UserSexEnum userSex;
    private String nickName;

    public UserBean() {
        super();
    }

    public UserBean(String userName, String passWord, UserSexEnum userSex) {
        super();
        this.passWord = passWord;
        this.userName = userName;
        this.userSex = userSex;
    }
}
