package mg.shadesofhappiness;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class InitialSetupActivity extends Activity {
	static final int PICK_CONTACT_REQUEST = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_initial_setup);
	}
	
	@Override
	public void onResume() {
	    super.onResume();  

	    Context context = this;
		SharedPreferences sP = context.getSharedPreferences(
		        getString(R.string.preference_initial_setup), Context.MODE_PRIVATE);
		int oldValue = sP.getInt(getString(R.string.preference_initial_setup_completion_status),0);
		
		
		if(oldValue==100)
		{
			Intent intent = new Intent(this, MainActivity.class);
		 	startActivity(intent);
		}
	}
	
	public void iWantToSkipThisStep(View view) {
		Context context = this;
		SharedPreferences sP = context.getSharedPreferences(
		        getString(R.string.preference_initial_setup), Context.MODE_PRIVATE);
		
		int newValue=100;
		SharedPreferences.Editor editor = sP.edit();
		editor.putInt(getString(R.string.preference_initial_setup_completion_status), newValue);
		editor.commit();
		
		Intent intent = new Intent(this, MainActivity.class);
	 	startActivity(intent);
	    
	}
	
	public void addYourHappyBuddy(View view) {
	    Intent pickContactIntent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
	    pickContactIntent.setType(Phone.CONTENT_TYPE); // Show user only contacts with phone numbers
	    startActivityForResult(pickContactIntent, PICK_CONTACT_REQUEST);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    // Check which request we're responding to
	    if (requestCode == PICK_CONTACT_REQUEST) {
	        // Make sure the request was successful
	        if (resultCode == RESULT_OK) {
	            // The user picked a contact.
	            // The Intent's data Uri identifies which contact was selected.

	            // Do something with the contact here 
	        	// Get the URI that points to the selected contact
	            Uri contactUri = data.getData();
	            // We only need the NUMBER column, because there will be only one row in the result
	            String[] projection = {Phone.NUMBER};

	            // Perform the query on the contact to get the NUMBER column
	            // We don't need a selection or sort order (there's only one result for the given URI)
	            // CAUTION: The query() method should be called from a separate thread to avoid blocking
	            // your app's UI thread. (For simplicity of the sample, this code doesn't do that.)
	            // Consider using CursorLoader to perform the query.
	            Cursor cursor = getContentResolver()
	                    .query(contactUri, projection, null, null, null);
	            cursor.moveToFirst();

	            // Retrieve the phone number from the NUMBER column
	            int column = cursor.getColumnIndex(Phone.NUMBER);
	            String number = cursor.getString(column);

	            // Do something with the phone number...
	            Context context = getApplicationContext();
            	CharSequence text = number;
            	int duration = Toast.LENGTH_SHORT;

            	Toast toast = Toast.makeText(context, text, duration);
            	toast.show();
            	
            	SharedPreferences sPHB = context.getSharedPreferences(
        		        getString(R.string.preference_happy_buddy), Context.MODE_PRIVATE);
        		
            	
        		
        		SharedPreferences.Editor editorHB = sPHB.edit();
        		editorHB.putString(getString(R.string.preference_happy_buddy_phone_number), number);
        		editorHB.commit();
        		
        		SharedPreferences sP = context.getSharedPreferences(
        		        getString(R.string.preference_initial_setup), Context.MODE_PRIVATE);
        		
        		int newValue=100;
        		SharedPreferences.Editor editor = sP.edit();
        		editor.putInt(getString(R.string.preference_initial_setup_completion_status), newValue);
        		editor.commit();
        		
        		if(newValue==100)
        		{
        			Intent intent = new Intent(this, MainActivity.class);
        		 	startActivity(intent);
        		}
            	
	        }
	    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.initial_setup, menu);
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
