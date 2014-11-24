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

public class MCActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mc);
		ListView listView1 = (ListView) findViewById(R.id.listView1);
		 
		 String[] items = { 
				 "Fulfillment daily:\nDaily Science-Backed News for a Happier Life",
				 "Emma Seppala, Ph.D.\nThe science of happiness, health and social connection\nTake the guess work out of staying happy, healthy and fulfilled. Stay updated on the science of well-being. Subscribe to get a regular dose of data-driven insights into health and happiness.",
				 "Greater Good:\nThe science of a meaningful life\nThe Greater Good Science Center studies the psychology, sociology, and neuroscience of well-being, and teaches skills that foster a thriving, resilient, and compassionate society. Sign up to get the Greater Good Science Center's e-newsletters.",
				 "The Creativity Post:\nQuality content on creativity, innovation and imagination",
				 "Beautiful Minds:\nInsights into intelligence, creativity, and the mind",
				 "Hardwiring Happiness with Rick Hanson\nYou can have lasting, true happiness. Even in a life that is hard. This conference is about how to use the power of everyday experiences to build up important strengths and resources for yourself such as mindfulness, compassion, courage, curiosity, and love. Join neuropsychologist Rick Hanson as he interviews seven top-tier experts that will help you to learn how to face the brain’s negativity bias, take in the good, and hardwire happiness into your brain.",
				 "Yourstory:\nInspire. Innovate. Ignite. Indian Startups, Entrepreneurs, Founders, Stories, News, Resources, Research, Business Ideas, Product and App Reviews, Small Business"
		 };
		 
		 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				 R.layout.special_simple_list_item_1, items);
		 
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
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.fulfillmentdaily.com"));
	            		startActivity(intent);
	            		break;
	                case 1:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.emmaseppala.com"));
	            		startActivity(intent);
	            		break;
	                case 2:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://greatergood.berkeley.edu"));
	            		startActivity(intent);
	            		break;
	                case 3:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.creativitypost.com"));
	            		startActivity(intent);
	            		break;
	                case 4:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://blogs.scientificamerican.com/beautiful-minds/"));
	            		startActivity(intent);
	            		break;
	                case 5:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.entheos.com/Hardwiring-Happiness/Rick-Hanson"));
	            		startActivity(intent);
	            		break;
	                case 6:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://yourstory.com"));
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
		getMenuInflater().inflate(R.menu.mc, menu);
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
