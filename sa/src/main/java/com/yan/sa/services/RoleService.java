package com.yan.sa.services;

import com.yan.sa.entities.Role;
import com.yan.sa.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository repository;

    public boolean create(Role role){
        repository.save(role);
        return  true;
    }
}
