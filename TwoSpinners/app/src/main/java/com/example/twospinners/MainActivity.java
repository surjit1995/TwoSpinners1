package com.example.twospinners;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner sp1,sp2;
    EditText etsalary,etnetsalary;
    List<Integer> sal= new ArrayList<Integer>();
    List<Integer> extraSal = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etsalary=findViewById(R.id.salary);
        etnetsalary=findViewById(R.id.netsalary);
        List<String> joblist = new ArrayList<String>();


        joblist.add("Programmer");
        joblist.add("Accountant");
        joblist.add("Manager");
        joblist.add("App Developer");
        joblist.add("Data Scientist");
        joblist.add("Engineer");

        sal.add(60000);
        sal.add(65000);
        sal.add(90000);
        sal.add(80000);
        sal.add(95000);
        sal.add(76000);

        sp1=findViewById(R.id.jobspin);

        ArrayAdapter<String> jobAdapter = new ArrayAdapter<String>( this,R.layout.support_simple_spinner_dropdown_item,joblist);


        jobAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);


        sp1.setAdapter(jobAdapter);
        sp1.setOnItemSelectedListener(this);

        List<String> qualification = new ArrayList<String>();
        qualification.add("PHD");
        qualification.add("Masters");
        qualification.add("Bachelors");
        qualification.add("High School");
        qualification.add("Certificate");
        qualification.add("Diploma");

        extraSal.add(15000);
        extraSal.add(10000);
        extraSal.add(7000);
        extraSal.add(5000);
        extraSal.add(3000);
        extraSal.add(1000);


        sp2=findViewById(R.id.qualspin);

        ArrayAdapter<String> qualAdapter = new ArrayAdapter<String>( this,R.layout.support_simple_spinner_dropdown_item,qualification);


        qualAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp2.setAdapter(qualAdapter);
        sp2.setOnItemSelectedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        Integer salary;
        switch (parent.getId()) {
            case R.id.jobspin:
                // int i = (int) id;
                salary = sal.get(position);
                etsalary.setText(salary.toString());
                break;
            case R.id.qualspin:
                Integer s = new Integer(Integer.parseInt(etsalary.getText().toString()));
                Integer ns = s + extraSal.get(position);
                etnetsalary.setText(ns.toString());
        }
    }



    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
