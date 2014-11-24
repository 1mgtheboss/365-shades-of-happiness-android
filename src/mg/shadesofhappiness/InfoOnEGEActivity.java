package mg.shadesofhappiness;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

public class InfoOnEGEActivity extends Activity implements OnClickListener{
	private EditText mET;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info_on_ege);
		
		findViewById(R.id.button1).setOnClickListener(this);
		findViewById(R.id.button2).setOnClickListener(this);
		findViewById(R.id.button3).setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		try{
			Intent intent=new Intent(Intent.ACTION_WEB_SEARCH);
            
            mET=(EditText)findViewById(R.id.editText1);
            String sP=mET.getText().toString();
		switch (v.getId()) {

		
		case R.id.button1:
			sP+=" events";
			intent.putExtra(SearchManager.QUERY, sP);
    		startActivity(intent);
			break;
		case R.id.button2:
			sP+=" groups";
			intent.putExtra(SearchManager.QUERY, sP);
    		startActivity(intent);
			break;
		case R.id.button3:
			sP+=" forums";
			intent.putExtra(SearchManager.QUERY, sP);
    		startActivity(intent);
			break;
		}
		}
		catch(Exception e)
		{
			Toast.makeText(getApplicationContext(), "Something went wrong...", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.info_on_ege, menu);
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
