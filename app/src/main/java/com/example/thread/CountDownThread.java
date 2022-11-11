package com.example.thread;

import android.widget.TextView;

public class CountDownThread implements Runnable {
    TextView tvNumber, tvEndNumber;
    private static MainActivity mMainActivity;

    public CountDownThread(TextView tvNumber, TextView tvEndNumber, MainActivity mainActivity) {
        this.tvNumber = tvNumber;
        this.tvEndNumber = tvEndNumber;
        CountDownThread.mMainActivity = mainActivity;
    }
    @Override
    public void run() {
        int count = 10;

        for (int i = count; i > 0; i--) {
            int finalI = i;
            mMainActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tvNumber.setText(String.valueOf(finalI));
                }
            });

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        mMainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvNumber.setText("0");
                tvEndNumber.setText("End");
            }
        });
    }
}
