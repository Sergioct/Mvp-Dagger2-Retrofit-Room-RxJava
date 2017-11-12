package com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database.repository;

import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database.entity.User;
import com.sergiocrespotoubes.mvpdagger2retrofitroomrxjava.database.entity.UserDao;

import java.util.List;

import javax.inject.Inject;

public class UserDataSource implements UserRepository {

    private UserDao userDao;

    @Inject
    public UserDataSource(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void updateItems(List items) {

    }

    @Override
    public void intert(User item) {
        userDao.insert(item);
    }

    @Override
    public void insertItems(List<User> items) {

    }

    @Override
    public void updateItem(User item) {
        userDao.update(item);
    }

    @Override
    public void deleteItem(User item) {

    }

    @Override
    public void hasData() {

    }

    @Override
    public User getUser() {
        return null;
    }
}