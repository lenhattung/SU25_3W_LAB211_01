package business;

import models.SetMenu;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author tungi
 */
public class SetMenus extends ArrayList<SetMenu> implements Workable<SetMenu> {

    private String pathFile;
    private boolean saved;

    public SetMenus(String pathFile) {
        this.pathFile = pathFile;
    }

    @Override
    public void addNew(SetMenu t) {
    }

    @Override
    public void update(SetMenu t) {
    }

    @Override
    public SetMenu searchById(String s) {
        return null;
    }

    @Override
    public void showAll() {
    }

}
