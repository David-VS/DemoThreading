package be.ehb.demothreading;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.Date;

import be.ehb.demothreading.threading.ProgressHandler;
import be.ehb.demothreading.threading.ProgressTask;

public class MainActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;
    private Button btnStartHandler, btnAsync;
    private ProgressHandler mHandler;
    private boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = findViewById(R.id.progress);
        btnStartHandler = findViewById(R.id.btn_start_handler);
        btnStartHandler.setOnClickListener((view) -> {
            if(!isRunning)
                startThread();
        });
        mHandler = new ProgressHandler(mProgressBar);
        btnAsync = findViewById(R.id.btn_async);
        btnAsync.setOnClickListener((view) -> {
            ProgressTask mProgressTask = new ProgressTask(mProgressBar);
            mProgressTask.execute();
        });
    }

    private void startThread() {
        Thread bgThread = new Thread((Runnable)() ->{
            isRunning = true;
            for(int i = 1; i <= 100 ; i++){

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //*
                Message msg = new Message();
                msg.arg1 = i;
                mHandler.sendMessage(msg);
                //*/
            }
            isRunning = false;
        });
        bgThread.start();
    }
}