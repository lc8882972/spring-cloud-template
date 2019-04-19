package com.yan.sa.services;

import com.yan.sa.dto.CreateUser;
import com.yan.sa.entities.Role;
import com.yan.sa.entities.User;
import com.yan.sa.entities.UserRelationRole;
import com.yan.sa.repositories.RoleRepository;
import com.yan.sa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public boolean create(CreateUser dto) {
        User entity = new User();
        Role role = roleRepository.getOne(dto.getRoleId());
        UserRelationRole userRelationRole = new UserRelationRole();
        userRelationRole.setRole(role);
        userRelationRole.setUser(entity);
        Set<UserRelationRole> roleList = new HashSet<>();
        roleList.add(userRelationRole );
        entity.setRoleList(roleList);
        entity.setName(dto.getName());
        entity.setEnabled(dto.isEnabled());
        entity.setCreateTime(new Date());
        userRepository.save(entity);
        return true;
    }
}
