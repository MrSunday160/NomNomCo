package database;

import model.Confectionary;

import java.util.ArrayList;

public class Database{

    public static Database instance;

    private ArrayList<Confectionary> confectionaries = new ArrayList<>();

    private Database(){}

    public static Database getInstance(){

        if(instance == null)
            instance =  new Database();

        return instance;

    }

    public ArrayList<Confectionary> getConfectionaries(){

        return confectionaries;

    }

    public void addConfectionary(Confectionary confectionary){

        confectionaries.add(confectionary);
        confectionary.getPayment().pay();
        confectionary.bake();

    }

}
