package listcontact.v1;

import java.util.ArrayList;

import editcontact.v1.EditContactFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import asiantech.vn.v1.CustomAdapterFragment;
import asiantech.vn.v1.MainActivity;
import asiantech.vn.v1.R;

/**
* This is class ListContactFragment
* Use load list fragment ListContact and EditContact
* 
* @version 1.0
* @since 22-07-2015
* @author ThaiVanTan
* DATE         AUTHOR          	DESCRIPTION
* --------------------------------------------------------
* 22-July-2015 TanTV			Description of modification
*/

public class ListContactFragment extends Fragment {
	private ArrayList<ListContactClass> mListContacts; //declare ArrayList contains Object in ListContactClass 
	private ListContactAdapter mAdapterListContact; //declare object adapter of ListContactAdapter	
	//Declare some field relation
	private ListView lvListContact; //declare list view
	private int idName[] = { //set values id name
				R.drawable.img_lv_avatar_1,R.drawable.img_lv_avatar_2,R.drawable.img_lv_avatar_3,R.drawable.img_lv_avatar_4,R.drawable.img_lv_avatar_5,R.drawable.img_lv_avatar_6,R.drawable.img_lv_avatar_7,R.drawable.img_lv_avatar_8,R.drawable.img_lv_avatar_9
	};
	private String namePerson[] = { //set values name of person
			"Luke Skywalker Bell","Minions Stuart","Allison Janney","Jenifier Saunders","Hiroyuki Sanada","Dave Rosenbaum","Mesut Ozil","Alexis Sanchez","Theo Walcott"
	};
		
	/**
	 * This is onCreate Method
	 * The first function when fragment starting
	 * @param inflater
	 * @param container
	 * @param savedInstanceState
	 * @return void
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//return view 
		View view = inflater.inflate(R.layout.fragment_list_contact, container,
				false);
		//create new arraylist
		mListContacts = new ArrayList<>();
		//add Data to arraylist
		addDataToArrayList(mListContacts);
		//new adapter list contact
		mAdapterListContact = new ListContactAdapter(mListContacts,view.getContext());
		//find id list view and set adapter to it
		lvListContact = (ListView)view.findViewById(R.id.lvListContact);
		lvListContact.setAdapter(mAdapterListContact);
		Toast.makeText(view.getContext(), "ListContacts", Toast.LENGTH_SHORT).show();
		
		return view;
	}
	
	/**
	 * 
	*TODO add Data to ArrayList
	* @param arrList
	* @return void
	* @author tantv
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
