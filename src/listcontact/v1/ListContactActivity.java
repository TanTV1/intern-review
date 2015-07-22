package listcontact.v1;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;
import asiantech.vn.v1.R;

/**
* This is class ListContactActivity
* Use load list contact to listview
* 
* @version 1.0
* @since 22-07-2015
* @author ThaiVanTan
* DATE         AUTHOR          	DESCRIPTION
* --------------------------------------------------------
* 22-July-2015 TanTV			Description of modification
*/

public class ListContactActivity extends ActionBarActivity {
	private ArrayList<ListContactClass> mListContacts; //declare ArrayList contains Object in ListContactClass 
	private ListContactAdapter mAdapterListContact; //declare object adapter of ListContactAdapter
	
	//Declare some field relation
	ListView lvListContact; //declare list view
	int idName[] = { //set values id name
				R.drawable.img_lv_avatar_1,R.drawable.img_lv_avatar_2,R.drawable.img_lv_avatar_3,R.drawable.img_lv_avatar_4,R.drawable.img_lv_avatar_5,R.drawable.img_lv_avatar_6,R.drawable.img_lv_avatar_7,R.drawable.img_lv_avatar_8,R.drawable.img_lv_avatar_9
	};
	String namePerson[] = { //set values name of person
			"Luke Skywalker Bell","Minions Stuart","Allison Janney","Jenifier Saunders","Hiroyuki Sanada","Dave Rosenbaum","Mesut Ozil","Alexis Sanchez","Theo Walcott"
	};
	
	/**
	 * This is onCreate Method
	 * The first function when activity starting, create a activity
	 * @param savedInstanceState
	 * @return void
	 */	
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getSupportActionBar().hide();
		setContentView(R.layout.activity_list_contacts_main);
		lvListContact = (ListView)findViewById(R.id.lvListContacts); //find a view by ID
		mListContacts = new ArrayList<>(); // create new object of ArrayList
		addDataToArrayList(mListContacts); // set data to mListContacts		
		mAdapterListContact = new ListContactAdapter(this,mListContacts); // new Object Adapter
		lvListContact.setAdapter(mAdapterListContact); //set Adapter for ListView
		
	}
	
	/**
	 * 
	*TODO add Data to ArrayList
	* @param arrList
	* return Void
	* 
	*/
	private void addDataToArrayList(ArrayList<ListContactClass> arrList){
		ListContactClass contactClass;
		for (int i=0;i<namePerson.length;i++){ //add data id and name from array to ArrayList
			contactClass = new ListContactClass(idName[i],namePerson[i]);
			arrList.add(contactClass); //add object to ArrayList Class			
		}
	}
	
}
