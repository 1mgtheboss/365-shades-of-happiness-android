package mg.shadesofhappiness;

import com.oadx.khsz210697.AdListener;
import com.oadx.khsz210697.MA;
import com.oadx.khsz210697.AdListener.AdType;

import android.app.Activity;
import android.content.Intent;
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

public class DonateActivity extends Activity {
	
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
	
	
    public void prepareAdMobInterstitial(){
		// Create the interstitial.
	    interstitial = new com.google.android.gms.ads.InterstitialAd(this);
	    interstitial.setAdUnitId("ca-app-pub-2738757694043962/5249842131");

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
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_donate);
		
		ListView listView1 = (ListView) findViewById(R.id.listView1);
		 
		 String[] items = { 
				 "The Art of Living",				 
				 "Stichting INGKA Foundation",
				 "Bill & Melinda Gates Foundation",
				 "Wellcome Trust",
				 "Howard Hughes Medical Institute",
				 "Ford Foundation",
				 "J. Paul Getty Trust",
				 "Mohammed bin Rashid Al Maktoum Foundation",
				 "Robert Wood Johnson Foundation",
				 "Li Ka Shing Foundation",
				 "The Church Commissioners for England",
				 "William and Flora Hewlett Foundation",
				 "Kamehameha Schools",
				 "Lilly Endowment",
				 "W.K. Kellogg Foundation",
				 "Robert Bosch Foundation",
				 "Garfield Weston Foundation",
				 "David and Lucile Packard Foundation",
				 "John D. and Catherine T. MacArthur Foundation",
				 "The Pew Charitable Trusts",
				 "Gordon and Betty Moore Foundation",
				 "Knut and Alice Wallenberg Foundation",
				 "Andrew W. Mellon Foundation",
				 "The MasterCard Foundation",
				 "William Penn Foundation",
				 "The Leona M. and Harry B. Helmsley Charitable Trust",
				 "Tulsa Community Foundation",
				 "The California Endowment",
				 "Rockefeller Foundation",
				 "Realdania",
				 "Calouste Gulbenkian Foundation",
				 "The Kresge Foundation",
				 "The Greater Good Science Center",
				 "Dr Porges Research Fund at UNC"
				 
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
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.artofliving.org"));
	            		startActivity(intent);
	            		break;
	                case 1:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ikeafoundation.org"));
	            		startActivity(intent);
	            		break;
	                case 2:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gatesfoundation.org"));
	            		startActivity(intent);
	            		break;
	                case 3:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.wellcome.ac.uk"));
	            		startActivity(intent);
	            		break;
	                case 4:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.hhmi.org"));
	            		startActivity(intent);
	            		break;
	                case 5:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.fordfoundation.org"));
	            		startActivity(intent);
	            		break;
	                case 6:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.getty.edu"));
	            		startActivity(intent);
	            		break;
	                case 7:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mbrfoundation.ae/en/Pages/default.aspx"));
	            		startActivity(intent);
	            		break;
	                case 8:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.rwjf.org"));
	            		startActivity(intent);
	            		break;
	                case 9:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.lksf.org/en"));
	            		startActivity(intent);
	            		break;
	                case 10:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.churchofengland.org/about-us/structure/churchcommissioners.aspx"));
	            		startActivity(intent);
	            		break;
	                case 11:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.hewlett.org"));
	            		startActivity(intent);
	            		break;
	                case 12:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ksbe.edu"));
	            		startActivity(intent);
	            		break;
	                case 13:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.lillyendowment.org"));
	            		startActivity(intent);
	            		break;
	                case 14:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.wkkf.org"));
	            		startActivity(intent);
	            		break;
	                case 15:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bosch-stiftung.de/content/language2/html/index.asp"));
	            		startActivity(intent);
	            		break;
	                case 16:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.garfieldweston.org"));
	            		startActivity(intent);
	            		break;
	                case 17:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.packard.org"));
	            		startActivity(intent);
	            		break;
	                case 18:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.macfound.org"));
	            		startActivity(intent);
	            		break;
	                case 19:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.pewtrusts.org"));
	            		startActivity(intent);
	            		break;
	                case 20:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.moore.org"));
	            		startActivity(intent);
	            		break;
	                case 21:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.wallenberg.com/kaw/en"));
	            		startActivity(intent);
	            		break;
	                case 22:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mellon.org"));
	            		startActivity(intent);
	            		break;
	                case 23:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mastercardfdn.org"));
	            		startActivity(intent);
	            		break;
	                case 24:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.williampennfoundation.org"));
	            		startActivity(intent);
	            		break;
	                case 25:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://helmsleytrust.org"));
	            		startActivity(intent);
	            		break;
	                case 26:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.tulsacf.org"));
	            		startActivity(intent);
	            		break;
	                case 27:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.calendow.org"));
	            		startActivity(intent);
	            		break;
	                case 28:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.rockefellerfoundation.org"));
	            		startActivity(intent);
	            		break;
	                case 29:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.realdania.org"));
	            		startActivity(intent);
	            		break;
	                case 30:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.gulbenkian.org.uk"));
	            		startActivity(intent);
	            		break;
	                case 31:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://kresge.org"));
	            		startActivity(intent);
	            		break;
	                case 32:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://greatergood.berkeley.edu"));
	            		startActivity(intent);
	            		break;
	                case 33:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://stephenporges.com/index.php/donate-to-dr-porgess-research"));
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
		 ma.call360Ad(this, 6, false, banneradlistener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.donate, menu);
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
