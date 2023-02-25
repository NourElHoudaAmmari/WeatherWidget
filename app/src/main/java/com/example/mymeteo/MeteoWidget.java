package com.example.mymeteo;
import static android.content.Context.MODE_APPEND;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.RemoteViews;


public class MeteoWidget extends AppWidgetProvider {






    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        for (int appWidgetId : appWidgetIds) {

            // Get the layout for the App Widget
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.meteo_widget);

            // Get the current location and temperature
            // Get the current location and temperature from MainActivity




            SharedPreferences sh = context.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);

            // The value will be default as empty string because for the very

            // first time when the app is opened, there is nothing to show
            String l1 = sh.getString("cityName", "Empty");
            String t1 = sh.getString("temperature", "#");

            // We can then use the data

             String location = l1;
             String temperature = t1;




            // Update the views with the current location and temperature
            views.setTextViewText(R.id.idTVCity, l1);
            views.setTextViewText(R.id.idTVTemp, t1);

            // Tell the AppWidgetManager to update the widget
            appWidgetManager.updateAppWidget(appWidgetId, views);


        }
    }

}
