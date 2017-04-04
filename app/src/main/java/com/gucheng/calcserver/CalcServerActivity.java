package com.gucheng.calcserver;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class CalcServerActivity extends AppCompatActivity {
    private static TextView resultView;
    private static final int UPDATE_RESULT =  111 ;
    private static final String TAG = "IPC_Server";
    public static long mResult = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_client);
        resultView = (TextView)findViewById(R.id.result);

    }

    @Override
    protected void onResume() {
        super.onResume();

            resultView.setText("Result is " + mResult);

    }



}
