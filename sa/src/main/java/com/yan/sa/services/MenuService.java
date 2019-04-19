package com.yan.sa.services;

import com.yan.sa.entities.Menu;
import com.yan.sa.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuRepository repository;

    public boolean create(Menu menu){
        repository.save(menu);
        return  true;
    }

    public List<Menu> list(){
        List<Menu> list = repository.findAll();
        return  list;
    }
}
