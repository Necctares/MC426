package HospitalProject;

import HospitalProject.DataBase.*;
import HospitalProject.GUI.*;


public class Runner {
    public static void main(String[] args) {
        HelperDB.getDB().startDB();
        MenuInicial menu = new MenuInicial();
        menu.startMenu();
    }
}