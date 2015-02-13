package mg.shadesofhappiness;


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

import com.oadx.khsz210697.AdListener;
import com.oadx.khsz210697.AdListener.AdType;
import com.oadx.khsz210697.MA;

public class OACActivity extends Activity {
	
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
	    interstitial.setAdUnitId("ca-app-pub-2738757694043962/3773108937");

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
		setContentView(R.layout.activity_oac);
		
		ListView listView1 = (ListView) findViewById(R.id.listView1);

		 String[] items = { "Inspiring quotes:", 
				 "... my #1, 2, and 3 lessons are all the same: NEVER give up!\n___Prita Uppal", 
				 "Nobody will care as much, feel the pain as much, or have to deal with as much. This means you have to be SO tough and ready for the fight.\n___Prita Uppal",
				 "Hard work and determination in everything pays off...\n___Prita Uppal",
				 "The more you give the more you get.\n___Mark Peter Davis",
				 "Say what you're going to do and do what you say.\n___Mark Peter Davis",
				 "Nothing is business and everything is business, if you're in the right business.\n___Mark Peter Davis",
				 "If you want to be a successful leader you need these three skills: you have to be a good listener, you have to understand people, you have to know how to communicate a vision.\n___Mark Peter Davis",
				 "However big or small, make it a good business, make it a clean business, make it a business you are very proud of.\n___Deep Kalra",
				 "Important websites:",
				 "Fortune",
				 "Inc.",
				 "Business Insider",
				 "Forbes",
				 "Entrepreneur",
				 "AngelList",
				 "FuturePerfect Ventures",
				 "Interplay Ventures",
				 "Gotham Ventures",
				 "Trinity Ventures",
				 "Yourstory",
				 "Important books:",
				 "The Fundraising Rules by Mark Peter Davis",
				 "Choose Yourself by James Altucher",
				 "Rework by Jason Fried, David Heinemeier Hansson",
				 "Purple Cow: Transform Your Business by Being Remarkable by Seth Godin",
				 "The 7 Habits of Highly Effective People: Powerful Lessons in Personal Change by Stephen R. Covey",
				 "Tribes: We Need You to Lead Us by Seth Godin",
				 "Meditations by Marcus Aurelius, Martin Hammond (Translator, Notes), Diskin Clay",
				 "Creative Confidence: Unleashing the Creative Potential Within Us All by Tom Kelley, David Kelley",
				 "To Sell Is Human: The Surprising Truth About Moving Others by Daniel H. Pink",
				 "The Slight Edge: Secret to a Successful Life by Jeff Olson",
				 "The 4-Hour Work Week by Timothy Ferriss"
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
	                case 10:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://fortune.com/"));
	            		startActivity(intent);
	            		break;
	                case 11:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.inc.com/"));
	            		startActivity(intent);
	            		break;
	                case 12:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.businessinsider.com/"));
	            		startActivity(intent);
	            		break;
	                case 13:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.forbes.com/"));
	            		startActivity(intent);
	            		break;
	                case 14:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.entrepreneur.com/"));
	            		startActivity(intent);
	            		break;
	                case 15:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://angel.co/"));
	            		startActivity(intent);
	            		break;
	                case 16:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://futureperfectventures.com/"));
	            		startActivity(intent);
	            		break;
	                case 17:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.interplay.vc/"));
	            		startActivity(intent);
	            		break;
	                case 18:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://gothamvc.com/"));
	            		startActivity(intent);
	            		break;
	                case 19:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.trinityventures.com/"));
	            		startActivity(intent);
	            		break;
	                case 20:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://yourstory.com/"));
	            		startActivity(intent);
	            		break;
	                case 22:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.goodreads.com/book/show/18188476-the-fundraising-rules"));
	            		startActivity(intent);
	            		break;
	                case 23:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.goodreads.com/book/show/17977529-choose-yourself"));
	            		startActivity(intent);
	            		break;
	                case 24:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.goodreads.com/book/show/6732019-rework"));
	            		startActivity(intent);
	            		break;
	                case 25:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.goodreads.com/book/show/641604.Purple_Cow"));
	            		startActivity(intent);
	            		break;
	                case 26:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.goodreads.com/book/show/36072.The_7_Habits_of_Highly_Effective_People"));
	            		startActivity(intent);
	            		break;
	                case 27:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.goodreads.com/book/show/3828382-tribes"));
	            		startActivity(intent);
	            		break;
	                case 28:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.goodreads.com/book/show/30659.Meditations"));
	            		startActivity(intent);
	            		break;
	                case 29:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.goodreads.com/book/show/17288649-creative-confidence"));
	            		startActivity(intent);
	            		break;
	                case 30:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.goodreads.com/book/show/13593553-to-sell-is-human"));
	            		startActivity(intent);
	            		break;
	                case 31:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.goodreads.com/book/show/590652.The_Slight_Edge"));
	            		startActivity(intent);
	            		break;
	                case 32:
	                	intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.goodreads.com/book/show/368593.The_4_Hour_Work_Week"));
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
		 ma.call360Ad(this, 5, false, banneradlistener);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.oac, menu);
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
