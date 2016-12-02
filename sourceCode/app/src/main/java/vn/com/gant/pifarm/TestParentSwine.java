package vn.com.gant.pifarm;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.ls.LSException;

import java.util.Date;
import java.util.List;

import function.DateHanding;
import models.ParentSwineModel;
import objects.ParentProcessObject;
import objects.ParentSwineObject;

public class TestParentSwine extends AppCompatActivity {

    Context con = this;
    Button btnadd,btnsearch,btnupdat,btnremove;
    EditText ID, dateImport, earNumber, dateCoordination, coordinatorID, expectedDateOfBirth, IDprocess;
    TextView v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_parent_swine);

        btnadd = (Button)findViewById(R.id.btnAdd);
        btnremove = (Button)findViewById(R.id.btnRemove);
        btnsearch = (Button)findViewById(R.id.btnSearch);
        btnupdat = (Button)findViewById(R.id.btnUpdate);

        ID = (EditText) findViewById(R.id.edtID);
        dateImport = (EditText) findViewById(R.id.edtImport);
        earNumber = (EditText) findViewById(R.id.edtEarNumber);
        dateCoordination = (EditText) findViewById(R.id.edtdateCoordination);
        coordinatorID = (EditText) findViewById(R.id.edtcoordinatorID);
        expectedDateOfBirth = (EditText) findViewById(R.id.edtexpectedDateOfBirth);
        IDprocess = (EditText) findViewById(R.id.edtIDprocess);

        v = (TextView) findViewById(R.id.textViewData);
        final ParentSwineModel model = new ParentSwineModel(this);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = ID.getText().toString();
                Date importdate = DateHanding.getDate(dateImport.getText().toString()),
                        coordate = DateHanding.getDate(dateCoordination.getText().toString()),
                        datebirth = DateHanding.getDate(expectedDateOfBirth.getText().toString());
                String ear = earNumber.getText().toString(), idcoor = coordinatorID.getText().toString(),
                        idpro = IDprocess.getText().toString();
                ParentSwineObject p = new ParentSwineObject(id,importdate, ear,coordate,idcoor,datebirth,idpro,"$2#v1#3#v2#2$","$123#1234$","no note");
                model.add(p);
            }
        });

        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    //print(model.searchAll());
                    if (ID.getText().toString().equals("")) {
                        print(model.searchAll());
                    }
                    else{
                        List<ParentSwineObject> child = model.search(ID.getText().toString());
                        /*if (child.size() == 0 || child == null){
                            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(con);
                            dlgAlert.setMessage("danh sach ronh");
                            dlgAlert.setTitle("Lỗi search");
                            dlgAlert.setPositiveButton("OK", null);
                            dlgAlert.setCancelable(true);
                            dlgAlert.create().show();
                        }*/
                        print(child);
                    }
                }
                catch (Exception e){


                }


            }
        });
        btnremove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ID.getText().toString().equals("")) {
                    v.setText("remove faild. Insert ID please.");
                    return;
                }
                else{
                    model.remove(ID.getText().toString());
                    v.setText("RemoveSuces");
                }
            }
        });

        btnupdat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ID.getText().toString().equals("")) {
                    v.setText("update faild. Insert ID please.");
                    return;
                }
                else{
                    String id = ID.getText().toString();
                    Date importdate = DateHanding.getDate(dateImport.getText().toString()),
                            coordate = DateHanding.getDate(dateCoordination.getText().toString()),
                            datebirth = DateHanding.getDate(expectedDateOfBirth.getText().toString());
                    String ear = earNumber.getText().toString(), idcoor = coordinatorID.getText().toString(),
                            idpro = IDprocess.getText().toString();
                    ParentSwineObject p = new ParentSwineObject(id,importdate, ear,coordate,idcoor,datebirth,idpro,"$2#v1#3#v2#2$","$123#1234$","no note");
                    model.update(p);
                }
            }
        });

    }

    public void print(List<ParentSwineObject> p){
        String temp = "So luong: " + p.size() + "\n";
        for (ParentSwineObject a : p){
            temp += "ID: " + a.getID() + "\tSo tai: " + a.getEarNumber()+ "\tDateImport: " + DateHanding.getDateString(a.getDateImport()) + "\n";
            temp += "---------------------------\n";
        }
        v.setText(temp);
    }
}
