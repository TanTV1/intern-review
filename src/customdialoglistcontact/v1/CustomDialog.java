package customdialoglistcontact.v1;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import asiantech.vn.v1.R;


/**
* This is class CustomDialog
* Use custom dialog form on the custom layouts you define which allow you to create and
* use your custom look and feel
* 
* @version 1.0
* @since 22-07-2015
* @author ThaiVanTan
* DATE         AUTHOR          	DESCRIPTION
* --------------------------------------------------------
* 22-July-2015 TanTV			Description of modification
*/
public class CustomDialog extends Dialog{

	public CustomDialog(Context context) {
		super(context);
	}
	public static class Builder {
		private Context context;
		private String iconUri;
		private String title;
		private String message;
		private String positiveBtnText;
		private String negativeBtnText;
		private View contentView;
		private DialogInterface.OnClickListener positiveBtnClickListener,
		negativeBtnClickListener;
		
		/**
		 * TODO Method constructor
		 * @param context
		 */
		public Builder(Context context) {
			this.context = context;
		}
		
		/**
		 * TODO Set the Dialog icon from String
		 * 
		 * @param icon
		 * @return 
		 */
		public Builder setIconUri(String icon) {
			this.iconUri = icon;
			return this;
		}
		
		/**
		 * TODO Set the Dialog icon from resource
		 * 
		 * @param icon
		 * @return 
		 */
		public Builder setIconUri(int icon) {
			this.iconUri = (String) context.getText(icon);
			return this;
		}
		
		/**
		 * TODO Set the Dialog message from String
		 * 
		 * @param message
		 * @return 
		 */
		public Builder setMessage(String message) {
			this.message = message;
			return this;
		}
		
		/**
		 * TODO Set the Dialog message from resource
		 * 
		 * @param message
		 * @return 
		 */
		public Builder setMessage(int message) {
			this.message = (String) context.getText(message);
			return this;
		}
		
		/**
		 * TODO Set the Dialog title from resource
		 * 
		 * @param title
		 * @return
		 */
		public Builder setTitle(int title) {
			this.title = (String) context.getText(title);
			return this;
		}
		
		/**
		 * Set the Dialog title from String
		 * 
		 * @param title
		 * @return
		 */
		public Builder setTitle(String title) {
			this.title = title;
			return this;
		}
		
		/**
		 * Set a custom content view for the Dialog. If a message is set, the
		 * contentView is not added to the Dialog...
		 * 
		 * @param v
		 * @return
		 */
		public Builder setContentView(View v) {
			this.contentView = v;
			return this;
		}

		/**
		 * Set the positive button resource and it's listener
		 * 
		 * @param positiveButtonText
		 * @param listener
		 * @return
		 */
		public Builder setPositiveButton(int positiveButtonText,
				DialogInterface.OnClickListener listener) {
			this.positiveBtnText = (String) context.getText(positiveButtonText);
			this.positiveBtnClickListener = listener;
			return this;
		}

		/**
		 * Set the positive button text and it's listener
		 * 
		 * @param positiveButtonText
		 * @param listener
		 * @return
		 */
		public Builder setPositiveButton(String positiveButtonText,
				DialogInterface.OnClickListener listener) {
			this.positiveBtnText = positiveButtonText;
			this.positiveBtnClickListener = listener;
			return this;
		}

		/**
		 * Set the positive button resource and it's listener
		 * 
		 * @param negativeButtonText
		 * @param listener
		 * @return
		 */
		public Builder setnegativeButton(int negativeButtonText,
				DialogInterface.OnClickListener listener) {
			this.negativeBtnText = (String) context.getText(negativeButtonText);
			this.negativeBtnClickListener = listener;
			return this;
		}

		/**
		 * Set the negative button text and it's listener
		 * 
		 * @param negativeButtonText
		 * @param listener
		 * @return
		 */
		public Builder setNegativeButton(String negativeButtonText,
				DialogInterface.OnClickListener listener) {
			this.negativeBtnText = negativeButtonText;
			this.negativeBtnClickListener = listener;
			return this;
		}

		/**
		 * Create the custom dialog
		 */
		public CustomDialog create() {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			// instantiate the dialog with the custom Theme
			final CustomDialog dialog = new CustomDialog(context);
			View layout = inflater.inflate(R.layout.dialog_list_contact, null);
			dialog.addContentView(layout, new LayoutParams(
					LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));

			// set the dialog icon
			if(iconUri != null && iconUri.length()>0){// Do not call this block of codes if we don't use setIcon
				int imgResource = context.getResources().getIdentifier(iconUri,
						null, context.getPackageName());			
				Drawable drawable = context.getResources().getDrawable(imgResource);
				((ImageView) layout.findViewById(R.id.custom_icon)).setBackgroundDrawable(drawable);
			}

			// set the dialog title
			((TextView) layout.findViewById(R.id.title)).setText(title);
			
			// set the confirm button
			if (positiveBtnText != null) {
				((Button) layout.findViewById(R.id.positive_btn))
						.setText(positiveBtnText);
				if (positiveBtnClickListener != null) {
					((Button) layout.findViewById(R.id.positive_btn))
							.setOnClickListener(new View.OnClickListener() {
								public void onClick(View v) {
									positiveBtnClickListener.onClick(dialog,
											DialogInterface.BUTTON_POSITIVE);
								}
							});
				}
			} else {
				// if no confirm button just set the visibility to GONE
				layout.findViewById(R.id.positive_btn).setVisibility(View.GONE);
			}
			
			// set the cancel button
			if (negativeBtnText != null) {
				((Button) layout.findViewById(R.id.negative_btn))
						.setText(negativeBtnText);
				if (negativeBtnClickListener != null) {
					((Button) layout.findViewById(R.id.negative_btn))
							.setOnClickListener(new View.OnClickListener() {
								public void onClick(View v) {
									negativeBtnClickListener.onClick(dialog,
											DialogInterface.BUTTON_NEGATIVE);
								}
							});
				}
			} else {
				// if no confirm button just set the visibility to GONE
				layout.findViewById(R.id.negative_btn).setVisibility(View.GONE);
			}
			// set the content message
			if (message != null) {
				((TextView) layout.findViewById(R.id.message)).setText(message);
			} else if (contentView != null) {
				// if no message set
				// add the contentView to the dialog body
				((LinearLayout) layout.findViewById(R.id.content))
						.removeAllViews();
				((LinearLayout) layout.findViewById(R.id.content)).addView(
						contentView, new LayoutParams(
								LayoutParams.WRAP_CONTENT,
								LayoutParams.WRAP_CONTENT));
			}
			dialog.setContentView(layout);
			return dialog;
		}
		
		
		
	}

}
