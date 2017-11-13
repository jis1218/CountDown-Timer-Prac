package com.example.countdowntimerprac;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    TextView m100MS, m1000MS;

    Timer timer = new Timer();

    TimerTask m100MSCounter = null;
    TimerTask m1000MSCounter = null;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m100MS = (TextView) findViewById(R.id.ms_100);
        m1000MS = (TextView) findViewById(R.id.ms_1000);
        button = (Button) findViewById(R.id.start_count_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTimerTask();
            }
        });
    }

    @Override
    protected void onDestroy() {
        timer.cancel();
        super.onDestroy();
    }

    public void onClick(View v) {

                stopTimerTask();

    }

    private void startTimerTask(){


                m100MSCounter = new TimerTask() {
                    int count = 0;
                    @Override
                    public void run() {
                        count ++;
                        m100MS.post(new Runnable() {
                            @Override
                            public void run() {
                                m100MS.setText("100MS count" + count);
                            }
                        });
                    }
                };

                m1000MSCounter = new TimerTask() {
                    int count = 0;
                    @Override
                    public void run() {
                        count++;
                        m1000MS.post(new Runnable() {
                            @Override
                            public void run() {
                                m1000MS.setText("1000MS count" + count);
                            }
                        });

                    }
                };

                timer.schedule(m100MSCounter, 100, 100);
                timer.schedule(m1000MSCounter, 1000, 1000);
            }

            private void stopTimerTask(){
                if(m1000MSCounter != null || m100MSCounter != null){
                    m100MSCounter.cancel();
                    m1000MSCounter.cancel();
                    m100MSCounter = null;
                    m1000MSCounter = null;
                }

                m100MS.setText("100MS Count : 0");
                m1000MS.setText("1000MS Count : 0");
            }

    }

