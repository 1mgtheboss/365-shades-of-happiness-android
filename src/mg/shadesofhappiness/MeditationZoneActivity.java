package mg.shadesofhappiness;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class MeditationZoneActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_meditation_zone);
		
		WebView webview = new WebView(this);
		setContentView(webview);
		String content = "<html><body><center><i><br><br><a href=\"http://www.artofliving.org/in-en/8-tips-get-started-meditation\" style=\"text-decoration: none;\"><div style=\"background-color: #f5ab00;color: #ffffff;\">8 tips to get started with meditation</div></a><br><br><a href=\"http://www.artofliving.org/meditation\" style=\"text-decoration: none;\"><div style=\"background-color: #f5ab00;color: #ffffff;\">Meditation articles</div></a><br><br><a href=\"http://www.artofliving.org/online-guided-meditation\" style=\"text-decoration: none;\"><div style=\"background-color: #f5ab00;color: #ffffff;\">Free online guided meditation</div></a></i></center></body></html>";
		webview.loadData(content, "text/html", null);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.meditation_zone, menu);
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
