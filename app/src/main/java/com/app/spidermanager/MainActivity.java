package com.app.spidermanager;

import android.app.AlarmManager;
import android.os.Bundle;
import com.app.db.DbHelper;
import com.app.notifications.NotificationService;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.app.spidermanager.databinding.ActivityMainBinding;
import android.view.Menu;
import android.view.MenuItem;
import java.io.IOException;
import java.util.Calendar;

/**
 * Главная активность
 */
public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private NavController navController;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dbHelper = new DbHelper(getApplicationContext());
        try {
            dbHelper.createDb();
        } catch (IOException e) {
            e.printStackTrace();
        }

        setSupportActionBar(binding.toolbar);

        final NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().
                        findFragmentById(R.id.nav_host_fragment_content_main);
        navController = navHostFragment.getNavController();

        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        AlarmManager manager = (AlarmManager)getSystemService(
                ALARM_SERVICE);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.SECOND, 10);
        long time = calendar.getTimeInMillis();

        manager.setRepeating(AlarmManager.RTC_WAKEUP, time, AlarmManager.INTERVAL_DAY,
                NotificationService.getPendingIntent(this));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        final int notificationId = R.id.action_notification;
        final int aboutId = R.id.action_about;

        switch (id){
            case notificationId:
                navController.navigate(R.id.action_SpidersFragment_to_NotificationsFragment);
                return true;
            case aboutId:
                navController.navigate(R.id.action_SpidersFragment_to_AboutFragment);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}