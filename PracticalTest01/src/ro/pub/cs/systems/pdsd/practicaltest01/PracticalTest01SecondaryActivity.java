package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01SecondaryActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_secondary);
		
		Intent intentFromParent = getIntent();
		String name = intentFromParent.getStringExtra("name");
		String phone = intentFromParent.getStringExtra("phone");
		String email = intentFromParent.getStringExtra("email");
		
		TextView textname= (TextView) findViewById(R.id.text_name);
		textname.setText(name);
		
		TextView textphone= (TextView) findViewById(R.id.text_phone);
		textphone.setText(phone);
		
		TextView textemail= (TextView) findViewById(R.id.text_email);
		textemail.setText(email);
		
		Button ok = (Button) findViewById(R.id.button_ok);
		ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intentToParent = new Intent();
				intentToParent.putExtra("ro.pub.cs.systems.pdsd.practicaltest01.res1", "OK");
				setResult(RESULT_OK, intentToParent);
				finish();
			}
		});
		
		Button cancel = (Button) findViewById(R.id.button_cancel);
		cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intentToParent = new Intent();
				intentToParent.putExtra("ro.pub.cs.systems.pdsd.practicaltest01.res2", "Cancel");
				setResult(RESULT_CANCELED, intentToParent);
				finish();
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_secondary, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
