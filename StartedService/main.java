package player.musicplayerservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import player.musicplayerservice.Service.MyStartedService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this will call the service
        Intent intent = new Intent(MainActivity.this,MyStartedService.class);
        intent.putExtra("Check","Show this message via service");
        startService(intent);
        
        //to stop service just create a intent and call stopService method 
        
        /*
        
        Intnet intent = new Intent(MainActivity.this,MyStartedService.class);
        stopService(intent);
        
        */
    }
}



###################### startedService 

package player.musicplayerservice.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyStartedService extends Service {
    public MyStartedService() {
        //this is a default constructor for Started Service
    }

    @Override
    public IBinder onBind(Intent intent) {
        // Started Service Return Null always and onBind is a override method it will call started servie and bound service


        return null;
    }

    private void DoSomeAction(String msg) {


        Log.i("Got Message",msg);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.i("Delay",msg+"Show After 10s");
    }

    //this is method is the main method,it called for the command that we want to show
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        String msg = intent.getStringExtra("Check");
        DoSomeAction(msg);

        return Service.START_REDELIVER_INTENT;
    }
}

