package mg.shadesofhappiness;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.Session;
import com.facebook.UiLifecycleHelper;
import com.facebook.widget.FacebookDialog;
import com.facebook.widget.WebDialog;
import com.facebook.widget.WebDialog.OnCompleteListener;

public class LCActivity extends Activity {
	private UiLifecycleHelper uiHelper;
	private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
	private static final int CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE = 200;
	public static final int MEDIA_TYPE_IMAGE = 1;
	public static final int MEDIA_TYPE_VIDEO = 2;
	private Uri fileUri;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lc);
		
		ListView listView1 = (ListView) findViewById(R.id.listView1);

		 String[] items = { "Update facebook status", "Tweet", "Take a funny photo", "Take a funny video", 
		 };

		 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		 R.layout.special_simple_list_item_1, items);

		 listView1.setAdapter(adapter);
		 
		 listView1.setOnItemClickListener(new OnItemClickListener() {
	            @Override
	            public void onItemClick(AdapterView<?> parent, View view, int position,
	                    long id) {
	            	//Toast.makeText(getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
	            	Intent intent;
	                switch(position)
	                {
	                case 0:
	                	if (FacebookDialog.canPresentShareDialog(getApplicationContext(), 
                                FacebookDialog.ShareDialogFeature.SHARE_DIALOG)) {
	                	FacebookDialog shareDialog = new FacebookDialog.ShareDialogBuilder(LCActivity.this)
	                	.setName("365 Shades of Happiness")
	                	.setLink(null)
	                    .build();
	                	uiHelper.trackPendingDialogCall(shareDialog.present());
	                	}
	                	else
	                	{
	                		publishFeedDialog();
	                	}
	                	break;
	                case 1:
	                	String url = "https://twitter.com/intent/tweet?button_hashtag=365SOH";
	            		intent = new Intent(Intent.ACTION_VIEW);
	            		intent.setData(Uri.parse(url));
	            		startActivity(intent);
	                	break;
	                case 2:
	                	intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	                	fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
	                	intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
	                	startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
	                	break;
	                case 3:
	                	intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
	                	fileUri = getOutputMediaFileUri(MEDIA_TYPE_VIDEO); 
	                	intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); 
	                	intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
	                	startActivityForResult(intent, CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE);
	                	break;
	        
	                }
	                
	            }
	        });
		 
		 uiHelper = new UiLifecycleHelper(this, null);
		 uiHelper.onCreate(savedInstanceState);
		 
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    super.onActivityResult(requestCode, resultCode, data);

	    uiHelper.onActivityResult(requestCode, resultCode, data, new FacebookDialog.Callback() {
	        @Override
	        public void onError(FacebookDialog.PendingCall pendingCall, Exception error, Bundle data) {
	            Log.e("Activity", String.format("Error: %s", error.toString()));
	        }

	        @Override
	        public void onComplete(FacebookDialog.PendingCall pendingCall, Bundle data) {
	            Log.i("Activity", "Success!");
	        }
	    });
	    
	    if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
	        if (resultCode == RESULT_OK) {
	            // Image captured and saved to fileUri specified in the Intent
	            Toast.makeText(this, "Image saved to:\n" +
	                     data.getData(), Toast.LENGTH_SHORT).show();
	        } else if (resultCode == RESULT_CANCELED) {
	            // User cancelled the image capture
	        } else {
	            // Image capture failed, advise user
	        	Toast.makeText(getApplicationContext(), "Something went wrong...", Toast.LENGTH_SHORT).show();
	        }
	    }

	    if (requestCode == CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE) {
	        if (resultCode == RESULT_OK) {
	            // Video captured and saved to fileUri specified in the Intent
	            Toast.makeText(this, "Video saved to:\n" +
	                     data.getData(), Toast.LENGTH_SHORT).show();
	        } else if (resultCode == RESULT_CANCELED) {
	            // User cancelled the video capture
	        } else {
	            // Video capture failed, advise user
	        	Toast.makeText(getApplicationContext(), "Something went wrong...", Toast.LENGTH_SHORT).show();
	        }
	    }
	}
	
	private static Uri getOutputMediaFileUri(int type){
	      return Uri.fromFile(getOutputMediaFile(type));
	}
	
	private static File getOutputMediaFile(int type){
		
	    // To be safe, you should check that the SDCard is mounted
	    // using Environment.getExternalStorageState() before doing this.
		String state = Environment.getExternalStorageState();
		 if (Environment.MEDIA_MOUNTED.equals(state)) {
	    File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
	              Environment.DIRECTORY_PICTURES), "365SOH");
		 
	    // This location works best if you want the created images to be shared
	    // between applications and persist after your app has been uninstalled.

	    // Create the storage directory if it does not exist
	    if (! mediaStorageDir.exists()){
	        if (! mediaStorageDir.mkdirs()){
	            Log.d("365SOH", "failed to create directory");
	            return null;
	        }
	    }

	    // Create a media file name
	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    File mediaFile;
	    if (type == MEDIA_TYPE_IMAGE){
	        mediaFile = new File(mediaStorageDir.getPath() + File.separator +
	        "IMG_"+ timeStamp + ".jpg");
	    } else if(type == MEDIA_TYPE_VIDEO) {
	        mediaFile = new File(mediaStorageDir.getPath() + File.separator +
	        "VID_"+ timeStamp + ".mp4");
	    } else {
	        return null;
	    }
		 

	    return mediaFile;
		 }
		 else
		 {
			 return null;
		 }
	    
	}
	
	@Override
	protected void onResume() {
	    super.onResume();
	    uiHelper.onResume();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
	    super.onSaveInstanceState(outState);
	    uiHelper.onSaveInstanceState(outState);
	}

	@Override
	public void onPause() {
	    super.onPause();
	    uiHelper.onPause();
	}

	@Override
	public void onDestroy() {
	    super.onDestroy();
	    uiHelper.onDestroy();
	}
	
	private void publishFeedDialog() {
	    Bundle params = new Bundle();
	    params.putString("name", "365 Shades of Happiness");
	    params.putString("link", null);
	    

	    WebDialog feedDialog = (
	        new WebDialog.FeedDialogBuilder(this,
	            Session.getActiveSession(),
	            params))
	        .setOnCompleteListener(new OnCompleteListener() {

	            @Override
	            public void onComplete(Bundle values,
	                FacebookException error) {
	                if (error == null) {
	                    // When the story is posted, echo the success
	                    // and the post Id.
	                    final String postId = values.getString("post_id");
	                    if (postId != null) {
	                        Toast.makeText(getApplicationContext(),
	                            "Posted story, id: "+postId,
	                            Toast.LENGTH_SHORT).show();
	                    } else {
	                        // User clicked the Cancel button
	                        Toast.makeText(getApplicationContext(), 
	                            "Publish cancelled", 
	                            Toast.LENGTH_SHORT).show();
	                    }
	                } else if (error instanceof FacebookOperationCanceledException) {
	                    // User clicked the "x" button
	                    Toast.makeText(getApplicationContext(), 
	                        "Publish cancelled", 
	                        Toast.LENGTH_SHORT).show();
	                } else {
	                    // Generic, ex: network error
	                    Toast.makeText(getApplicationContext(), 
	                        "Error posting story", 
	                        Toast.LENGTH_SHORT).show();
	                }
	            }

	        })
	        .build();
	    feedDialog.show();
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lc, menu);
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
