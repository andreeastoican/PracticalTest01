package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class PracticalTest01MainActivity extends Activity {

	String name="";
    String phone="";
    String email="";
    int press=0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);
        
        Button buttonName= (Button) findViewById(R.id.button_name);
        Button buttonEmail= (Button) findViewById(R.id.button_email);
        Button buttonPhone= (Button) findViewById(R.id.button_phone);
        
        final EditText editText = (EditText) findViewById(R.id.edit_text);
        
        buttonName.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				press=1;
				if(name=="") {
					editText.setHint("Name");
				} else {
					editText.setText(name);
				}
			}
		});
        
        buttonEmail.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				press=2;
				if(email=="") {
					editText.setHint("Email");
				} else {
					editText.setText(email);
				}
			}
		});
        
        buttonPhone.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				press=3;
				if(phone=="") {
					editText.setHint("Phone");
				} else {
					editText.setText(phone);
				}
			}
		});
        
        editText.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if(press==1) {
					name=editText.getText().toString();
				} else if(press==2) {
					email=editText.getText().toString();
				} else if(press==3) {
					phone=editText.getText().toString();
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		})
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_main, menu);
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
