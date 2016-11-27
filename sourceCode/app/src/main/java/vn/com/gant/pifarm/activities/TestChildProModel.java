package vn.com.gant.pifarm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import function.IntergerHanding;
import function.StringHanding;
import models.ChildProcessModel;
import objects.ChildProcessObject;
import vn.com.gant.pifarm.R;

/**
 * Created by vanthi on 11/26/2016.
 */

public class TestChildProModel extends AppCompatActivity {

    private EditText txtvID;
    private EditText txtvNday;
    private EditText txtvVaccine;
    private TextView txtData;
    private Button btnAdd,btnRemove,btnUpdate,btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_childpromod);


        txtvID = (EditText) findViewById(R.id.txtvID);
        txtvNday = (EditText) findViewById(R.id.txtvnday);
        txtvVaccine = (EditText) findViewById(R.id.txtvVaccine);
        txtData = (TextView) findViewById(R.id.txtvData);
        btnAdd = (Button) findViewById(R.id.btnAddPro);
        btnRemove = (Button) findViewById(R.id.btnRemove);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);

        final ChildProcessModel cpMod = new ChildProcessModel(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtvID.getText().toString().equals("")) {
                    txtData.setText("add faild. Insert ID please.");
                }
                else {
                    String id = txtvID.getText().toString();
                    Integer nDate = IntergerHanding.getInterger(txtvNday.getText().toString());
                    Map<String, Integer> map = new HashMap<String, Integer>();
                    String[] buf = StringHanding.getArrayStr(txtvVaccine.getText().toString());
                    for (int i = 0; i < buf.length; i = i + 2) {
                        map.put(buf[i], IntergerHanding.getInterger(buf[i + 1]));
                    }
                    ChildProcessObject ob = new ChildProcessObject(id, nDate, map);
                    cpMod.add(ob);
                }
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtvID.getText().toString().equals("")) {
                    printChildProcessOb(cpMod.searchAll());
                }
                else{
                    List<ChildProcessObject> child = cpMod.search(txtvID.getText().toString());
                    printChildProcessOb(child);
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtvID.getText().toString().equals("")) {
                    txtData.setText("remove faild. Insert ID please.");
                    return;
                }
                else{
                    String id = txtvID.getText().toString();
                    Integer nDate = IntergerHanding.getInterger(txtvNday.getText().toString());
                    Map<String, Integer> map = new HashMap<String, Integer>();
                    String[] buf = StringHanding.getArrayStr(txtvVaccine.getText().toString());
                    for (int i = 0; i < buf.length; i = i + 2) {
                        map.put(buf[i], IntergerHanding.getInterger(buf[i + 1]));
                    }
                    ChildProcessObject ob = new ChildProcessObject(id, nDate, map);
                    cpMod.update(ob);
                }
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtvID.getText().toString().equals("")) {
                    txtData.setText("remove faild. Insert ID please.");
                    return;
                }
                else{
                    cpMod.remove(txtvID.getText().toString());
                    txtData.setText("RemoveSuces");
                }
            }
        });
        txtData.setMovementMethod(new ScrollingMovementMethod());
    }


    public void printChildProcessOb(List<ChildProcessObject> ob) {
        String a = ob.size() + "\n";
        for (ChildProcessObject chi : ob){
            a += "ID: " + chi.getID() + "\n";
            a += "nDay: " +chi.getnDayAfterBorn() + "\n";
            Map<String, Integer> map = new HashMap<String, Integer>();
            map = chi.getLsVaccine();
            for (Map.Entry<String, Integer> v : map.entrySet()){
                a += v.getKey() + "   " + v.getValue() + "\n";
            }
            a += "-------------------------------\n";
        }
        txtData.setText(a);
    }
}
