package asiantech.vn.v1;

import java.util.ArrayList;

import listcontact.v1.ListContactAdapter;
import listcontact.v1.ListContactClass;
import listcontact.v1.ListContactFragment;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import editcontact.v1.EditContactFragment;


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
public class MainActivity extends FragmentActivity{	
	public static ArrayList<Fragment> sFragment; //declare arraylist contains fragment
	public static ViewPager sViewPager; //declare viewpaper
	public static CustomAdapterFragment sAdapterFragment;	
	private ImageView mImgBtnBack; //ImageView button black
	
	/**
	 * This is onCreate Method
	 * The first function when activity starting, create a activity
	 * @param savedInstanceState
	 * @return void
	 */	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_contacts_main);
		//new ArrayList fragment
		sFragment = new ArrayList<Fragment>();
		//add fragment to array list
		sFragment.add(new ListContactFragment());
		//get support fragment manager
		sAdapterFragment = new CustomAdapterFragment(
				getSupportFragmentManager(), sFragment);
		sViewPager = (ViewPager) findViewById(R.id.viewpagerFragment);
		sViewPager.setAdapter(sAdapterFragment);
		sViewPager.setCurrentItem(0);
		
		//find id button Back
		mImgBtnBack = (ImageView) findViewById(R.id.imgBtnBack);
		mImgBtnBack.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish(); //return activity
			}
		});
	}
	
	
	

}
