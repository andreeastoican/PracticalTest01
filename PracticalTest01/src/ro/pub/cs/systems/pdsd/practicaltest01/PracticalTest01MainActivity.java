package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


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
        
        Button buttonIntent = (Button) findViewById(R.id.button_intent);
        
        buttonIntent.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(PracticalTest01MainActivity.this, PracticalTest01SecondaryActivity.class);
				intent.putExtra("name", name);
				intent.putExtra("email", email);
				intent.putExtra("phone", phone);
				startActivityForResult(intent, 2015);
			}
		});
        
        final EditText editText = (EditText) findViewById(R.id.edit_text);
        
        buttonName.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				press=1;
				editText.setHint("Name");
				editText.setText(name);
			}
		});
        
        buttonEmail.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				press=2;
				editText.setHint("Email");
				editText.setText(email);
			}
		});
        
        buttonPhone.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				press=3;
				editText.setHint("Phone");
				editText.setText(phone);
			}
		});
        
        editText.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if(press==1) {
					name=s.toString();
				} else if(press==2) {
					email=s.toString();
				} else if(press==3) {
					phone=s.toString();
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
		});
        
    }
    
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    	  switch(requestCode) {
    	    case 2015:
    	      if (resultCode == Activity.RESULT_OK) {
    	        String data = intent.getStringExtra("ro.pub.cs.systems.pdsd.practicaltest01.res1");
    	        Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
    	      } else {
    	    	String data = intent.getStringExtra("ro.pub.cs.systems.pdsd.practicaltest01.res2");
    	    	Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
    	      }
    	      break;
    	 
    	  }
    	}
    
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
      super.onSaveInstanceState(savedInstanceState);
      
      EditText edit1 = (EditText)findViewById(R.id.edit_text);
      savedInstanceState.putString("EditText", edit1.getText().toString());
      
      
      savedInstanceState.putString("name", name);
      savedInstanceState.putString("email", email);
      savedInstanceState.putString("phone", phone);
      savedInstanceState.putString("press", press+"");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
      super.onRestoreInstanceState(savedInstanceState);
      
      EditText edit1= (EditText)findViewById(R.id.edit_text);
      if (savedInstanceState.getString("EditText") != null) {
          edit1.setText(savedInstanceState.getString("EditText"));
      }
      
      name = savedInstanceState.getString("name");
      email = savedInstanceState.getString("email");
      phone = savedInstanceState.getString("phone");
      press = Integer.parseInt(savedInstanceState.getString("press"));
    
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
