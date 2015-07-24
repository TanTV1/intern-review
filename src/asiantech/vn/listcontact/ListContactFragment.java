package asiantech.vn.listcontact;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListView;
import android.widget.Toast;
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
	public static ArrayList<ListContactClass> mListContacts = new ArrayList<>(); // declare ArrayList contains Object in ListContactClass
	public static ListContactAdapter sAdapterListContact; // declare object adapter of ListContactAdapter
	private ListView lvListContact; // declare list view
	public static boolean sCheckUpdate; //declare check arraylist 
	private View mView;
	private int idName[] = { // set values id name
	R.drawable.img_lv_avatar_1, R.drawable.img_lv_avatar_2,
			R.drawable.img_lv_avatar_3, R.drawable.img_lv_avatar_4,
			R.drawable.img_lv_avatar_5, R.drawable.img_lv_avatar_6,
			R.drawable.img_lv_avatar_7, R.drawable.img_lv_avatar_8,
			R.drawable.img_lv_avatar_9 };
	private String namePerson[] = { // set values name of person
	"Luke Skywalker Bell", "Minions Stuart", "Allison Janney",
			"Jenifier Saunders", "Hiroyuki Sanada", "Dave Rosenbaum",
			"Mesut Ozil", "Alexis Sanchez", "Theo Walcott" };

	/**
	 * @TODO This is onCreate Method The first function when fragment starting
	 * 
	 * @param inflater
	 * @param container
	 * @param savedInstanceState
	 * @return void
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// return view
		mView = inflater.inflate(R.layout.fragment_list_contact, container,
				false);
		// add Data to arraylist 
		if (!sCheckUpdate){
			addDataToArrayList(mListContacts);
			sCheckUpdate = true;
		}
		// new adapter list contact
		sAdapterListContact = new ListContactAdapter(mListContacts,mView.getContext());
		// find id list view and set adapter to it
		lvListContact = (ListView) mView.findViewById(R.id.lvListContact);
		lvListContact.setAdapter(sAdapterListContact);
		Toast.makeText(mView.getContext(), "ListContacts", Toast.LENGTH_SHORT).show();
		//call method hide keyboard
		hide_keyboard_from(mView.getContext(), mView);
		return mView;
	}

	/**
	 * 
	 * TODO add Data to ArrayList
	 * 
	 * @param arrList
	 * 
	 */
	private void addDataToArrayList(ArrayList<ListContactClass> arrList) {
		ListContactClass contactClass;
		for (int i = 0; i < namePerson.length; i++) { // add data id and name from array to ArrayList
			contactClass = new ListContactClass(idName[i], namePerson[i]);
			arrList.add(contactClass); // add object to ArrayList Class
		}
	}
	
	/**
	 * 
	 * TODO Method Hide Keyboard
	 * 
	 * @param context
	 * @param view
	 */
	public static void hide_keyboard_from(Context context, View view) {
	    InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
	    inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
	}
}
