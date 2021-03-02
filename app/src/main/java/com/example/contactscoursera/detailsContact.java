package com.example.contactscoursera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class detailsContact extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_contact);

        //Getting the values from main activity
        Bundle parameters = getIntent().getExtras();
        final String Name     = parameters.getString(getResources().getString(R.string.Name1));
        final String Date     = parameters.getString(getResources().getString(R.string.Date1));
        final String Tel      = parameters.getString(getResources().getString(R.string.Tel1));
        final String Email    = parameters.getString(getResources().getString(R.string.Mail1));
        final String Descrip  = parameters.getString(getResources().getString(R.string.Descrip1));

        //setting the parameters from main activity to detailsContact.
        TextView tv2Name    = findViewById(R.id.tv2Name);
        TextView tv2Date    = findViewById(R.id.tv2Date);
        TextView tv2Tel     = findViewById(R.id.tv2Number);
        TextView tv2Email   = findViewById(R.id.tv2Email);
        TextView tv2Descrip = findViewById(R.id.tv2Description);

        tv2Name.setText(Name);
        tv2Date.setText(Date);
        tv2Tel.setText(Tel);
        tv2Email.setText(Email);
        tv2Descrip.setText(Descrip);

        //Sending backto edit the former information
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent21 = new Intent(detailsContact.this, MainActivity.class);

                //The other information
                Integer CONFIRM = 1;
                intent21.putExtra("CONFIRM", CONFIRM);
                intent21.putExtra(getResources().getString(R.string.Name2), Name);
                intent21.putExtra(getResources().getString(R.string.Date2), Date);
                intent21.putExtra(getResources().getString(R.string.Tel2), Tel);
                intent21.putExtra(getResources().getString(R.string.Mail2), Email);
                intent21.putExtra(getResources().getString(R.string.Descrip2), Descrip);

                startActivity(intent21);

            }
        });
    }

}
