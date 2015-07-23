package asiantech.vn.v1;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
* This is class CustomAdapterFragment
* Class user load fragment for display viewpager
* 
* @version 1.0
* @since 22-07-2015
* @author ThaiVanTan
* DATE         AUTHOR          	DESCRIPTION
* --------------------------------------------------------
* 22-July-2015 TanTV			Description of modification
*/
public class CustomAdapterFragment extends FragmentStatePagerAdapter {
	private ArrayList<Fragment> mFragment; //ArrayList fragment from ActivityMain

	/**
	 * TODO method constructor CustomAdapterFragment
	 * @param fm
	 * @param fragment
	 */
	public CustomAdapterFragment(android.support.v4.app.FragmentManager fm,ArrayList<Fragment> fragment) {
		super(fm);
		this.mFragment = fragment;
	}

	/**
	 * TODO Method return fragment , that need display
	 * @return fragment
	 * @param possition
	 */
	@Override
	public Fragment getItem(int possition) {
		// TODO Auto-generated method stub
		for (int i=0;i<mFragment.size();i++){
			if (possition==i) return mFragment.get(i);
		}
			
		return null;
	}

	/**
	 * @TODO Method return number of framgment
	 * @return int
	 * @param 
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mFragment.size();
	}

}
