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
	View view; //return view for display
	ImageView imgAvatar; //avatar person
	TextView tvName; // name person	
	EditText edtName; //Edittext name
	EditText edtDescription; // Edittext description	
	int idAvatar; //ID images
	String namePerson; // Name Person
	int position; // Position in listview
	
	/**
	 * TODO constructor EditContactFragment
	 * 
	 * @param idAvatar
	 * @param namePerson
	 * @param position
	 */
	public EditContactFragment(int idAvatar, String namePerson, int position) {
		super();
		this.idAvatar = idAvatar;
		this.namePerson = namePerson;
		this.position = position;
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
		view = inflater.inflate(R.layout.fragment_edit_contact, container,false);		
		Toast.makeText(view.getContext(), "edit", Toast.LENGTH_SHORT).show();
		//find id for avatar and id textview name
		imgAvatar = (ImageView)view.findViewById(R.id.imgAvatar);
		tvName = (TextView)view.findViewById(R.id.tvName);
		//find id edit text
		edtName = (EditText)view.findViewById(R.id.edtName);
		edtDescription = (EditText)view.findViewById(R.id.edtDescription);
		//set image and text for it
		imgAvatar.setImageResource(idAvatar);
		tvName.setText(namePerson);
		edtName.setText(namePerson);		
		return view;
	}
 
}
