package be.ehb.demothreading.threading;

import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;

public class ProgressHandler extends Handler {

    private ProgressBar mProgressBar;

    public ProgressHandler(ProgressBar mProgressBar) {
        this.mProgressBar = mProgressBar;
    }

    @Override
    public void handleMessage(@NonNull Message msg) {
        super.handleMessage(msg);

        mProgressBar.setProgress(msg.arg1);
    }
}
