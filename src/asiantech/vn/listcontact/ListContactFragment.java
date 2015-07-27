package asiantech.vn.listcontact;

import java.util.ArrayList;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
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
	private ListView mLvListContact; // declare list view
	private static boolean sCheckUpdate; //declare check arraylist 
	public static View mView; //declare view
	public static ProgressBar sProgressBar; //declare progress bar
	private int mPreLast; // variable hold previous position
	
	
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
		mView = inflater.inflate(R.layout.fragment_list_contact, container,false);
		// add Data to arraylist 
		if (!sCheckUpdate){
			ApplicationData.addDataToArrayList(sListContacts);
			sCheckUpdate = true;
		}
		// new adapter list contact
		sAdapterListContact = new ListContactAdapter(sListContacts,mView.getContext());
		// find id list view and set adapter to it
		mLvListContact = (ListView) mView.findViewById(R.id.lvListContact);
		mLvListContact.setAdapter(sAdapterListContact);
		//call method hide keyboard
		ApplicationData.hide_keyboard_from(mView.getContext(), mView);
		setLoadingMore(inflater);
		return mView;
	}

	/**
	* 
	*TODO set Layout and Event Scroll Items in ListView
	* @param inflater
	* @return void
	*
	*/
	private void setLoadingMore(LayoutInflater inflater){
		//declare footer view
		View footer = inflater.inflate(R.layout.progress_bar_footer, null);
		sProgressBar = (ProgressBar) footer.findViewById(R.id.progressBar);
		// add view to listview
		mLvListContact.addFooterView(footer);
		//Event scroll items in listview
		mLvListContact.setOnScrollListener(new OnScrollListener() {
			
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,int visibleItemCount, int totalItemCount) {
				switch (view.getId()) {
				case R.id.lvListContact:
					final int lastItem = firstVisibleItem + visibleItemCount;
					if(lastItem == totalItemCount) {

						//if (ListContactFragment.sProgressBar.getVisibility() == View.INVISIBLE) {
							ListContactFragment.sProgressBar.setVisibility(View.VISIBLE);
						//}
			              if(mPreLast!=lastItem){ //to avoid multiple calls for last item
							if (ApplicationData.sCheckingLoading) {
								ApplicationData.sCheckingLoading = false;
								mPreLast = lastItem; // save pre position
								new LoadingMoreListView().execute(); // execute AsyncTask
							
							}
			              }
			           }
					break;

				default:
					break;
				}
				
			}
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {				
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
	@Override
	protected Void doInBackground(Void... params) {
	
		try {
			//Add Data to ArrayList
			ApplicationData.addDataToArrayList(ListContactFragment.sListContacts);			
//			//VISIBLE Progress bar
			if (ListContactFragment.sProgressBar.getVisibility()==View.INVISIBLE){
				ListContactFragment.sProgressBar.setVisibility(View.VISIBLE);	
			}			
			//Sleep 2s
			Thread.sleep(2000);
			//INVISIBLE Progress bar
			if (ListContactFragment.sProgressBar.getVisibility()==View.VISIBLE){
				ListContactFragment.sProgressBar.setVisibility(View.INVISIBLE);	
			}
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
		ApplicationData.sCheckingLoading = true;
	}
	
	
	
	
}
