package com.Desgin5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent= this.getIntent();
        RecurringDeposit recurringDeposit= (RecurringDeposit) intent.getSerializableExtra("RD");
        TextView txtMonthly =(TextView) findViewById(R.id.txtMonthly);
        txtMonthly.setText(recurringDeposit.Monthly);

        TextView txtQuarterly =(TextView) findViewById(R.id.txtQuarterly);
        txtQuarterly.setText(recurringDeposit.Quarterly);

        TextView txtHalfYearly =(TextView) findViewById(R.id.txtHalfYearly);
        txtHalfYearly.setText(recurringDeposit.HalfYearly);

        TextView txtYearly =(TextView) findViewById(R.id.txtYearly);
        txtYearly.setText(recurringDeposit.Yearly);

        TextView txtFundValue =(TextView) findViewById(R.id.txtFundValue);
        txtFundValue.setText(recurringDeposit.FundValue);

        TextView txtMaturity =(TextView) findViewById(R.id.txtMaturity);
        txtMaturity.setText(recurringDeposit.Maturity);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.detail, menu);
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
