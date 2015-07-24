package asiantech.vn.editcontact;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import asiantech.vn.listcontact.ListContactClass;
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
		mImgAvatar.setImageResource(mListContactObject.getmIdAvatar());
		mTvName.setText(mListContactObject.getmName());
		mEdtName.setText(mListContactObject.getmName());

		return mView;
	}

	private void setOnEvenEditContact() {

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
		mListContactObject = (ListContactClass) bundle
				.getSerializable("objectListContact");
	}

}
