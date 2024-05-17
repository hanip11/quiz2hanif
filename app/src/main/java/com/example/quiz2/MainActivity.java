package com.example.quiz2;

import android.content.Intent;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private RadioGroup iprg, tambahanrg;
    private TextInputEditText rentDayset;
    private Button confirmbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iprg = findViewById(R.id.iprg);
        tambahanrg = findViewById(R.id.tambahanrg);
        rentDayset = findViewById(R.id.rentDayset);
        confirmbtn = findViewById(R.id.confirmbtn);

        confirmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTotalCost();
            }
        });
    }

    private void calculateTotalCost() {
        int selectedIphoneId = iprg.getCheckedRadioButtonId();
        int selectedTambahanId = tambahanrg.getCheckedRadioButtonId();
        String rentDaysStr = rentDayset.getText().toString();

        if (selectedIphoneId == -1 || TextUtils.isEmpty(rentDaysStr)) {
            Toast.makeText(this, "Please select an iPhone and enter the number of rental days.", Toast.LENGTH_SHORT).show();
            return;
        }

        int rentDays = Integer.parseInt(rentDaysStr);
        int totalCost = 0;
        String iphoneName = "";
        String additionalItems = "";

        if (selectedIphoneId == R.id.ip15rb) {
            totalCost += rentDays * 300000;
            iphoneName = "Iphone 15 Pro Max";
        } else if (selectedIphoneId == R.id.ip15prorb) {
            totalCost += rentDays * 280000;
            iphoneName = "Iphone 15 Pro";
        } else if (selectedIphoneId == R.id.ip14rb) {
            totalCost += rentDays * 250000;
            iphoneName = "Iphone 14 Pro Max";
        } else if (selectedIphoneId == R.id.ip14prorb) {
            totalCost += rentDays * 200000;
            iphoneName = "Iphone 14 Pro";
        } else if (selectedIphoneId == R.id.ip13rb) {
            totalCost += rentDays * 100000;
            iphoneName = "Iphone 13 Pro Max";
        }

        if (selectedTambahanId != -1) {
            if (selectedTambahanId == R.id.airrb) {
                totalCost += rentDays * 20000;
                additionalItems = "Air Pods";
            } else if (selectedTambahanId == R.id.casrb) {
                totalCost += rentDays * 10000;
                additionalItems = "Cassing";
            }
        }

        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("iphone_name", iphoneName);
        intent.putExtra("additional_items", additionalItems);
        intent.putExtra("rental_duration", rentDays);
        intent.putExtra("total_cost", totalCost);
        startActivity(intent);
    }
}
