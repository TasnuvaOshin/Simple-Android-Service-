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
        Intent intent = new Intent(MainActivity.this,MyServiceTest.class);
        intent.putExtra("Check","Show this message via service");
        startService(intent);



    }
}







########################## Now Intent Service Class .....



package player.musicplayerservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyServiceTest extends IntentService {
 private static final String message="IntentService";
    public MyServiceTest() {
        super("MyServiceTest");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i(message,"We are now in HandleIntent");

    }

}




########you dont need to call on destroy it will call automatically in intentService




   <service
            android:name=".MyServiceTest"
            android:enabled="true"
            android:exported="true" />
            
            
            #### include this in your manifest file 
