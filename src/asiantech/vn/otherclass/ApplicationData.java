package asiantech.vn.otherclass;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import asiantech.vn.listcontact.ListContactClass;
import asiantech.vn.v1.R;

public class ApplicationData {
	public static boolean sCheckingLoading = true; //Variable checking loading
	
	public static final int ID_NAME[] = { // set values id name
			R.drawable.img_lv_avatar_1, R.drawable.img_lv_avatar_2,
					R.drawable.img_lv_avatar_3, R.drawable.img_lv_avatar_4,
					R.drawable.img_lv_avatar_5, R.drawable.img_lv_avatar_6,
					R.drawable.img_lv_avatar_7, R.drawable.img_lv_avatar_8,
					R.drawable.img_lv_avatar_9 };
	public static final  String NAME_PERSON[] = { // set values name of person
			"Luke Skywalker Bell", "Minions Stuart", "Allison Janney",
					"Jenifier Saunders", "Hiroyuki Sanada", "Dave Rosenbaum",
					"Mesut Ozil", "Alexis Sanchez", "Theo Walcott" };
	
	/**
	 * 
	 * TODO add Data to ArrayList
	 * 
	 * @param arrList
	 * 
	 */
	public static void addDataToArrayList(ArrayList<ListContactClass> arrList) {
		ListContactClass contactClass;
		for (int i = 0; i < ApplicationData.NAME_PERSON.length; i++) { // add data id and name from array to ArrayList
			contactClass = new ListContactClass(ApplicationData.ID_NAME[i], ApplicationData.NAME_PERSON[i]);
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
