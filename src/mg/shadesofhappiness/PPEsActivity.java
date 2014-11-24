package mg.shadesofhappiness;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PPEsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ppes);
		
		ListView listView1 = (ListView) findViewById(R.id.listView1);
		 
		 String[] items = { 
				 "Self-esteem exercises:\nWhat are the good incidents which happened today?\nWhat fun did you have today?\nWhat made you feel proud today?\nWhat made you feel accomplished today?\nWhat positive experience did you have today?\nDid you help anyone today?\nWhat made you feel good about yourself today?\nWere you feeling proud of someone else today?\nWhat interesting thing happened today?\nWhat positive thing did you witness today?",
				 "Gratitude exercises:\nJournal about gratitude:\nEvery night write down five things that were good about your day. The good things don’t have to be major—they might be as simple as a good meal, talking to a friend, or getting through something difficult.\nWrite a letter:\nThink about someone who has had a major impact on your life, someone who you would like to thank, or someone who you appreciate having in your life. Write a letter with specific details about what it is you appreciate about them, and send it.\nVisit someone who you appreciate:\nTake the idea of a gratitude letter a step further and actually visit the individual who you would like to thank. You can choose to deliver and read a gratitude letter, or simply visit and tell them why it is that you appreciate them.\nSay \"Thank You!\"\nKeep your eyes open throughout the day for reasons to say \"thanks\". Try to recognize the actions people do every day that might be overlooked such as a coworker who always works hard or a friend who always seems willing to listen.\nTake a gratitude walk:\nGo for a walk and make a special effort to appreciate your surroundings. You might notice the smell of flowers, a pretty building, or a soothing breeze. Spend a few minutes focusing on each of your senses (sight, hearing, taste, smell, and touch) to find new things you may not have noticed.",
				 "Positive traits exercises:\nBe kind. Be intelligent. Be hardworking. Be loyal. Be attractive. Be down-to-earth. Be goofy. Be creative. Be accepting. Be strong. Be friendly. Be flexible. Be nurturing. Be thoughtful. Be confident. Be optimistic. Be respectful. Be determined. Be skilled. Be helpful. Be motivated. Be insightful. Be funny. Be patient. Be realistic. Be honest. Be generous. Be modest. Be serious. Be independent. Be trusting. Be resilient. Be cheerful. Be self-directed. Be reliable. Be relaxed. Be a good listener. Be brave. Be decisive. Be enthusiastic. Be forgiving. Be humble. Be sensitive. Be organized. Be selfless. Be practical. Be mature. Be focused. Be courteous. Be grateful. Be open-minded. Be positive. Be responsible. Be cooperative. Be frugal. Be tolerant. Be innovative. Be balanced.",
				 "Positive steps to wellbeing:\nBe kind to yourself. Take up a hobby and/or learn a new skill. Help others. Eat healthily. Connect with others. See the bigger picture. Exercise regularly. Have some fun and/or be creative. Relax. Balance sleep. Accepting: 'It is as it is'. ",
				 "Strengths, qualities and achievements:\nWhat are the things you are good at?\nWhat are the compliments you have received?\nWhat are the things you like about your appearance?\nWhat are the challenges you have overcome in your life?"
		 };
		 
		 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		 R.layout.special_simple_list_item_1, items);
		 
		 listView1.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ppes, menu);
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
