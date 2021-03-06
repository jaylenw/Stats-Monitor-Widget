package com.torch2424.statsmonitor.com.torch2424.statsproviders;

import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;

import com.torch2424.statsmonitor.com.torch2424.statshelpers.ProviderHelper;


public class ProviderBig extends AppWidgetProvider
{
	//2X3

    //need pending intent flags to properly create and destroy alarm
    public void onEnabled(Context context)
    {

        //Start our service
        ProviderHelper.startWidget();
        Intent providerIntent = new Intent(context, ProviderHelper.class);
        context.startService(providerIntent);
    }

    public void onDisabled(Context context)
    {

        //Kill the service
        ProviderHelper.destroyWidget();
        Intent providerIntent = new Intent(context, ProviderHelper.class);
        context.stopService(providerIntent);
    }
}
