package mg.shadesofhappiness;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class TAOLActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_taol);
		
		ListView listView1 = (ListView) findViewById(R.id.listView1);
		 
		 String[] items = { 
				 "Sri Sri",
				 "Wisdom by Sri Sri",
				 "Quotes by Sri Sri",
				 "Live Satsang with Sri Sri",
				 "Happiness with Sri Sri",				 
				 "Art of Living",
				 "Art of Living:Programs Centers",
				 "Ashram Guide",
				 "Blessings",
				 "Japa / Chanting",
				 "Personality Development Quotes",
				 "Relationships Tips"
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
	                	if(isAppInstalled("com.artofliving.srisrinews"))
	                		startActivity(getPackageManager().getLaunchIntentForPackage("com.artofliving.srisrinews"));
	                		else
	                		{
	                			intent = new Intent(Intent.ACTION_VIEW);
	                			intent.setData(Uri.parse("market://details?id=com.artofliving.srisrinews"));
	                			startActivity(intent);
	                		}
	            		break;
	                case 1:	 
	                	if(isAppInstalled("com.wisdombysrisri"))
	                		startActivity(getPackageManager().getLaunchIntentForPackage("com.wisdombysrisri"));
	                		else
	                		{
	                			intent = new Intent(Intent.ACTION_VIEW);
	                			intent.setData(Uri.parse("market://details?id=com.wisdombysrisri"));
	                			startActivity(intent);
	                		}
	            		break;
	                case 2:	  
	                	if(isAppInstalled("org.artofliving.srisriquotesapp"))
	                		startActivity(getPackageManager().getLaunchIntentForPackage("org.artofliving.srisriquotesapp"));
	                		else
	                		{
	                			intent = new Intent(Intent.ACTION_VIEW);
	                			intent.setData(Uri.parse("market://details?id=org.artofliving.srisriquotesapp"));
	                			startActivity(intent);
	                		}
	            		break;
	                case 3:	    
	                	if(isAppInstalled("com.satsang"))
	                		startActivity(getPackageManager().getLaunchIntentForPackage("com.satsang"));
	                		else
	                		{
	                			intent = new Intent(Intent.ACTION_VIEW);
	                			intent.setData(Uri.parse("market://details?id=com.satsang"));
	                			startActivity(intent);
	                		}
	            		break;
	                case 4:	 
	                	if(isAppInstalled("com.behappynow"))
	                		startActivity(getPackageManager().getLaunchIntentForPackage("com.behappynow"));
	                		else
	                		{
	                			intent = new Intent(Intent.ACTION_VIEW);
	                			intent.setData(Uri.parse("market://details?id=com.behappynow"));
	                			startActivity(intent);
	                		}
	            		break;
	                case 5:	   
	                	if(isAppInstalled("in.ndtv.artofliving"))
	                		startActivity(getPackageManager().getLaunchIntentForPackage("in.ndtv.artofliving"));
	                		else
	                		{
	                			intent = new Intent(Intent.ACTION_VIEW);
	                			intent.setData(Uri.parse("market://details?id=in.ndtv.artofliving"));
	                			startActivity(intent);
	                		}
	            		break;
	                case 6:	 
	                	if(isAppInstalled("com.programcenters"))
	                		startActivity(getPackageManager().getLaunchIntentForPackage("com.programcenters"));
	                		else
	                		{
	                			intent = new Intent(Intent.ACTION_VIEW);
	                			intent.setData(Uri.parse("market://details?id=com.programcenters"));
	                			startActivity(intent);
	                		}
	            		break;
	                case 7:	   
	                	if(isAppInstalled("org.artofliving.ashramguide"))
	                		startActivity(getPackageManager().getLaunchIntentForPackage("org.artofliving.ashramguide"));
	                		else
	                		{
	                			intent = new Intent(Intent.ACTION_VIEW);
	                			intent.setData(Uri.parse("market://details?id=org.artofliving.ashramguide"));
	                			startActivity(intent);
	                		}
	            		break;
	                case 8:	    
	                	if(isAppInstalled("org.artofliving.blessings"))
	                		startActivity(getPackageManager().getLaunchIntentForPackage("org.artofliving.blessings"));
	                		else
	                		{
	                			intent = new Intent(Intent.ACTION_VIEW);
	                			intent.setData(Uri.parse("market://details?id=org.artofliving.blessings"));
	                			startActivity(intent);
	                		}
	            		break;
	                case 9:	 
	                	if(isAppInstalled("japa.app"))
	                		startActivity(getPackageManager().getLaunchIntentForPackage("japa.app"));
	                		else
	                		{
	                			intent = new Intent(Intent.ACTION_VIEW);
	                			intent.setData(Uri.parse("market://details?id=japa.app"));
	                			startActivity(intent);
	                		}
	            		break;
	                case 10:	
	                	if(isAppInstalled("org.artofliving.personality"))
	                		startActivity(getPackageManager().getLaunchIntentForPackage("org.artofliving.personality"));
	                		else
	                		{
	                			intent = new Intent(Intent.ACTION_VIEW);
	                			intent.setData(Uri.parse("market://details?id=org.artofliving.personality"));
	                			startActivity(intent);
	                		}
	            		break;
	                case 11:	  
	                	if(isAppInstalled("org.artofliving.relationship"))
	                		startActivity(getPackageManager().getLaunchIntentForPackage("org.artofliving.relationship"));
	                		else
	                		{
	                			intent = new Intent(Intent.ACTION_VIEW);
	                			intent.setData(Uri.parse("market://details?id=org.artofliving.relationship"));
	                			startActivity(intent);
	                		}
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
		getMenuInflater().inflate(R.menu.taol, menu);
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
	
	private boolean isAppInstalled(String packageName) {
	    PackageManager pm = getPackageManager();
	    boolean installed = false;
	    try {
	       pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
	       installed = true;
	    } catch (PackageManager.NameNotFoundException e) {
	       installed = false;
	    }
	    return installed;
	}
}
