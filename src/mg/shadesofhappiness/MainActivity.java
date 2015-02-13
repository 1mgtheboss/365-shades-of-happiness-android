package mg.shadesofhappiness;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.oadx.khsz210697.AdListener;
import com.oadx.khsz210697.AdListener.AdType;
import com.oadx.khsz210697.MA;

public class MainActivity extends Activity {
	private ListView listView1;
	static final int PICK_CONTACT_REQUEST = 2;
	private MA ma;
	private AdListener smartwalladlistener=new AdListener() {
        
        @Override
        public void onSDKIntegrationError(String message) {
        //Here you will receive message from SDK if it detects any integration issue.
        	
        	
        }

        public void onSmartWallAdShowing() {
        // This will be called by SDK when it’s showing any of the SmartWall ad.
        }

        @Override
        public void onSmartWallAdClosed() {
        // This will be called by SDK when the SmartWall ad is closed.
        }

        @Override
        public void onAdError(String message) {
        //This will get called if any error occurred during ad serving.
        	
        	
        }
        @Override
		public void onAdCached(AdType arg0) {
		//This will get called when an ad is cached. 
		
		}
		 @Override
		public void noAdAvailableListener() {
		//this will get called when ad is not available 
			 
			 prepareAdMobInterstitial();
		
		}
     };
     
     private AdListener.MraidAdListener banneradlistener = new AdListener.MraidAdListener() {

         @Override
         public void onAdClickListener()
         {
         //This will get called when ad is clicked.
         }

         @Override
         public void onAdLoadedListener()
         {
         //This will get called when an ad has loaded.
         }

         @Override
         public void onAdLoadingListener()
         {
         //This will get called when a rich media ad is loading.
         }

         @Override
         public void onAdExpandedListner()
         {
         //This will get called when an ad is showing on a user's screen. This may cover the whole UI.
         }

         @Override
         public void onCloseListener()
         {
         //This will get called when an ad is closing/resizing from an expanded state.
         }

         @Override
         public void onErrorListener(String message)
         {
         //This will get called when any error has occurred. This will also get called if the SDK notices any integration mistakes.
        	 
        	 
         }
         @Override
          public void noAdAvailableListener() {
          //this will get called when ad is not available 
        	 
        	 prepareAdMobInterstitial();
    		
         }
    };
    
    private com.google.android.gms.ads.InterstitialAd interstitial;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		SOHOption sohoption_data[] = new SOHOption[]
				 {
				 new SOHOption(R.drawable.flower, "Call your happy buddy"),				 				 
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
			            	try{
			                switch(position)
			                {
			                case 1:
			                	Context context=MainActivity.this;
			                	SharedPreferences sP = context.getSharedPreferences(
			            		        getString(R.string.preference_happy_buddy), Context.MODE_PRIVATE);
			            		String number = sP.getString(getString(R.string.preference_happy_buddy_phone_number),"");
			            		intent = new Intent(Intent.ACTION_CALL);
			            		intent.setData(Uri.parse("tel:" + number));
			            		startActivity(intent);
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
			                	intent = new Intent(MainActivity.this, AboutActivity.class);
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
				 
				 if(ma==null)
						ma=new MA(this, smartwalladlistener, true);
				 ma.callSmartWallAd();
				 ma.call360Ad(this, 0, false, banneradlistener);

	}
	
	public void prepareAdMobInterstitial(){
		// Create the interstitial.
	    interstitial = new com.google.android.gms.ads.InterstitialAd(this);
	    interstitial.setAdUnitId("ca-app-pub-2738757694043962/2575577331");

	    interstitial.setAdListener(new com.google.android.gms.ads.AdListener() {
	        @Override
	        public void onAdLoaded() {
	          
	        	displayInterstitial();

	          
	        }
	        @Override
	        public void onAdFailedToLoad(int errorCode) {
	          
	        }
	    });
	    
	    

	    // Create ad request.
	    com.google.android.gms.ads.AdRequest adRequest = new com.google.android.gms.ads.AdRequest.Builder().build();
	    // Begin loading your interstitial.
	    interstitial.loadAd(adRequest);
		

	}
	
	// Invoke displayInterstitial() when you are ready to display an interstitial.
	  public void displayInterstitial() {
	    if (interstitial.isLoaded()) {
	      interstitial.show();
	    }
	  }
	  
	  @Override
		public void onBackPressed() {

		//Displaying Cached SmartWall Ad
		try {
		      ma.showCachedAd(this, AdType.smartwall);
		    } catch (Exception e) 
		     {
		      super.onBackPressed();
		     }
		}
	
	@Override
    protected void onStart() {
        super.onStart();
        
    }
	
	@Override
	protected void onResume() {
	    super.onResume();  
	    

	    Context context = this;
		 SharedPreferences sP = context.getSharedPreferences(
		         getString(R.string.preference_initial_setup), Context.MODE_PRIVATE);
		 int defaultValue = 0;
		 int iSCS=sP.getInt(getString(R.string.preference_initial_setup_completion_status),defaultValue);
		 if(iSCS!=100)
		 {
			 
				 
			 Intent intent = new Intent(this, InitialSetupActivity.class);
			 startActivity(intent);
		 }
		 
		 
		 
		 
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity_actions, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		
		if (id==R.id.action_change_happy_buddy)
		{
			
			addYourHappyBuddy(null);
			return true;
		}
		return super.onOptionsItemSelected(item);
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
        		
        		
            	
	        }
	    }
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
