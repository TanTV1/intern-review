package asiantech.vn.listcontact;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import asiantech.vn.otherclass.ApplicationData;
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
	public static ArrayList<ListContactClass> sListContacts = new ArrayList<>(); // declare ArrayList contains Object in ListContactClass
	public static ListContactAdapter sAdapterListContact; // declare object adapter of ListContactAdapter
	private ListView lvListContact; // declare list view
	public static boolean sCheckUpdate; //declare check arraylist 
	private View mView;
	public static ProgressBar sProgressBar; //declare progress bar
	

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
			addDataToArrayList(sListContacts);
			sCheckUpdate = true;
		}
		// new adapter list contact
		sAdapterListContact = new ListContactAdapter(sListContacts,mView.getContext());
		// find id list view and set adapter to it
		lvListContact = (ListView) mView.findViewById(R.id.lvListContact);
		lvListContact.setAdapter(sAdapterListContact);
		Toast.makeText(mView.getContext(), "ListContacts", Toast.LENGTH_SHORT).show();
		//call method hide keyboard
		hide_keyboard_from(mView.getContext(), mView);
		setLoadingMore(inflater);
		return mView;
	}

	/**
	 * 
	 * TODO add Data to ArrayList
	 * 
	 * @param arrList
	 * 
	 */
	public static void addDataToArrayList(ArrayList<ListContactClass> arrList) {
		ListContactClass contactClass;
		for (int i = 0; i < ApplicationData.namePerson.length; i++) { // add data id and name from array to ArrayList
			contactClass = new ListContactClass(ApplicationData.idName[i], ApplicationData.namePerson[i]);
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
	
	private void setLoadingMore(LayoutInflater inflater){
		View footer = inflater.inflate(R.layout.progress_bar_footer, null);
		sProgressBar = (ProgressBar) footer.findViewById(R.id.progressBar);
		lvListContact.addFooterView(footer);
		lvListContact.setOnScrollListener(new OnScrollListener() {
			
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				//starting AsyncTask				
				new LoadingMoreListView().execute();
				
			}
			
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
}

/**
 * TODO Class AsyncTask use loading more items in listview
 * @param 
 *
 */
class LoadingMoreListView extends AsyncTask<Void, Integer, Void>{
	private ArrayList<ListContactClass> mListContacts;
	private ListContactClass mListContact;	
	@Override
	protected Void doInBackground(Void... params) {
		// TODO Auto-generated method stub
		try {
			//VISIBLE Progress bar
			ListContactFragment.sProgressBar.setVisibility(View.VISIBLE);
			//Sleep 2s
			Thread.sleep(2000);
			//Add Data to ArrayList
			ListContactFragment.addDataToArrayList(ListContactFragment.sListContacts);
			//INVISIBLE Progress bar
			ListContactFragment.sProgressBar.setVisibility(View.INVISIBLE);
		}
		catch (Exception e){}
		
		return null;
	}

	/**
	 * TODO Update ListView
	 */
	@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		ListContactFragment.sAdapterListContact.notifyDataSetChanged();
	}
	
	
	
}
