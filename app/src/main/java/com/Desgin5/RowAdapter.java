package com.Desgin5;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Varinder on 8/27/2014.
 */
public class RowAdapter extends ArrayAdapter<RecurringDeposit>{
    Activity activity;
    List<RecurringDeposit> recurringDepositList;
    LayoutInflater layoutInflater;

    public RowAdapter(Activity activity, List<RecurringDeposit> recurringDepositList) {
        super(activity,R.layout.listrow_details, recurringDepositList);
        this.activity=activity;
        this.recurringDepositList=recurringDepositList;
        layoutInflater=activity.getLayoutInflater();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
if(convertView==null){
    convertView= layoutInflater.inflate(R.layout.listrow_details,null);
}
        RecurringDeposit recurringDeposit= new RecurringDeposit();
        recurringDeposit=recurringDepositList.get(position);

        TextView txtFirst=(TextView) convertView.findViewById(R.id.txtFirstColumn);
        txtFirst.setText(recurringDeposit.FirstColumn);

        TextView txtViewSecond =(TextView) convertView.findViewById(R.id.txtSecondColumn);
        txtViewSecond.setText(recurringDeposit.SecondColumn);

        TextView txtThird =(TextView) convertView.findViewById(R.id.txtThirdColumn);
        txtThird.setText(recurringDeposit.ThirdColumn);

        ImageView imageView =(ImageView) convertView.findViewById(R.id.ImgseeMore);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity,DetailActivity.class);
                intent.putExtra("RD",recurringDepositList.get(position));
                activity.startActivity(intent);
                /*Toast.makeText(activity,"Hi i am clicked",Toast.LENGTH_LONG).show();*/
            }
        });

        return convertView;
    }
}
