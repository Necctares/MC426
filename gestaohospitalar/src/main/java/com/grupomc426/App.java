package com.grupomc426;

import com.grupomc426.DataBase.*;
import com.grupomc426.GUI.*;


public class App {
    public static void main(String[] args) {
        HelperDB.getDB().startDB();
        MenuInicial menu = new MenuInicial();
        menu.startMenu();
    }
}
