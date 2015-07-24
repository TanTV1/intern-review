package asiantech.vn.listcontact;

import java.io.Serializable;


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
	private int mIdAvatar; // variable use contain id of image in items listivew
	private String mName; // variable use contain name of person in list contact

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

}
