package mg.shadesofhappiness;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ComedyActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_comedy);
		
		ListView listView1 = (ListView) findViewById(R.id.listView1);
		 
		 String[] items = { 
				 "theCHIVE",
				 "Cracked",
				 "Break",
				 "eBaumsWorld",
				 "FunnyorDIE",
				 "Cheezburger",
				 "QuickMeme",
				 "CollegeHumor",
				 "theOnion",
				 "9GAG",
				 "FunnyJunk",
				 "Smosh",
				 "XKCD",
				 "Fark",
				 "TheOatmeal"
		 };
		 
		 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		 android.R.layout.simple_list_item_1, items);
		 
		 listView1.setAdapter(adapter);
		 listView1.setOnItemClickListener(new OnItemClickListener() {
	            @Override
	            public void onItemClick(AdapterView<?> parent, View view, int position,
	                    long id) {
	            	Intent intent;
	                try{
	                switch(position)
	                {
	                
	                case 0:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://thechive.com"));
	            		startActivity(intent);
	            		break;
	                case 1:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cracked.com"));
	            		startActivity(intent);
	            		break;
	                case 2:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.break.com"));
	            		startActivity(intent);
	            		break;
	                case 3:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ebaumsworld.com"));
	            		startActivity(intent);
	            		break;
	                case 4:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.funnyordie.com"));
	            		startActivity(intent);
	            		break;
	                case 5:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cheezburger.com"));
	            		startActivity(intent);
	            		break;
	                case 6:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.quickmeme.com"));
	            		startActivity(intent);
	            		break;
	                case 7:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.collegehumor.com"));
	            		startActivity(intent);
	            		break;
	                case 8:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.theonion.com"));
	            		startActivity(intent);
	            		break;
	                case 9:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://9gag.com"));
	            		startActivity(intent);
	            		break;
	                case 10:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.funnyjunk.com"));
	            		startActivity(intent);
	            		break;
	                case 11:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.smosh.com"));
	            		startActivity(intent);
	            		break;
	                case 12:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.xkcd.com"));
	            		startActivity(intent);
	            		break;
	                case 13:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.fark.com"));
	            		startActivity(intent);
	            		break;
	                case 14:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://theoatmeal.com"));
	            		startActivity(intent);
	            		break;
	            		
	                
	                
	                	
	                }
	                }
	                catch(Exception e)
	                {
	                	Toast.makeText(getApplicationContext(), "Something went wrong...", Toast.LENGTH_SHORT).show();
	                }
	                
	            }
	        });

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.comedy, menu);
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
