package com.design.summerslam.effectapplication.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.design.summerslam.effectapplication.R;
import com.design.summerslam.effectapplication.widget.CircleProgressBarView;

/**
 * Created by summerslam on 15/11/12.
 */
public class CircleProgressActivity extends Activity {

    private CircleProgressBarView mCircleProgressBarView;

    private int mTotalProgress;
    private int mCurrentProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_circle_progressbar);
        initVariable();
        initView();

        new Thread(new ProgressRunable()).start();
    }

    private void initVariable() {
        mTotalProgress = 100;
        mCurrentProgress = 0;
    }

    private void initView() {
        mCircleProgressBarView = (CircleProgressBarView) findViewById(R.id.tasks_view);
    }

    class ProgressRunable implements Runnable {

        @Override
        public void run() {
            while (mCurrentProgress < mTotalProgress) {
                mCurrentProgress += 1;
                mCircleProgressBarView.setProgress(mCurrentProgress);
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
