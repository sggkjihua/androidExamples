package com.example.think.explicity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AnoherActivity extends AppCompatActivity {
    EditText editText;
    Button bt_send;

    private final String Channel_ID = "personal_notification";
    public static final int Notification_ID = 001;
    //用于直接回复的
    public static final String TXT_REPLY = "text_reply";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anoher);
        editText = findViewById(R.id.eidt_message);
        bt_send = findViewById(R.id.bt_send);
    }

    public void sshow_message(View view) {
        String message = editText.getText().toString();
        Intent returnIntent = new Intent();
        returnIntent.putExtra("message",message);
        setResult(RESULT_OK,returnIntent);
        finish();
    }

    public void notification(View view) {
        //设置点击了notification之后回来会见到什么界面
        Intent landingIntent = new Intent(this, NotifiedActivity.class);
        landingIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent landingpendingintent = PendingIntent.getActivity(this,0,landingIntent,PendingIntent.FLAG_ONE_SHOT);

        //下面的2和3是用来创建选项用的，上面的是直接点进去就可以看到的页面
        Intent landingIntent2 = new Intent(this,YesActivity.class);
        landingIntent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent landingpendingintent2 = PendingIntent.getActivity(this,0,landingIntent2,PendingIntent.FLAG_ONE_SHOT);

        Intent landingIntent3 = new Intent(this, NoActivity.class);
        landingIntent3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent landingpendingintent3 = PendingIntent.getActivity(this,0,landingIntent3,PendingIntent.FLAG_ONE_SHOT);

        createNotificationChannel();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,Channel_ID);
        builder.setSmallIcon(R.drawable.ic_notification);
        builder.setContentTitle("Simple Notification");
        builder.setContentText("This is a small notification");
        //这里添加点击notification之后的东西
        builder.setContentIntent(landingpendingintent);
        //可以根据自己的选择进入不同的页面
        builder.addAction(R.drawable.ic_notification,"Yes", landingpendingintent2);
        builder.addAction(R.drawable.ic_notification,"No", landingpendingintent3);

        //if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N) {
        //    RemoteInput remoteInput = new RemoteInput.Builder(TXT_REPLY).setLabel("Reply").build();
        //    Intent replyIntent = new Intent(this, DirectActivity.class);
        //    replyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        //    PendingIntent replypendingIntent = PendingIntent.getActivity(this,0,replyIntent,PendingIntent.FLAG_ONE_SHOT);
        //    NotificationCompat.Action action = new NotificationCompat.Action.Builder(R.drawable.ic_notification,"Reply",replypendingIntent).addRemoteInput(remoteInput).build();
        //    builder.addAction(action);
        //}

        //将notification设置成图片
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.haitun);
        builder.setLargeIcon(bitmap);
        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).bigLargeIcon(null));

        //将notification设置成文字
        //builder.setStyle(new NotificationCompat.BigTextStyle().bigText(getString(R.string.notification_text)));
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(Notification_ID, builder.build());
}

    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "Personal Notification";
            String description = "Include all the personal notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel(Channel_ID,name,importance);
            notificationChannel.setDescription(description);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);

        }
    }
}
