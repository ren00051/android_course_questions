package com.college.questions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * The ImplicitIntents app contains buttons for sending implicit intents:
 * - Open a URL in a browser
 * - Find a location on a map
 * - Share a text string
 * - View the Contacts
 * - Dial a number
 */
public class MainActivity extends AppCompatActivity {

    private final String LOG_TAG = "MainActivity";
    // EditText view for the website URI
    private EditText mWebsiteEditText;
    // EditText view for the location URI
    private EditText mLocationEditText;
    // EditText view for the share text
    private EditText mShareTextEditText;
    //EditText for Dial action
    private EditText mDialEditText;

    /**
     * Initializes the activity.
     *
     * @param savedInstanceState The current state data
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebsiteEditText = findViewById(R.id.website_edittext);
        mLocationEditText = findViewById(R.id.location_editext);
        mShareTextEditText = findViewById(R.id.share_edittext);
        mDialEditText = findViewById(R.id.phone_edittext);

        Button btnWeb = findViewById(R.id.open_website_button);
        Button btnLocation = findViewById(R.id.open_location_button);
        Button btnText = findViewById(R.id.share_text_button);
        Button btnContact = findViewById(R.id.call_log_button);
        Button btnDial = findViewById(R.id.dial_button);

//        btnWeb.setOnClickListener(btn ->{
//            openWebsite(btn);
//        });
//
//        btnLocation.setOnClickListener(btn->{
//            openLocation(btn);
//        });
    }

    // TODO

    /**
     * Handles the onClick for the "Open Website" button.  Gets the URI
     * from the edit text and sends an implicit intent for that URL.
     *
     * @param view The view (Button) that was clicked.
     */
    public void openWebsite(View view) {
        // Get the URL string from the mWebsiteEditText view
        String url = mWebsiteEditText.getText().toString();

        // Create a new Intent with the action ACTION_VIEW
        Intent i = new Intent(Intent.ACTION_VIEW);

        // Set the data URI of the Intent to the URL parsed into a Uri object
        i.setData(Uri.parse(url));

        // Start the activity specified by the Intent, which will open the URL
        startActivity(i);
    }


    // TODO

    /**
     * Handles the onClick for the "Open Location" button.  Gets the location
     * text from the edit text and sends an implicit intent for that location.
     * <p>
     * The location text can be any searchable geographic location.
     *
     * @param view The view (Button) that was clicked.
     */
    public void openLocation(View view) {
        String location = mLocationEditText.getText().toString();
        Uri locationUri = Uri.parse("geo:0,0?q=" + location);

        Intent intent = new Intent(Intent.ACTION_VIEW, locationUri);
        //intent.setPackage("com.google.android.apps.maps");
        // Find an activity to hand the intent and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }

    }

    // TODO

    /**
     * Handles the onClick for the "Share This Text" button.  The
     * implicit intent here is created by the  {@link ShareCompat.IntentBuilder}
     * class.  An app chooser appears with the available options for sharing.
     * <p>
     * ShareCompat.IntentBuilder is from the v4 Support Library.
     *
     * @param view The view (Button) that was clicked.
     */
    public void shareText(View view) {
        String txt = mShareTextEditText.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(R.string.edittext_share)
                .setText(txt)
                .startChooser();
    }



    // TODO
    /**
     * Handles the onClick for the "Dial" button.
     *
     * @param view The view (Button) that was clicked.
     */
    public void dial(View view) {
        String phoneNumber = mDialEditText.getText().toString();
        String urlPhone = "tel:" + phoneNumber;
        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
        dialIntent.setData(Uri.parse(urlPhone));
        startActivity(dialIntent);
    }


    // TODO
    /**
     * Handles the onClick for the "View Contacts" button.
     *
     * @param view The view (Button) that was clicked.
     */
    public void viewContact(View view) {
        // Create an Intent with the ACTION_VIEW action to view contacts
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("content://contacts/people/"));

        // Start the activity with the contacts app
        startActivity(intent);

    }

}
