package HospitalProject;

import HospitalProject.DataBase.*;

public class Runner {
    public static void main(String[] args) {
        HelperDB db = new HelperDB();
        db.startDB();
    }
}