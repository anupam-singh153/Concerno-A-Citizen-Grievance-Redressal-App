package com.concerno.service.interfac;

import com.concerno.dto.LoginRequest;
import com.concerno.dto.Response;
import com.concerno.entity.User;

public interface IUserService {

    Response register(User user);

    Response login(LoginRequest loginRequest);

    Response getAllUsers();

    Response deleteUser(Long userId);

    Response getUserById(Long userId);

    Response getMyInfo(String email);
}
