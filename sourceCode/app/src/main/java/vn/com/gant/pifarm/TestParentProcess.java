package vn.com.gant.pifarm;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import function.IntergerHanding;
import function.StringHanding;
import models.ParentProcessModel;
import objects.ChildProcessObject;
import objects.ParentProcessObject;

public class TestParentProcess extends AppCompatActivity {

    Context con;

    private EditText txtvID;
    private EditText txtvNday;
    private EditText txtvVaccine;
    private TextView txtData;
    private Button btnAdd,btnRemove,btnUpdate,btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_parent_process);

        txtvID = (EditText) findViewById(R.id.txtvID);
        txtvNday = (EditText) findViewById(R.id.txtvnday);
        txtvVaccine = (EditText) findViewById(R.id.txtvVaccine);
        txtData = (TextView) findViewById(R.id.txtvData);
        btnAdd = (Button) findViewById(R.id.btnAddPro);
        btnRemove = (Button) findViewById(R.id.btnRemove);
        btnSearch = (Button) findViewById(R.id.btnSearch);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);

        final ParentProcessModel cpMod = new ParentProcessModel(this);

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
                    ParentProcessObject ob = new ParentProcessObject(id, nDate, map, nDate, map);
                    cpMod.add(ob);
                }
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtvID.getText().toString().equals("")) {
                    printProcessOb(cpMod.searchAll());
                }
                else{
                    List<ParentProcessObject> child = cpMod.search(txtvID.getText().toString());
                    printProcessOb(child);
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtvID.getText().toString().equals("")) {
                    txtData.setText("update faild. Insert ID please.");
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
                    ParentProcessObject ob = new ParentProcessObject(id, nDate, map, nDate, map);
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
    public void printProcessOb(List<ParentProcessObject> ob) {
        String a = ob.size() + "\n";
        for (ParentProcessObject chi : ob){
            a += "ID: " + chi.getID() + "\n";
            a += "nDay: " +chi.getnDayAfterImport() + "\t" + "Day 2: " + chi.getnDayAfterCoordination() + "\n";
            Map<String, Integer> map = new HashMap<String, Integer>();
            map = chi.getListVaccineCoordination();
            for (Map.Entry<String, Integer> v : map.entrySet()){
                a += v.getKey() + "   " + v.getValue() + "\n";
            }
            a += "-------------------------------\n";
        }

        /*AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(con);
        dlgAlert.setMessage(a);
        dlgAlert.setTitle("Show");
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();*/

        txtData.setText(a);
    }
}
