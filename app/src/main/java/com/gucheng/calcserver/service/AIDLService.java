package com.gucheng.calcserver.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;

import com.gucheng.calcclient.CalcMethods;
import com.gucheng.calcserver.CalcServerActivity;

public class AIDLService extends Service {
    private static final String TAG = "IPC_CalcServer";
    public static long result;
    public AIDLService() {
    }
    private static CalcMethods.Stub mCalcMethod = new CalcMethods.Stub() {


        @Override
        public long addFunc(long addOne, long addTwo) throws RemoteException {
            result = addOne + addTwo;
            Log.d(TAG, "addFunc result is " + result);

            CalcServerActivity.mResult = result;
            return result;
        }

        @Override
        public long addGetResult() throws RemoteException {
            return result;
        }
    };
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.d(TAG, "onBind");
        return mCalcMethod;

    }
}
