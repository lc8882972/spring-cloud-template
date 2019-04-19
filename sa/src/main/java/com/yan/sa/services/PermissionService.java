package com.yan.sa.services;

import com.yan.sa.dto.SetPermission;
import com.yan.sa.entities.Menu;
import com.yan.sa.entities.Role;
import com.yan.sa.entities.RoleRelationMenu;
import com.yan.sa.repositories.MenuRepository;
import com.yan.sa.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
import java.util.List;
import java.util.Optional;

@Service
public class PermissionService {
    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Transient
    public boolean set(SetPermission permission) {

        Optional<Role> optional = roleRepository.findById(permission.getRoleId());
        Role role = optional.get();
        if (role == null) {
            return false;
        }
//        role.getMenuList().clear();
        List<Menu> menuList = menuRepository.findAllById(permission.getMenuIds());
//        for (Menu item : menuList) {
//            role.getMenuList().add(new RoleRelationMenu(role, item));
//        }

        RoleRelationMenu roleRelationMenu = new RoleRelationMenu();
        roleRelationMenu.setRole(role);
        roleRelationMenu.setMenu(menuList.get(0));
//        role.getMenuList().add(new RoleRelationMenu(role, menuList.get(0)));
        role.getMenuList().add(roleRelationMenu);
        roleRepository.save(role);
        return true;
    }
}
