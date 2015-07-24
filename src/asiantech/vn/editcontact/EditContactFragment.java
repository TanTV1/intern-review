package asiantech.vn.editcontact;

import android.app.Fragment;
import android.graphics.Point;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import asiantech.vn.listcontact.ListContactClass;
import asiantech.vn.listcontact.ListContactFragment;
import asiantech.vn.main.MainActivity;
import asiantech.vn.v1.R;

/**
* This is class EditContact Fragment
* Class extend from fragment , use show content in fragment
* 
* @version 1.0
* @since 22-07-2015
* @author ThaiVanTan
* DATE         AUTHOR          	DESCRIPTION
* --------------------------------------------------------
* 22-July-2015 TanTV			Description of modification
*/

public class EditContactFragment extends Fragment {
	private View mView; // return view for display
	private ImageView mImgAvatar; // avatar person
	private TextView mTvName; // name person
	private EditText mEdtName; // Edittext name
	private EditText mEdtDescription; // Edittext description
	private ListContactClass mListContactObject;
	private TextView tvBtnSave; // TextView Button Save
	private TextView tvBtnCancel; // TextView Button Cancel
	private int mPosition;
	/**
	 * TODO the first method
	 * 
	 * @return view
	 * @param inflater
	 * @param container
	 * @param savedInstanceState
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mView = inflater.inflate(R.layout.fragment_edit_contact, container,
				false);
		Toast.makeText(mView.getContext(), "edit", Toast.LENGTH_SHORT).show();

		// find id for avatar and id textview name
		mImgAvatar = (ImageView) mView.findViewById(R.id.imgAvatar);
		mTvName = (TextView) mView.findViewById(R.id.tvName);

		// find id edit text
		mEdtName = (EditText) mView.findViewById(R.id.edtName);
		mEdtDescription = (EditText) mView.findViewById(R.id.edtDescription);

		// call method get data from bundle
		getDataFromBundle();

		// set Data to TextView,ImageView and EditText
		mPosition = mListContactObject.getPositon();	
		mImgAvatar.setImageResource(mListContactObject.getmListContacts().get(mPosition).getmIdAvatar());
		mTvName.setText(mListContactObject.getmListContacts().get(mPosition).getmName());
		mEdtName.setText(mListContactObject.getmListContacts().get(mPosition).getmName());
		mEdtDescription.setText(mListContactObject.getmListContacts().get(mPosition).getmEdtDescription());
		// Method include all event
		setOnEvenEditContact();
		return mView;
	}

	/**
	 * 
	 * TODO Method set All Event for EditContacFragment
	 * 
	 */
	private void setOnEvenEditContact() {
		
		
		// Event Button Save
		tvBtnSave = (TextView) mView.findViewById(R.id.tvSave);
		tvBtnSave.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final String edtName = mEdtName.getText()+"";
				final String edtDescription = mEdtDescription.getText()+"";			
				ListContactFragment.mListContacts.get(mPosition).setmName(edtName);
				ListContactFragment.mListContacts.get(mPosition).setmEdtDescription(edtDescription);
				MainActivity.sFragmentManager.popBackStackImmediate();
				
				Toast.makeText(mView.getContext(), "Save Succesfull !" ,Toast.LENGTH_SHORT).show();
				
			}
		});
		
		//Event Button Cancel
		tvBtnCancel = (TextView)mView.findViewById(R.id.tvCancel);
		tvBtnCancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(mView.getContext(), "Clicked Cancel Button",
						Toast.LENGTH_SHORT).show();
				MainActivity.sFragmentManager.popBackStackImmediate();
			}
		});
	}

	/**
	 * 
	 * TODO This method use to get data from bunble
	 * 
	 * @param
	 * @return
	 */
	private void getDataFromBundle() {
		Bundle bundle = getArguments();
		mListContactObject = (ListContactClass) bundle.getSerializable("objectListContact");
	}
	
	

}
