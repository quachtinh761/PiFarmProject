package controllers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import models.VaccineModel;
import objects.VaccineObject;

/**
 * Created by Van Thi on 1/1/2017.
 */


public class VaccineController extends AppCompatActivity {
    VaccineModel vaccineModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView();

        vaccineModel = new VaccineModel(this);


    }

    protected void addVacine(String ID, String name, String indication, String dose, String insertedBy, Date insertedDate){
        vaccineModel.add(new VaccineObject(ID, name, indication, dose, insertedBy, "" , insertedDate, null, false));
    }
    protected void removeVaccine(String ID){
        vaccineModel.remove(ID);
    }
    public List<String> getID(String value, int by){
        List<VaccineObject> ls = vaccineModel.search(value, by);
        List<String> temp = new LinkedList<>();
        for (VaccineObject var : ls){
            temp.add(var.getID());
        }
        return temp;
    }
    public List<VaccineObject> getAll(){
        return vaccineModel.searchAll();
    }
    public void updateVaccine(String ID, String name, String indication, String dose, String updatedBy, Date updatedDate){
        List<VaccineObject> ls = vaccineModel.search(ID, 0);
        if (ls == null || ls.size() == 0){
            return;
        }
        else {
            VaccineObject temp = new VaccineObject(ID, name, indication, dose, ls.get(0).getInsertedBy(), updatedBy,
                    ls.get(0).getInsertedDate(), updatedDate, ls.get(0).isHaveUse());
        }
    }
    public List<VaccineObject> searchBy(String Value, int by){
        return vaccineModel.search(Value, by);
    }
}
