package com.baudiabatash.sohelhandler;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    private int counter;
    private boolean running;

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        handler = new Handler(this.getMainLooper());
    }

    public void start(View view) {
        Log.d("SOHEL","Enter into Action");
        running = true;

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (running){
                    try {
                        Thread.sleep(100);
                        counter++;

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                textView.setText(counter+"");
                            }
                        });

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

    }

    public void stop(View view) {
        running = false;
    }
}
