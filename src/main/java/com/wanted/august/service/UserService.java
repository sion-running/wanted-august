package com.wanted.august.service;

import com.wanted.august.model.User;
import com.wanted.august.model.request.UserJoinRequest;

public interface UserService {
    User join(UserJoinRequest request);
}
