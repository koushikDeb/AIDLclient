package test.koushik.aidlclient_onr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Toast;

import AIDLplace.IMyAidlInterface;
import test.koushik.aidlclient_onr.Connection.Serverconnectionclass;
import test.koushik.aidlclient_onr.interfaces.Serviceconnectedcallback;

public class MainActivity extends AppCompatActivity {


    IMyAidlInterface myinterfaceaidl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindService(new Intent("test.koushik.aidlserver.simpletest").setPackage("test.koushik.aidlserver"), new Serverconnectionclass(this, new Serviceconnectedcallback() {
            @Override
            public void gotthebinder(IBinder ib) {
                myinterfaceaidl=IMyAidlInterface.Stub.asInterface(ib);
            }
        }),BIND_AUTO_CREATE);

    }




    public void callserver(View view) {
        try {


            Toast.makeText(this, myinterfaceaidl.interprocess("aidlclient_onr.Connection","CALLED FROM APP 1"), Toast.LENGTH_LONG).show();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }



}



