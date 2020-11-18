package cn.itcast.travel.service;

import cn.itcast.travel.domain.User;

import java.util.List;

public interface UserService {
    /**
     * 注册用户
     * @param user
     * @return
     */
    boolean regist(User user);

    boolean active(String code);

    User login(User user);

    User findUser(int uid);

    boolean updateUser(User user);

    List<User> findAllUser();
}
