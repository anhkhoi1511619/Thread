package com.example.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Thread Thread1 = null;
    private Button btnCount;
    private TextView tvNumber, tvEndNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startCountByThread();
            }
        });
    }

    private void startCountByThread() {
        Thread1 = new Thread(new CountDownThread(tvNumber, tvEndNumber, this));
        Thread1.start();
    }

    private void initUI() {
        btnCount = findViewById(R.id.btn_startCount);
        tvNumber = findViewById(R.id.tv_number);
        tvEndNumber = findViewById(R.id.tv_end);
    }

}