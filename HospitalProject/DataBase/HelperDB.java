package HospitalProject.DataBase;

//TODO Implementar HelperDB
public class HelperDB{
    private DataBase db;

    public HelperDB(){
        db = new DataBase();
    }

    /**
     * Criei inicialmente para testar o DB
     */
    public void startDB(){
        db.startDB();
        db.makeAcess();
        db.closeAcess();
    }
}