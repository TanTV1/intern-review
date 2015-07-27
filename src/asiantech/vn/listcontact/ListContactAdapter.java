package asiantech.vn.listcontact;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import asiantech.vn.main.MainActivity;
import asiantech.vn.v1.R;

/**
* This is class ListContactAdapter
* Class Adapter of ListContact 
* 
* @version 1.0
* @since 22-07-2015
* @author ThaiVanTan
* DATE         AUTHOR              DESCRIPTION
* --------------------------------------------------------
* 22-July-2015 TanTV            Description of modification
*/

public class ListContactAdapter extends BaseAdapter {
    private ArrayList<ListContactClass> mListContacts; // declare ArrayList contains Object in ListContactClass
    private Context mContext; // declare context , use contain context of MainAcitity

    /**
     * TODO method constructor
     * 
     * @param mListContacts
     * @param mContext
     */
    
    public ListContactAdapter(ArrayList<ListContactClass> mListContacts,Context mContext) {
        super();
        this.mListContacts = mListContacts;
        this.mContext = mContext;

    }

    /**
     * TODO method Count of Items
     * 
     * @return int
     */
    
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mListContacts.size();
    }

    /**
     * TODO Override
     */
    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * TODO Override
     */
    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * TODO Use contains Object of items This is class ViewHolder
     * 
     */
    
    class ViewHolder {
        ImageView imgAvatar; // declare imageview avatar
        TextView tvNamePerson; // declare textview name person
        ImageView imgBtnEdit; // declare imageview button Edit
        ImageView imgBtnDelete; // declare imageview button Delete
    }

    /***
     * TODO return view to set on Items Listview
     * 
     * @return View
     * @param position
     * @param convertView
     * @param parent
     * 
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ViewHolder holder; // declare object of Class ViewHolder
        
        if (convertView == null) { // it calls when item listview not scroll
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list_list_contacts_main, parent, false); // set layout custom
            holder = new ViewHolder(); // creare new object ViewHolder
            
            // return ID for child view
            holder.imgAvatar = (ImageView) convertView.findViewById(R.id.imgAvatar);
            holder.tvNamePerson = (TextView) convertView.findViewById(R.id.tv_name_contact_items);
            holder.imgBtnEdit = (ImageView) convertView.findViewById(R.id.imgBtnEdit);
            holder.imgBtnDelete = (ImageView) convertView.findViewById(R.id.imgBtnDelete);
            //
            convertView.setTag(holder); // set tag holder
        } else {
            holder = (ViewHolder) convertView.getTag(); // if holder is available , it calls to function getTag()
        }

        setValues(holder, position); // call method set values
        doActionButton(holder, position); // call medthod processing event click button
        return convertView; // return view
    }

    /**
     * 
     * TODO setValues for items in ListView
     * 
     * @param holder
     * @param position
     * 
     */
    private void setValues(ViewHolder holder, int position) {
        // get values and set values for items lisview
        holder.imgAvatar.setImageResource(mListContacts.get(position).getmIdAvatar());
        holder.tvNamePerson.setText(mListContacts.get(position).getmName());
    }

    /**
     * 
     * TODO This medthod is processing event when you click button edit and delete
     * 
     * @param holder
     * @param position
     * @return void
     */
    private void doActionButton(ViewHolder holder, final int position) {
        // button edit
        
        holder.imgBtnEdit.setOnClickListener(new OnClickListener() { // Button Edit Event
                    @Override
                    public void onClick(View v) {
                        // Call method static from MainActivity
                        // Send data using bundle
                        MainActivity.showFragmentEditContact(new ListContactClass(position,mListContacts));
                    }
                });

        // button delete
        holder.imgBtnDelete.setOnClickListener(new OnClickListener() { 
        	
                    @Override
                    public void onClick(View v) {
                        // call method show dialog
                        showDialog(position);
                    }
                });

    }

    /**
     * 
     * TODO display dialog Are you sure delete a contact
     * 
     * @param position
     * @return
     */
    public void showDialog(final int position) {
        AlertDialog.Builder alert = new Builder(mContext);
        alert.setMessage("Are you sure want to delete "+ mListContacts.get(position).getmName())
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        mListContacts.remove(position); // remove a object from
                                                        // arraylist
                        Toast.makeText(mContext,
                                "You delete a contact successful !",
                                Toast.LENGTH_SHORT).show();
                        notifyDataSetChanged();
                    }
                })
                .setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                    int which) {
                                dialog.dismiss();
                            }
                        });
        // Create alert dialog
        AlertDialog dialog = alert.create();
        // show dialog
        dialog.show();
        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        // opacity dialog
        params.alpha = 0.6f;
        dialog.getWindow().setAttributes(params);

    }
}
