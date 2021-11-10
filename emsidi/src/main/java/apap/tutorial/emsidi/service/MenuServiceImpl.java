package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.MenuModel;
import apap.tutorial.emsidi.repository.MenuDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{
    @Autowired
    MenuDB menuDB;

    @Override
    public List<MenuModel> getListMenu() {
        return menuDB.findAll();
    }

    @Override
    public void addMenu(MenuModel menu){
        menuDB.save(menu);
    }
}