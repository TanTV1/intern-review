package listcontact.v1;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import asiantech.vn.v1.R;

/**
* This is class ListContactAdapter
* Class Adapter of ListContact 
* 
* @version 1.0
* @since 22-07-2015
* @author ThaiVanTan
* DATE         AUTHOR          	DESCRIPTION
* --------------------------------------------------------
* 22-July-2015 TanTV			Description of modification
*/

public class ListContactAdapter extends BaseAdapter {
	private ArrayList<ListContactClass> mListContacts; //declare ArrayList contains Object in ListContactClass 
	private Context mContext; //declare context , use contain context of MainAcitity
	
	/**	
	 * TODO Constructor of ListContactAdapter
	 * @param mListContacts
	 * @param mAdapterListContact
	 * @param mContext
	 */
	public ListContactAdapter(Context mContext,
			ArrayList<ListContactClass> mListContacts) {
		super();
		this.mContext = mContext;
		this.mListContacts = mListContacts;
	}

	/**
	 * TODO method Count of Items
	 * @return int
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mListContacts.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * This is class ViewHolder
	 * Use contains Object of items
	 * 
	 */
	class ViewHolder{
		ImageView imgAvatar; //declare imageview avatar
		TextView tvNamePerson; //declare textview name person
		ImageView imgBtnEdit; //declare imageview button Edit
		ImageView imgBtnDelete; //declare imageview button Delete
		
	}
	
	/***
	 * TODO return view to set on Items Listview
	 * @return View
	 * @param position
	 * @param convertView
	 * @param parent
	 * 
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder; //declare object of Class ViewHolder
		if (convertView ==null){ //it calls when item listview not scroll 
			convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list_list_contacts_main,parent,false); //set layout custom item listview
			holder = new ViewHolder(); //creare new object ViewHolder
			//return ID for child view
			holder.imgAvatar = (ImageView)convertView.findViewById(R.id.imgAvatar);
			holder.tvNamePerson = (TextView)convertView.findViewById(R.id.tv_name_contact_items);
			holder.imgBtnEdit = (ImageView)convertView.findViewById(R.id.imgBtnEdit);
			holder.imgBtnDelete = (ImageView)convertView.findViewById(R.id.imgBtnDelete);		
			//
			convertView.setTag(holder); //set tag holder			
		}
		else{
			holder = (ViewHolder)convertView.getTag(); //if holder is available , it calls function getTag()			
		}
		
		setValues(holder,position); // call method set values
		return convertView; //return view
	}
	
	/**
	 * 
	*TODO setValues for items in ListView
	* @param holder
	* @param position
	*  
	*/
	private void setValues(ViewHolder holder,int position){
		//get values and set values for items lisview
		holder.imgAvatar.setImageResource(mListContacts.get(position).getmIdAvatar());
		holder.tvNamePerson.setText(mListContacts.get(position).getmName());
	}
	
}
