package player.musicplayerservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyBinderService extends Service {
    public MyBinderService() {
    }

    public int SumTt(int num, int num1) {
        return num + num1;

    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return new MyBinder();
    }


    public class MyBinder extends Binder {

        //it will return mybinderservice type work
        public MyBinderService myBinderService() {


            return MyBinderService.this;
//it will return the service

        }
    }
}
