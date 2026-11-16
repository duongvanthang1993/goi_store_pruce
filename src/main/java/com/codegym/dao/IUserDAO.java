package com.codegym.dao;

import com.codegym.model.User;
import java.util.List;

public interface IUserDAO {
    public void insertUser(User user) throws Exception;

    public User selectUser(int id);

    public List<User> selectAllUsers();

    public boolean deleteUser(int id) throws Exception;

    public boolean updateUser(User user) throws Exception;

    // Các phương thức gọi Stored Procedures bằng CallableStatement
    public List<User> selectAllUsersSP();

    public boolean updateUserSP(User user) throws Exception;

    public boolean deleteUserSP(int id) throws Exception;
}
