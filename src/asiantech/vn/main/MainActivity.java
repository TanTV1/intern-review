package asiantech.vn.main;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import asiantech.vn.editcontact.EditContactFragment;
import asiantech.vn.listcontact.ListContactClass;
import asiantech.vn.listcontact.ListContactFragment;
import asiantech.vn.v1.R;


/**
* This is class MainActivity
* Main Class
* 
* @version 1.0
* @since 22-07-2015
* @author ThaiVanTan
* DATE         AUTHOR          	DESCRIPTION
* --------------------------------------------------------
* 22-July-2015 TanTV			Description of modification
*/

public class MainActivity extends FragmentActivity {
	private ImageView mImgBtnBack; // ImageView button black
	public static FragmentManager sFragmentManager;
	public static FragmentTransaction sFragmentTransaction;

	/**
	 * TODO The first function when activity starting, create a activity
	 * 
	 * @param savedInstanceState
	 * @return void
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_contacts_main);
		sFragmentManager = getFragmentManager();
		sFragmentTransaction = sFragmentManager.beginTransaction();
		sFragmentTransaction.replace(R.id.frFragment, new ListContactFragment());
		sFragmentTransaction.addToBackStack(null);
		sFragmentTransaction.commit();
		setOnEvent();

	}

	/**
	 * TODO method catch event in MainActivity
	 * 
	 * @param
	 */
	private void setOnEvent() {
		// Event on button Back
		mImgBtnBack = (ImageView) findViewById(R.id.imgBtnBack);
		mImgBtnBack.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// if stack == 1 exit else return main screen
				onBackPressed();
			}
		});
	}

	/**
	 * TODO Override Method when press back button
	 * @param 
	 */
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		ListContactFragment.sAdapterListContact.notifyDataSetChanged();
		if (sFragmentManager.getBackStackEntryCount() == 1) {
			super.onBackPressed(); // exit application
		} else
			sFragmentManager.popBackStackImmediate(); // return and pop stack
		
	}

	/**
	 * 
	 * TODO Method show fragment edit contact and send data using bundle
	 * 
	 * @param
	 * @return
	 */
	public static void showFragmentEditContact(ListContactClass listContact) {
		EditContactFragment fragmentEditContact = new EditContactFragment();
		Bundle bundle = new Bundle();
		bundle.putSerializable("objectListContact", listContact);
		fragmentEditContact.setArguments(bundle);
		sFragmentTransaction = sFragmentManager.beginTransaction();
		sFragmentTransaction.replace(R.id.frFragment, fragmentEditContact);
		sFragmentTransaction.addToBackStack(null);
		sFragmentTransaction.commit();
	}


}
