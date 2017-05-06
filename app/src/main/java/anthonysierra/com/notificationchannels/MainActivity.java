package anthonysierra.com.notificationchannels;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String notificationChannelId = "com_anthonysierra_NotificationChannels_01";
    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();
    }

    /**
     * Sends a notification to the user via the the channel.
     *
     * @param view
     */
    public void sendNotification(final View view) {
        final Notification notification = new Notification.Builder(this)
                .setContentTitle("Fake notification")
                .setContentText("Some useful text")
                .setSmallIcon(android.R.drawable.alert_light_frame)
                .setChannel(notificationChannelId)
                .build();
        notificationManager.notify(1, notification);
    }

    /**
     * Creates the notification channel that will show up in the settings page for this app.
     */
    private void createNotificationChannel() {
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        final NotificationChannel channel = new NotificationChannel(notificationChannelId, "Hello", NotificationManager.IMPORTANCE_LOW);
        notificationManager.createNotificationChannel(channel);
    }
}
