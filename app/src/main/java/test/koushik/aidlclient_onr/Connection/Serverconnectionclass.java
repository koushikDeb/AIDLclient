package test.koushik.aidlclient_onr.Connection;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.widget.Toast;

import AIDLplace.IMyAidlInterface;

import test.koushik.aidlclient_onr.interfaces.Serviceconnectedcallback;

public class Serverconnectionclass implements ServiceConnection  {

    Context con;
IMyAidlInterface myaidl;
    Serviceconnectedcallback sercallback;
public Serverconnectionclass(Context con,Serviceconnectedcallback sercallback)
{
this.con=con;
this.sercallback=sercallback;
}



    @Override
    public void onServiceConnected(ComponentName componentName , IBinder iBinder) {
        Toast.makeText(con," connected",Toast.LENGTH_LONG).show();

        sercallback.gotthebinder(iBinder);



    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        Toast.makeText(con,componentName.getClassName()+" disconnect",Toast.LENGTH_LONG).show();
    }
}
