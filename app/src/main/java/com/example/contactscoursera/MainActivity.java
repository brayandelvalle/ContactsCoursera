package com.example.contactscoursera;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.time.Month;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;
    private Button dateButton;
    private Button BtnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatePicker();
        dateButton  = findViewById(R.id.btnDatePicker);
        BtnNext     = findViewById(R.id.btnNext);

        final EditText etName        = findViewById(R.id.etName);
        final EditText etTel         = findViewById(R.id.etTel);
        final EditText etMail        =  findViewById(R.id.etMail);
        final EditText etDescription = findViewById(R.id.etDescription);


        //Sending the info to the second activity
        BtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent12 = new Intent(MainActivity.this, detailsContact.class);
                String Name, Date, Tel, Mail, Description;
                Name        = etName.getText().toString();
                Date        = dateButton.getText().toString();
                Tel         = etTel.getText().toString();
                Mail        = etMail.getText().toString();
                Description = etDescription.getText().toString();

                intent12.putExtra(getResources().getString(R.string.Name1),Name);
                intent12.putExtra(getResources().getString(R.string.Date1), Date);
                intent12.putExtra(getResources().getString(R.string.Tel1), Tel);
                intent12.putExtra(getResources().getString(R.string.Mail1), Mail);
                intent12.putExtra(getResources().getString(R.string.Descrip1), Description);

                startActivity(intent12);
            }
        });



        //Getting back the values from detailsContact
        //The conditional is to keep showing the default date. Without it the date would look blank
        Integer CONFIRM = getIntent().getIntExtra("CONFIRM", 0);
        if (CONFIRM == 1){

            String Name2        = getIntent().getStringExtra(getResources().getString(R.string.Name2));
            String Date2        = getIntent().getStringExtra(getResources().getString(R.string.Date2));
            String Tel2         = getIntent().getStringExtra(getResources().getString(R.string.Tel2));
            String Mail2        = getIntent().getStringExtra(getResources().getString(R.string.Mail2));
            String Description2 = getIntent().getStringExtra(getResources().getString(R.string.Descrip2));

            etName.setText(Name2);
            dateButton.setText(Date2);
            etTel.setText(Tel2);
            etMail.setText(Mail2);
            etDescription.setText(Description2);
        }

    }

    //Method for the date piker
    public void initDatePicker()
    {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day)
            {
                //JAN=0 so we sum 1 to set JAN=1
                month = month +1;
                String date = MonthToString(month) + "/" + day + "/" + year;
                dateButton.setText(date);
            }
        };

        Calendar calendar = Calendar.getInstance();
        int year  = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day   = calendar.get(Calendar.DAY_OF_MONTH);
        int style = AlertDialog.THEME_HOLO_LIGHT;  //THEME_HOLO_LIGHT this one looks like a spinner

        datePickerDialog = new DatePickerDialog(this, style,dateSetListener, year, month, day);

    }

    //This method converts from int to string the month
    private String MonthToString(int month){
        if(month==1){return "ENE";}
        if(month==2){return "FEB";}
        if(month==3){return "MAR";}
        if(month==4){return "ABR";}
        if(month==5){return "MAY";}
        if(month==6){return "JUN";}
        if(month==7){return "JUL";}
        if(month==8){return "AGO";}
        if(month==9){return "SEP";}
        if(month==10){return "OCT";}
        if(month==11){return "NOV";}
        if(month==12){return "DIC";}
        return "ENE";
    }

    public void openDatePicker(View view)
    {
       datePickerDialog.show();
    }


    }

