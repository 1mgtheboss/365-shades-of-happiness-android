package mg.shadesofhappiness;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SOHOptionAdapter extends ArrayAdapter<SOHOption>{
	 Context context;
	 int layoutResourceId; 
	 SOHOption data[] = null;
	 
	 public SOHOptionAdapter(Context context, int layoutResourceId, SOHOption[]
	data) {
	 super(context, layoutResourceId, data);
	 this.layoutResourceId = layoutResourceId;
	 this.context = context;
	 this.data = data;
	 }
	 @Override
	 public View getView(int position, View convertView, ViewGroup parent) {
	 View row = convertView;
	 SOHOptionHolder holder = null;
	 
	 if(row == null)
	 {
	 LayoutInflater inflater =((Activity)context).getLayoutInflater();
	 row = inflater.inflate(layoutResourceId, parent, false);
	 
	 holder = new SOHOptionHolder();
	 holder.imgIcon = (ImageView)row.findViewById(R.id.imgIcon);
	 holder.txtTitle = (TextView)row.findViewById(R.id.txtTitle);
	 
	 row.setTag(holder);
	 }
	 else
	 {
	 holder = (SOHOptionHolder)row.getTag();
	 }
	 
	 SOHOption mSOHOption = data[position];
	 holder.txtTitle.setText(mSOHOption.title);
	 holder.imgIcon.setImageResource(mSOHOption.icon);
	 
	 return row;
	 }
	 
	 static class SOHOptionHolder
	 {
	 ImageView imgIcon;
	 TextView txtTitle;
	 }


}
