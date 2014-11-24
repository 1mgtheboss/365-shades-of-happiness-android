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
import android.widget.ListView;

public class MainActivity extends Activity {
	private ListView listView1;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		SOHOption sohoption_data[] = new SOHOption[]
				 {
				 new SOHOption(R.drawable.flower, "Happy diary"),				 				 
				 new SOHOption(R.drawable.flower, "Laughing club"),
				 new SOHOption(R.drawable.flower, "Meditation zone"),
				 new SOHOption(R.drawable.flower, "Positive psychology exercises"),
				 new SOHOption(R.drawable.flower, "Info on events, groups etc."),
				 new SOHOption(R.drawable.flower, "Play an awesome game"),
				 new SOHOption(R.drawable.flower, "Open a company"),
				 new SOHOption(R.drawable.flower, "Donate"),
				 new SOHOption(R.drawable.flower, "Quotes"),
				 new SOHOption(R.drawable.flower, "Good deed feed"),				 				 
				 new SOHOption(R.drawable.flower, "Comedy"),
				 new SOHOption(R.drawable.flower, "The Art of Living"),
				 new SOHOption(R.drawable.flower, "Magazine corner"),
		         new SOHOption(R.drawable.flower, "About")
				 };
				 
				 SOHOptionAdapter adapter = new SOHOptionAdapter(this,
				 R.layout.listview_item_row, sohoption_data);
				 
				 
				 listView1 = (ListView)findViewById(R.id.listView1);
				 
				 View header =
				(View)getLayoutInflater().inflate(R.layout.listview_header_row, null);
				 listView1.addHeaderView(header);
				 
				 listView1.setAdapter(adapter);
				 
				 listView1.setOnItemClickListener(new OnItemClickListener() {
			            @Override
			            public void onItemClick(AdapterView<?> parent, View view, int position,
			                    long id) {
			            	//Toast.makeText(getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
			            	Intent intent;
			                switch(position)
			                {
			                case 1:
			                	break;
			                case 2:
			                	intent = new Intent(MainActivity.this, LCActivity.class);
			            		startActivity(intent);
			                	break;
			                case 3:
			                	intent = new Intent(MainActivity.this, MeditationZoneActivity.class);
			            		startActivity(intent);
			                	break;
			                case 4:
			                	intent = new Intent(MainActivity.this, PPEsActivity.class);
			            		startActivity(intent);
			                	break;
			                case 5:
			                	intent = new Intent(MainActivity.this, InfoOnEGEActivity.class);
			            		startActivity(intent);
			                	break;
			                case 6:
			                	if(isAppInstalled("gamook.apps.toro"))
			                		startActivity(getPackageManager().getLaunchIntentForPackage("gamook.apps.toro"));
			                		else
			                		{
			                			intent = new Intent(Intent.ACTION_VIEW);
			                			intent.setData(Uri.parse("market://details?id=gamook.apps.toro"));
			                			startActivity(intent);
			                		}
			                	break;
			                case 7:
			                	intent = new Intent(MainActivity.this, OACActivity.class);
			            		startActivity(intent);
			                	break;
			                case 8:
			                	intent = new Intent(MainActivity.this, DonateActivity.class);
			            		startActivity(intent);
			                	break;
			                case 9:
			                	intent = new Intent(MainActivity.this, QuotesActivity.class);
			            		startActivity(intent);
			                	break;
			                case 10:
			                	intent = new Intent(MainActivity.this, GDFActivity.class);
			            		startActivity(intent);
			                	break;
			                case 11:
			                	intent = new Intent(MainActivity.this, ComedyActivity.class);
			            		startActivity(intent);
			                	break;
			                case 12:
			                	intent = new Intent(MainActivity.this, TAOLActivity.class);
			            		startActivity(intent);
			                	break;
			                case 13:
			                	intent = new Intent(MainActivity.this, MCActivity.class);
			            		startActivity(intent);
			                	break;
			                case 14:
			                	break;
			                }
			                
			            }
			        });

	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
