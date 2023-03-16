package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.InputStream;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button btnSendNotification;
    private static final int NOTIFICATION_ID = 950;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSendNotification = (Button) findViewById(R.id.buttonSendNotification);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("My Channel", "My Channel", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        btnSendNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification();
            }
        });
    }

    private void sendNotification() {
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background);
//        Notification notification = new Notification.Builder(this)
//                .setContentTitle("Title push notification")
//                .setContentText("Message push notification")
//                .setSmallIcon(R.drawable.ic_launcher_background)
//                .setLargeIcon(bitmap)
//                .setAutoCancel(true)
//                .build();
//
//        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        if (manager != null) {
//            manager.notify(NOTIFICATION_ID, notification);
//        }

        Bitmap lagerIcon=BitmapFactory.decodeResource(getResources(),R.drawable.ic_baseline_local_fire_department_256);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "My Channel");
        builder.setContentTitle("Title");
        builder.setContentText("Content");
        builder.setSmallIcon(R.drawable.ic_baseline_local_fire_department_24);
        builder.setLargeIcon(lagerIcon);
        builder.setAutoCancel(true);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
        managerCompat.notify(getNotificationId(), builder.build());
    }
    private int getNotificationId(){
        return (int) new Date().getTime();
    }
}
