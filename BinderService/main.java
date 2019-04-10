package player.musicplayerservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    ServiceConnection serviceConnection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                //wwe need to get our interface so we bind here and then we will get the
                //method from there
                MyBinderService.MyBinder binder = (MyBinderService.MyBinder) iBinder;
                MyBinderService myBinderService = binder.myBinderService(); //interface method calling
                int sum = myBinderService.SumTt(10, 4); //via interface we can now call our method under  binder class
                Log.i("Sum of the value is", String.valueOf(sum));
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        };


    }


    @Override
    protected void onStart() {
        super.onStart();


        //we will bind the service when we opent he app
        Intent intent = new Intent(this, MyBinderService.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //now work done we are closing the app so lets unbind the service now

        unbindService(serviceConnection); //thats it
    }
}









