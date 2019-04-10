# Simple-Android-Service-
Here is the Simple way to understand Android Service how service works 
Make you have added This in your Manifest File :

    <?xml version="1.0" encoding="utf-8"?>
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        package="player.musicplayerservice">

        <application
            android:allowBackup="true"
            android:icon="@mipmap/ic_launcher"
            android:label="@string/app_name"
            android:roundIcon="@mipmap/ic_launcher_round"
            android:supportsRtl="true"
            android:theme="@style/AppTheme">
            <activity android:name=".MainActivity">
                <intent-filter>
                    <action android:name="android.intent.action.MAIN" />

                    <category android:name="android.intent.category.LAUNCHER" />
                </intent-filter>
            </activity>

            <service
                android:name=".Service.MyStartedService"
                android:enabled="true"
                android:exported="true"></service>
        </application>

    </manifest>
