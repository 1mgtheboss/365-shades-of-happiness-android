package mg.shadesofhappiness;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class QuotesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quotes);
		
		ListView listView1 = (ListView) findViewById(R.id.listView1);
		 
		 String[] items = { "Love is that which you cannot fully express or hide. Beauty is that which you cannot possess or renounce. Truth is that which you cannot avoid.\n___Sri Sri Ravi Shankar",
				 "Be in the now. Desire wants to be happy tomorrow. Be happy and joyful now.\n___Sri Sri Ravi Shankar",
				 "The art of being happy lies in the power of extracting happiness from common things.\n___Henry Ward Beecher",
				 "Compassion is a source of enormous strength. ... Many of us don't realise what one act of compassion can do. ... Compassion leads to happiness.\n___Emma Seppala",
				 "Darwin’s message was not ‘survival of the fittest’, but rather ‘survival of the kindest’, because we need each other’s support and care to survive as a species.\n___Emma Seppala",								 				 
			     "Want to be happier? Stay in the moment.\n___Matt Killingsworth",
				 "People are less happy when they’re mind-wandering, no matter what they’re doing.\n___Matt Killingsworth",
				 "We all die. The goal isn’t to live forever, the goal is to create something that will.\n___Chuck Palahniuk",				 
				 "Life is fragile, live the moments with strength and humor.\n___Ambarish Gupta",
				 "It is not how much we have, but how much we enjoy, that makes happiness.\n___Charles Spurgeon",
				 "I am determined to be cheerful and happy in whatever situation I may find myself. For I have learned that the greater part of our misery or unhappiness is determined not by our circumstance but by our disposition.\n___Martha Washington",
				 "Be happy for this moment. This moment is your life.\n___Omar Khayyam",
				 "Happiness is when what you think, what you say, and what you do are in harmony.\n___Mahatma Gandhi",
				 "Happiness is not something ready made. It comes from your own actions.\n___Dalai Lama",
				 "There is only one happiness in this life, to love and be loved.\n___George Sand",
				 "Be happy with what you have and are, be generous with both, and you won't have to hunt for happiness.\n___William E. Gladstone",
				 "Happiness cannot be traveled to, owned, earned, worn or consumed. Happiness is the spiritual experience of living every minute with love, grace, and gratitude.\n___Denis Waitley",
				 "Try to make at least one person happy every day.\n___Lawrence G. Lovasik",
				 "Remember that the happiest people are not those getting more, but those giving more.\n___H. Jackson Brown, Jr.",
				 "There is only one way to happiness and that is to cease worrying about things which are beyond the power of our will.\n___Epictetus",
				 "If you want others to be happy, practice compassion. If you want to be happy, practice compassion.\n___Dalai Lama",
				 "For every minute you are angry you lose sixty seconds of happiness.\n___Ralph Waldo Emerson",
				 "Love is that condition in which the happiness of another person is essential to your own.\n___Robert A. Heinlein",
				 "The most important thing is to enjoy your life—to be happy—it's all that matters.\n___Audrey Hepburn",
				 "They say a person needs just three things to be truly happy in this world: someone to love, something to do, and something to hope for.\n___Tom Bodett",
				 "Let us be grateful to the people who make us happy; they are the charming gardeners who make our souls blossom.\n___Marcel Proust",
				 "Thousands of candles can be lighted from a single candle, and the life of the candle will not be shortened. Happiness never decreases by being shared.\n___Buddha",
				 "Happiness is the art of never holding in your mind the memory of any unpleasant thing that has passed.\n___Unknown",
				 "To be happy, we must not be too concerned with others.\n___Albert Camus",
				 "If you want happiness for an hour — take a nap.’ If you want happiness for a day — go fishing. If you want happiness for a year — inherit a fortune. If you want happiness for a lifetime — help someone else.\n___Chinese Proverb",
				 "It isn’t what you have, or who you are, or where you are, or what you are doing that makes you happy or unhappy. It is what you think about.\n___Dale Carnegie",
				 "It’s a helluva start, being able to recognize what makes you happy.\n___Lucille Ball",
				 "We tend to forget that happiness doesn’t come as a result of getting something we don’t have, but rather of recognizing and appreciating what we do have.\n___Frederick Keonig",
				 "To be kind to all, to like many and love a few, to be needed and wanted by those we love, is certainly the nearest we can come to happiness.\n___Mary Stuart",
				 "Happy people plan actions, they don’t plan results.\n___Dennis Waitley",
				 "Success is not the key to happiness. Happiness is the key to success. If you love what you are doing, you will be successful.\n___Herman Cain",
				 "There is only one cause of unhappiness: the false beliefs you have in your head, beliefs so widespread, so commonly held, that it never occurs to you to question them.\n___Anthony de Mello",
				 "When one door of happiness closes, another opens, but often we look so long at the closed door that we do not see the one that has been opened for us.\n___Helen Keller",
				 "Happiness depends upon ourselves.\n___Aristotle",
				 "It is more fitting for a man to laugh at life than to lament over it.\n___Seneca",
				 "Happiness is acceptance.\n___Unknown",
				 "A table, a chair, a bowl of fruit and a violin; what else does a man need to be happy?\n___Albert Einstein",
				 "Life is really simple, but we insist on making it complicated.\n___Confucius",
				 "When I look back on all these worries, I remember the story of the old man who said on his deathbed that he had had a lot of trouble in his life, most of which had never happened.\n___Winston Churchill",
				 "For most of life, nothing wonderful happens. If you don’t enjoy getting up and working and finishing your work and sitting down to a meal with family or friends, then the chances are you’re not going to be very happy. If someone bases his/her happiness on major events like a great job, huge amounts of money, a flawlessly happy marriage or a trip to Paris, that person isn’t going to be happy much of the time. If, on the other hand, happiness depends on a good breakfast, flowers in the yard, a drink or a nap, then we are more likely to live with quite a bit of happiness.\n___Andy Rooney",
				 "Learn to let go. That is the key to happiness.\n___Buddha",
				 "We don’t stop playing because we grow old; we grow old because we stop playing.\n___George Bernard Shaw",
				 "I believe compassion to be one of the few things we can practice that will bring immediate and long-term happiness to our lives.\n___Dalai Lama",
				 "Happiness consists of living each day as if it were the first day of your honeymoon and the last day of your vacation.\n___Leo Tolstoy",
				 "If you spend your whole life waiting for the storm, you’ll never enjoy the sunshine.\n___Morris West",
				 "Life will bring you pain all by itself. Your responsibility is to create joy.\n___Milton Erickson"
				 
				 };
		 
		 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		 R.layout.special_simple_list_item_1, items);
		 
		 listView1.setAdapter(adapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.quotes, menu);
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
