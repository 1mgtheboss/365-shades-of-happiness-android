package mg.shadesofhappiness;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class GDFActivity extends Activity {
	private static final String baseURl = "https://twitter.com";
	private static final String widgetInfo ="<a class=\"twitter-timeline\" href=\"https://twitter.com/Philanthropy\" data-widget-id=\"534720748456124417\">Loading ...</a><script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+\"://platform.twitter.com/widgets.js\";fjs.parentNode.insertBefore(js,fjs);}}(document,\"script\",\"twitter-wjs\");</script>";
	private WebView webview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gdf);
		 webview = new WebView(this);
		 setContentView(webview);
		 webview.getSettings().setDomStorageEnabled(true);
	     webview.getSettings().setJavaScriptEnabled(true);

	        
	}
	
	@Override
    protected void onResume() {
        super.onResume();
        webview.loadDataWithBaseURL(baseURl, widgetInfo, "text/html", "UTF-8", null);
        }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gd, menu);
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
