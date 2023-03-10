package com.example.mymeteo;

import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.RemoteViews;

import com.example.mymeteo.MeteoWidget;
import com.example.mymeteo.R;

public class MeteoWidgetReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        // Check if the shared preference that was changed is the "cityName" or "temperature"
        if (intent.getAction().equals("com.example.mymeteo.action.UPDATE_WIDGET")) {

            // Get the current location and temperature from the shared preferences
            SharedPreferences sh = context.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
            String l1 = sh.getString("cityName", "Empty");
            String t1 = sh.getString("temperature", "#");

            // Get the widget manager and the widget ids for the widget
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, MeteoWidget.class));

            // Update the widget for each widget id
            for (int appWidgetId : appWidgetIds) {

                // Get the layout for the App Widget
                RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.meteo_widget);

                // Update the views with the current location and temperature
                views.setTextViewText(R.id.idTVCity, l1);
                views.setTextViewText(R.id.idTVTemp, t1);

                // Tell the AppWidgetManager to update the widget
                appWidgetManager.updateAppWidget(appWidgetId, views);
            }
        }
    }

}
