package com.example.quiz2;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tvIphoneName = findViewById(R.id.tvIphoneName);
        TextView tvAdditionalItems = findViewById(R.id.tvAdditionalItems);
        TextView tvRentalDuration = findViewById(R.id.tvRentalDuration);
        TextView tvTotalCost = findViewById(R.id.tvTotalCost);

        String iphoneName = getIntent().getStringExtra("iphone_name");
        String additionalItems = getIntent().getStringExtra("additional_items");
        int rentalDuration = getIntent().getIntExtra("rental_duration", 0);
        int totalCost = getIntent().getIntExtra("total_cost", 0);

        tvIphoneName.setText("iPhone: " + iphoneName);
        tvAdditionalItems.setText("Tambahan Barang: " + additionalItems);
        tvRentalDuration.setText("Lama Rental: " + rentalDuration + " hari");
        tvTotalCost.setText("Total Harga: Rp " + totalCost);
    }
}
