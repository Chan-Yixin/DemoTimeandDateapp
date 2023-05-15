package sg.edu.rp.c346.id22038283.demotimeanddateapp;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnDisplayTime;
    Button btnDisplayDate;
    TextView tvDisplay;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.textViewDisplay);
        btnDisplayTime = findViewById(R.id.buttonDisplayTime);
        btnDisplayDate = findViewById(R.id.buttonDisplayDate);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        Button resetButton = findViewById(R.id.resetButton);


        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour = tp.getHour();
                int minute = tp.getMinute();
                String time = String.format("%02d:%02d", hour, minute);
                tvDisplay.setText("Time is " + time);
            }
        });

        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int day = dp.getDayOfMonth();
                int month = dp.getMonth() ;
                int year = dp.getYear();
                String date = String.format("%02d/%02d/%04d", day, month, year);
                tvDisplay.setText("Date is " + date);
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Reset the date and time pickers
                dp.updateDate(2021, 0, 1);
                tp.setHour(0);
                tp.setMinute(0);

                // Clear the display text
                tvDisplay.setText("");
            }
        });

    }
}
