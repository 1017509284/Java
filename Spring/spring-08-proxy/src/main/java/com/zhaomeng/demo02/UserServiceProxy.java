package com.zhaomeng.demo02;

/**
 * @author: zhaomeng
 * @Date: 2022/10/26 20:42
 */
// !使用代理，让每个真正执行的userServiceImpl执行任务之前都加个log语句
public class UserServiceProxy implements UserService{

    private UserServiceImpl userServiceImpl;

    public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    public void add() {
        log("add");
        userServiceImpl.add();
    }

    @Override
    public void delete() {
        log("delete");
        userServiceImpl.delete();
    }

    @Override
    public void update() {
        log("update");
        userServiceImpl.update();
    }

    @Override
    public void query() {
        log("query");
        userServiceImpl.query();
    }

    void log(String msg) {
        System.out.println("调用了" + msg + "方法");
    }
}
