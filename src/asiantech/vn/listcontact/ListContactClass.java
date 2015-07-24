package asiantech.vn.listcontact;

import java.io.Serializable;
import java.util.ArrayList;


/**
* This is class ListContactClass
* It contains property of items listview 
* 
* @version 1.0
* @since 22-07-2015
* @author ThaiVanTan
* DATE         AUTHOR          	DESCRIPTION
* --------------------------------------------------------
* 22-July-2015 TanTV			Description of modification
*/

public class ListContactClass implements Serializable {
	private static final long serialVersionUID = 1L;
	private int mIdAvatar; // id of images in items listview
	private String mName; // name of person in items listview
	private int mPositon; // position in items listview
	private String mEdtDescription; //description a contact
	private ArrayList<ListContactClass> mListContacts;
	
	/**
	 * TODO Contrustor of ListContactClass
	 * 
	 * @param positon
	 * @param mListContacts
	 */
	public ListContactClass(int positon,ArrayList<ListContactClass> mListContacts) {
		super();
		this.mPositon = positon;
		this.mListContacts = mListContacts;
	}
		

	/**
	 * TODO Contrustor of ListContactClass
	 * 
	 * @param mIdAvatar
	 * @param mName
	 */
	public ListContactClass(int mIdAvatar, String mName) {
		super();
		this.mIdAvatar = mIdAvatar;
		this.mName = mName;
	}
	
	
	/**
	 * 
	 * TODO get value in ID Avatar Images
	 * 
	 * @return int
	 */
	public int getmIdAvatar() {
		return mIdAvatar;
	}

	/**
	 * 
	 * TODO set value in ID Avatar Images
	 * 
	 * @return void
	 * @param mIdAvatar
	 */
	public void setmIdAvatar(int mIdAvatar) {
		this.mIdAvatar = mIdAvatar;
	}

	/**
	 * 
	 * TODO get name of Person in List Contact
	 * 
	 * @return void
	 */
	public String getmName() {
		return mName;
	}

	/**
	 * 
	 * TODO set name for items in listview
	 * 
	 * @return void
	 * @param mName
	 */
	public void setmName(String mName) {
		this.mName = mName;
	}
	/**
	 * 
	* TODO get position method
	* @return
	*
	*/
	public int getPositon() {
		return mPositon;
	}
	/**
	 * 
	* TODO get position method
	* @param positon
	*
	*/
	public void setPositon(int positon) {
		this.mPositon = positon;
	}

	/**
	 * 
	 * TODO get ArrayList mListContact
	 * 
	 * @return ArrayList
	 */
	public ArrayList<ListContactClass> getmListContacts() {
		return mListContacts;
	}

	/**
	 * 
	 * TODO set arraylist
	 * 
	 * @param mListContacts
	 */
	public void setmListContacts(ArrayList<ListContactClass> mListContacts) {
		this.mListContacts = mListContacts;
	}


	/**
	 * 
	 * TODO get String decription
	 * 
	 * @return String
	 */
	public String getmEdtDescription() {
		return mEdtDescription;
	}


	/**
	 * 
	 * TODO set decription
	 * 
	 * @param String
	 * 
	 */
	public void setmEdtDescription(String mEdtDescription) {
		this.mEdtDescription = mEdtDescription;
	}
	
	

}
