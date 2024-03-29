package com.Desgin5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class Result extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        try {
            Intent intent = getIntent();
            String columns = intent.getStringExtra("Mode");
            String duration = intent.getStringExtra("Duration");
            String Amount = intent.getStringExtra("Amount");
            Log.d("Amount -----*******-----", intent.getStringExtra("Amount"));

            DataBase dataBase = new DataBase(this);
            SparseArray<Group> sparseArray;
            if(duration.equals("All")){
                sparseArray= dataBase.RetrievingRD(columns,  Amount);
                ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.expandable);
                ExpandableAdapter adapter = new ExpandableAdapter(this, sparseArray);
                expandableListView.setAdapter(adapter);
            }
            else {

                List<RecurringDeposit> recurringDepositList = dataBase.RecurringDepositListForSelectedYear(columns,Amount,duration);
                ListView listView = (ListView) findViewById(R.id.listView);
                RowAdapter adapter = new RowAdapter(this,recurringDepositList);
               listView.setAdapter(adapter);
            }

        }
        catch (Exception ex){
            Log.d("Eexception -----********----",ex.getMessage());
            Toast.makeText(this,ex.getMessage(),Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
