package editcontact.v1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
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
	private View mView; //return view for display
	private ImageView mImgAvatar; //avatar person
	private TextView mTvName; // name person	
	private EditText mEdtName; //Edittext name
	private EditText mEdtDescription; // Edittext description	
	private int mIdAvatar; //ID images
	private String mNamePerson; // Name Person
	private int mPosition; // Position in listview
	
	/**
	 * TODO constructor EditContactFragment
	 * 
	 * @param idAvatar
	 * @param namePerson
	 * @param position
	 */
	public EditContactFragment(int idAvatar, String namePerson, int position) {
		super();
		this.mIdAvatar = idAvatar;
		this.mNamePerson = namePerson;
		this.mPosition = position;
	}

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
		mView = inflater.inflate(R.layout.fragment_edit_contact, container,false);		
		Toast.makeText(mView.getContext(), "edit", Toast.LENGTH_SHORT).show();
		//find id for avatar and id textview name
		mImgAvatar = (ImageView)mView.findViewById(R.id.imgAvatar);
		mTvName = (TextView)mView.findViewById(R.id.tvName);
		//find id edit text
		mEdtName = (EditText)mView.findViewById(R.id.edtName);
		mEdtDescription = (EditText)mView.findViewById(R.id.edtDescription);
		//set image and text for it
		mImgAvatar.setImageResource(mIdAvatar);
		mTvName.setText(mNamePerson);
		mEdtName.setText(mNamePerson);		
		return mView;
	}
 
}
