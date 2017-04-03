package com.amnix.supportme;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class supportme_activity_main_amnix extends Activity implements OnClickListener{

	Button b1,b2,b3,b4;
	int i;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.support_activity);
		b1 = (Button)findViewById(R.id.button1);
		b2 = (Button)findViewById(R.id.button2);
		b3 = (Button)findViewById(R.id.button3);
		b4 = (Button)findViewById(R.id.button4);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
	}
	
	
	@Override
	public void onClick(View z) {
		if(z == findViewById(R.id.button1))
		{
			try {
				Toast.makeText(getApplicationContext(), "Use Browser which support javascript and flash.\nI recommand Google Chrome", Toast.LENGTH_LONG).show();
				opensupporturl();
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "No Browser Found!\nPlease Install a Browser from Playstore.", Toast.LENGTH_LONG).show();
			}
			
		}
		else if(z == findViewById(R.id.button2))
		{
			Toast.makeText(getApplicationContext(), "Well! It's Ok!\nThanks to like my work\nEnjoy!\n\nExisting..!!!", Toast.LENGTH_LONG).show();
			finish();
		}
		else if(z == findViewById(R.id.button3))
		{
			Toast.makeText(getApplicationContext(), "Then just enjoy buddy!\n\nExisting..!!!", Toast.LENGTH_LONG).show();
			finish();
		}
		else if(z == findViewById(R.id.button4))
		{
			ViewDonatioURL();
		}
	}
@Override
public boolean onCreateOptionsMenu(Menu menu) {
	MenuInflater menuInflater = getMenuInflater();
	menuInflater.inflate(R.menu.amnixmenu, menu);
	return super.onCreateOptionsMenu(menu);
	}
@Override
public boolean onOptionsItemSelected(MenuItem item) {

	switch(item.getItemId())
	{
		case(R.id.menuitem1):
		AlertDialog.Builder a1 = new AlertDialog.Builder(this);
		a1.setTitle("About!");
		a1.setIcon(R.drawable.ic_launcher);
		a1.setMessage("This app is developed by \"AmniX\"\nAny developer can use this app without asking me But,\nJust give me a little credit on your respected thread.\nAnd if you like my work then also buy a coffee for me too!\nCheers\n-AmniX");
		a1.setPositiveButton("Donate \nto AmniX", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				donatetoamnix();
				
			}
		});
		a1.setNeutralButton("View\nsources", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				sources();
			}
		} );
		a1.setNegativeButton("Xda\nthread", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(getApplicationContext(), "Coming Soon", Toast.LENGTH_LONG).show();
				
			}
		});
		a1.show();
	}
	return super.onOptionsItemSelected(item);
	
}
private void opensupporturl() {
	String supporturl = "http://forum.xda-developers.com/donatetome.php?u=";
	String donateID = getResources().getString(R.string.xda_Paypal_ID);
	Intent openbrowser = new Intent(Intent.ACTION_VIEW);
	openbrowser.setData(Uri.parse(supporturl+donateID));
	startActivity(openbrowser);
}

private void donatetoamnix() {
	String amnixpaypalurl = "http://forum.xda-developers.com/donatetome.php?u=4729939";
	Intent openbrowser = new Intent(Intent.ACTION_VIEW);
	openbrowser.setData(Uri.parse(amnixpaypalurl));
	startActivity(openbrowser);
}
private void sources() {
	String sourcesurl = "https://www.github.com";
	Intent openbrowser = new Intent(Intent.ACTION_VIEW);
	openbrowser.setData(Uri.parse(sourcesurl));
	startActivity(openbrowser);
}
private void ViewDonatioURL() {
	AlertDialog.Builder t2 = new AlertDialog.Builder(this);
	String supporturl = "http://forum.xda-developers.com/donatetome.php?u=";
	String donateID = getResources().getString(R.string.xda_Paypal_ID);
	t2.setTitle("Donation URL");
	t2.setMessage(supporturl+donateID);
	t2.show();

}
}