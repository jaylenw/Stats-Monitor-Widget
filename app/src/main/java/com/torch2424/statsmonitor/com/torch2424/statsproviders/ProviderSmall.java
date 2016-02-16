package com.torch2424.statsmonitor.com.torch2424.statsproviders;

import android.appwidget.AppWidgetProvider;
import android.content.Context;

import com.torch2424.statsmonitor.com.torch2424.statshelpers.ProviderHelper;


public class ProviderSmall extends AppWidgetProvider
{
    //2X1

    //Simply using a helper to maange multiple providers
    ProviderHelper helper = new ProviderHelper();

    //need peniding intent flags to properly create and destroy alarm
    public void onEnabled(Context context)
    {

        //Use the helper to call the alarm through the runnable
        helper.callAlarm(context);
    }

    public void onDisabled(Context context)
    {
        //Stop the Handler
        helper.stopAlarm(context);
    }
}