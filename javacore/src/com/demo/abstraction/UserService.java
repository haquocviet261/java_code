package com.demo.abstraction;

public interface UserService {

    boolean create(User user);

    boolean update(User user);

    boolean delete(User user);

    boolean sendEmail(User sender, User receiver);
}
