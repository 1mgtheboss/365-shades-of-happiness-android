package mg.shadesofhappiness;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class OACActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_oac);
		
		WebView webview = new WebView(this);
		setContentView(webview);
		String content = "<html><body><i><div style=\"background-color: #f5ab00;color: #ffffff;font-size: 200%;\"><b>Inspiring quotes:</b></div><br><p style=\"padding-left:20px\">\"... my #1, 2, and 3 lessons are all the same: NEVER give up!\"<br>Prita Uppal<br>\"Nobody will care as much, feel the pain as much, or have to deal with as much. This means you have to be SO tough and ready for the fight.\"<br>Prita Uppal<br>\"Hard work and determination in everything pays off...\"<br>Prita Uppa<br>\"The more you give the more you get.\"<br>Mark Peter Davis<br>\"Say what you're going to do and do what you say.\"<br>Mark Peter Davis<br>\"Nothing is business and everything is business, if you're in the right business.\"<br>Mark Peter Davis<br>If you want to be a successful leader you need these three skills: you have to be a good listener, you have to understand people, you have to know how to communicate a vision.<br>Mark Peter Davis<br>\"However big or small, make it a good business, make it a clean business, make it a business you are very proud of.\"<br>Deep Kalra</p><br><div style=\"background-color: #f5ab00;color: #ffffff;font-size: 200%;\"><b>Important websites:</b></div><br><a href=\"http://fortune.com/\" style=\"text-decoration: none;\"><div style=\"background-color: #f5ab00;color: #ffffff;\">Fortune</div></a><br><a href=\"http://www.inc.com/\" style=\"text-decoration: none;\"><div style=\"background-color: #f5ab00;color: #ffffff;\">Inc.</div></a><br><a href=\"http://www.businessinsider.com/\" style=\"text-decoration: none;\"><div style=\"background-color: #f5ab00;color: #ffffff;\">Business Insider</div></a><br><a href=\"http://www.forbes.com/\" style=\"text-decoration: none;\"><div style=\"background-color: #f5ab00;color: #ffffff;\">Forbes</div></a><br><a href=\"http://www.entrepreneur.com/\" style=\"text-decoration: none;\"><div style=\"background-color: #f5ab00;color: #ffffff;\">Entrepreneur</div></a><br><a href=\"https://angel.co/\" style=\"text-decoration: none;\"><div style=\"background-color: #f5ab00;color: #ffffff;\">AngelList</div></a><br><a href=\"http://futureperfectventures.com/\" style=\"text-decoration: none;\"><div style=\"background-color: #f5ab00;color: #ffffff;\">FuturePerfect Ventures</div></a><br><a href=\"http://www.interplay.vc/\" style=\"text-decoration: none;\"><div style=\"background-color: #f5ab00;color: #ffffff;\">Interplay Ventures</div></a><br><a href=\"http://gothamvc.com/\" style=\"text-decoration: none;\"><div style=\"background-color: #f5ab00;color: #ffffff;\">Gotham Ventures</div></a><br><a href=\"http://www.trinityventures.com/\" style=\"text-decoration: none;\"><div style=\"background-color: #f5ab00;color: #ffffff;\">Trinity Ventures</div></a><br><a href=\"http://yourstory.com/\" style=\"text-decoration: none;\"><div style=\"background-color: #f5ab00;color: #ffffff;\">Yourstory</div></a><br><div style=\"background-color: #f5ab00;color: #ffffff;font-size: 200%;\"><b>Important books:</b></div><br><a href=\"http://www.goodreads.com/book/show/18188476-the-fundraising-rules\" style=\"text-decoration: none;\"><div style=\"background-color: #f5ab00;color: #ffffff;\">The Fundraising Rules by Mark Peter Davis</div></a><br><a href=\"http://www.goodreads.com/book/show/17977529-choose-yourself\" style=\"text-decoration: none;\"><div style=\"background-color: #f5ab00;color: #ffffff;\">Choose Yourself by James Altucher</div></a><br><a href=\"http://www.goodreads.com/book/show/6732019-rework\" style=\"text-decoration: none;\"><div style=\"background-color: #f5ab00;color: #ffffff;\">Rework by Jason Fried, David Heinemeier Hansson</div></a><br><a href=\"http://www.goodreads.com/book/show/641604.Purple_Cow\" style=\"text-decoration: none;\"><div style=\"background-color: #f5ab00;color: #ffffff;\">Purple Cow: Transform Your Business by Being Remarkable by Seth Godin</div></a><br><a href=\"http://www.goodreads.com/book/show/36072.The_7_Habits_of_Highly_Effective_People\" style=\"text-decoration: none;\"><div style=\"background-color: #f5ab00;color: #ffffff;\">The 7 Habits of Highly Effective People: Powerful Lessons in Personal Change by Stephen R. Covey</div></a><br><a href=\"http://www.goodreads.com/book/show/3828382-tribes\" style=\"text-decoration: none;\"><div style=\"background-color: #f5ab00;color: #ffffff;\">Tribes: We Need You to Lead Us by Seth Godin</div></a><br><a href=\"http://www.goodreads.com/book/show/30659.Meditations\" style=\"text-decoration: none;\"><div style=\"background-color: #f5ab00;color: #ffffff;\">Meditations by Marcus Aurelius, Martin Hammond (Translator, Notes), Diskin Clay</div></a><br><a href=\"http://www.goodreads.com/book/show/17288649-creative-confidence\" style=\"text-decoration: none;\"><div style=\"background-color: #f5ab00;color: #ffffff;\">Creative Confidence: Unleashing the Creative Potential Within Us All by Tom Kelley, David Kelley</div></a><br><a href=\"http://www.goodreads.com/book/show/13593553-to-sell-is-human\" style=\"text-decoration: none;\"><div style=\"background-color: #f5ab00;color: #ffffff;\">To Sell Is Human: The Surprising Truth About Moving Others by Daniel H. Pink</div></a><br><a href=\"http://www.goodreads.com/book/show/590652.The_Slight_Edge\" style=\"text-decoration: none;\"><div style=\"background-color: #f5ab00;color: #ffffff;\">The Slight Edge: Secret to a Successful Life by Jeff Olson</div></a><br><a href=\"http://www.goodreads.com/book/show/368593.The_4_Hour_Work_Week\" style=\"text-decoration: none;\"><div style=\"background-color: #f5ab00;color: #ffffff;\">The 4-Hour Work Week by Timothy Ferriss</div></a><br></i></body></html>";
		webview.loadData(content, "text/html", null);
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
