package com.torch2424.simplemonitor;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import com.torch2424.statsmonitorwidget.R;

public class AdvancedSettings extends Activity
{
	//declaring checkboxes and booleans
	CheckBox tapConfig;
	CheckBox memoryGB;
	CheckBox ramGB;
	CheckBox hourFormat;
	RadioButton textLeft;
	RadioButton textRight;
	RadioButton textCenter;
	RadioButton oneSec;
	RadioButton threeSec;
	RadioButton fiveSec;
	CheckBox multiCPU;
	CheckBox noCPUTitle;
	CheckBox shortDays;
	CheckBox kilobytes;
	CheckBox degreesF;
	EditText externalPath;
	boolean tapBool;
	boolean memoryBool;
	boolean hourBool;
	boolean ramBool;
	boolean rightBool;
	boolean centerBool;
	boolean CPUBool;
	boolean TitleBool;
	boolean shortBool;
	boolean kilobytesBool;
	boolean threeBool;
	boolean fiveBool;
	boolean degreesFBool;
	String externalString;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.advanced_layout);
		//setting up checkboxes
		tapConfig = (CheckBox) findViewById(R.id.tapConfig);
		memoryGB = (CheckBox) findViewById(R.id.memoryGB);
		ramGB = (CheckBox) findViewById(R.id.ramGB);
		hourFormat = (CheckBox) findViewById(R.id.hourFormat);
		textLeft = (RadioButton) findViewById(R.id.textLeft);
		textRight = (RadioButton) findViewById(R.id.textRight);
		textCenter = (RadioButton) findViewById(R.id.textCenter);
		oneSec = (RadioButton) findViewById(R.id.oneSec);
		threeSec = (RadioButton) findViewById(R.id.threeSec);
		fiveSec = (RadioButton) findViewById(R.id.fiveSec);
		multiCPU = (CheckBox) findViewById(R.id.multiCPU);
		noCPUTitle = (CheckBox) findViewById(R.id.noCPUTitle);
		shortDays = (CheckBox) findViewById(R.id.shortDays);
		kilobytes = (CheckBox) findViewById(R.id.kilobyteSpeed);
		degreesF = (CheckBox) findViewById(R.id.degreesF);
		externalPath = (EditText) findViewById(R.id.externalPath);
		
		//getting preferences and setting checkbox values
		SharedPreferences prefs = this.getSharedPreferences("MyPrefs", 0);
		tapBool = prefs.getBoolean("TAPCONFIG", false);
		memoryBool = prefs.getBoolean("MEMORYGB", false);
		hourBool = prefs.getBoolean("24HOUR", false);
		ramBool = prefs.getBoolean("RAMGB", false);
		centerBool = prefs.getBoolean("TEXTCENTER", false);
		rightBool = prefs.getBoolean("TEXTRIGHT", false);
		CPUBool = prefs.getBoolean("MULTICPU", false);
		TitleBool = prefs.getBoolean("NOCPUTITLE", false);
		shortBool = prefs.getBoolean("SHORTDAYS", false);
		kilobytesBool = prefs.getBoolean("KILOBYTE", false);
		threeBool = prefs.getBoolean("THREESEC", false);
		fiveBool = prefs.getBoolean("FIVESEC", false);
		degreesFBool = prefs.getBoolean("DEGREESF", false);
		externalString = prefs.getString("EXTERNALPATH", "");
		
		if(tapBool == false)
		{
			tapConfig.setChecked(false);
		}
		else
		{
			tapConfig.setChecked(true);
		}
		if(memoryBool == false)
		{
			memoryGB.setChecked(false);
		}
		else
		{
			memoryGB.setChecked(true);
		}
		if(ramBool == false)
		{
			ramGB.setChecked(false);
		}
		else
		{
			ramGB.setChecked(true);
		}
		if(hourBool == false)
		{
			hourFormat.setChecked(false);
		}
		else
		{
			hourFormat.setChecked(true);
		}
		if(shortBool == false)
		{
			shortDays.setChecked(false);
		}
		else
		{
			shortDays.setChecked(true);
		}
		if(rightBool == false)
		{
			textRight.setChecked(false);
		}
		else
		{
			textRight.setChecked(true);
		}
		if(centerBool == false)
		{
			textCenter.setChecked(false);
		}
		else
		{
			textCenter.setChecked(true);
		}
		if(rightBool || centerBool)
		{
			textLeft.setChecked(false);
		}
		else
		{
			textLeft.setChecked(true);
		}
		if(CPUBool == false)
		{
			multiCPU.setChecked(false);
		}
		else
		{
			multiCPU.setChecked(true);
		}
		if(TitleBool == false)
		{
			noCPUTitle.setChecked(false);
		}
		else
		{
			noCPUTitle.setChecked(true);
		}
		if(kilobytesBool)
		{
			kilobytes.setChecked(true);
		}
		else
		{
			kilobytes.setChecked(false);
		}
		if(fiveBool == false)
		{
			fiveSec.setChecked(false);
		}
		else
		{
			fiveSec.setChecked(true);
		}
		if(threeBool == false)
		{
			threeSec.setChecked(false);
		}
		else
		{
			threeSec.setChecked(true);
		}
		if(fiveBool || threeBool)
		{
			oneSec.setChecked(false);
		}
		else
		{
			oneSec.setChecked(true);
		}
		if(degreesFBool)
		{
			degreesF.setChecked(true);
		}
		else
		{
			degreesF.setChecked(false);
		}
		if(externalString.contentEquals(""))
		{
			
		}
		else
		{
			externalPath.setText(externalString);
		}
	}
	
	public void saveConfig(View view)
	{
		//getting every config and putting it in an boolean
		tapBool = tapConfig.isChecked();
		memoryBool = memoryGB.isChecked();
		hourBool = hourFormat.isChecked();
		ramBool = ramGB.isChecked();
		rightBool = textRight.isChecked();
		centerBool = textCenter.isChecked();
		CPUBool = multiCPU.isChecked();
		TitleBool = noCPUTitle.isChecked();
		shortBool = shortDays.isChecked();
		kilobytesBool = kilobytes.isChecked();
		threeBool = threeSec.isChecked();
		fiveBool = fiveSec.isChecked();
		degreesFBool = degreesF.isChecked();
		externalString = externalPath.getText().toString();
		
		//putting values in preferences
		SharedPreferences prefs = this.getSharedPreferences("MyPrefs", 0);
		Editor editor = prefs.edit();
		editor.putBoolean("TAPCONFIG", tapBool);
		editor.putBoolean("MEMORYGB", memoryBool);
		editor.putBoolean("RAMGB", ramBool);
		editor.putBoolean("24HOUR", hourBool);
		editor.putBoolean("TEXTRIGHT", rightBool);
		editor.putBoolean("TEXTCENTER", centerBool);
		editor.putBoolean("MULTICPU", CPUBool);
		editor.putBoolean("NOCPUTITLE", TitleBool);
		editor.putBoolean("SHORTDAYS", shortBool);
		editor.putBoolean("KILOBYTE", kilobytesBool);
		editor.putBoolean("THREESEC", threeBool);
		editor.putBoolean("FIVESEC", fiveBool);
		editor.putBoolean("DEGREESF", degreesFBool);
		editor.putString("EXTERNALPATH", externalString);
		editor.commit();
		finish();
	}
	
	
}
