package com.college.questions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


/**
 *  This project is an adaptation from Google Sample Code. It includes:
 * - Buttons for changing the background Color. (This is done)
 * - Buttons to count up and reset the Counter => TODO
 * - Save and Restaure Prefs button to store and retrieve current color and Counter => TODO
 */
public class MainActivity extends AppCompatActivity {
    // Current count.
    private int mCount = 0;
    // Current background color.
    private int mColor;
    // Text view to display both count and color.
    private TextView mShowCountTextView;

    // Key for current count
    private final String COUNT_KEY = "count";
    // Key for current color
    private final String COLOR_KEY = "color";

    // Shared preferences object
    private SharedPreferences mPreferences;
    // Name of shared preferences file
    private static final String mSharedPrefFile = "mysharedprefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views, color, preferences
        mShowCountTextView = findViewById(R.id.count_textview);
        mColor = ContextCompat.getColor(this, R.color.default_background);
        mPreferences = getSharedPreferences(mSharedPrefFile, MODE_PRIVATE);
    }

    /**
     * Handles the onClick for the background color buttons.
     * Gets background color of the button
     * that was clicked and sets the textview background to that color.
     * Saves the current background
     *
     * @param view The view (Button) that was clicked.
     */
    public void changeBackground(View view) {
        int color = ((ColorDrawable) view.getBackground()).getColor();
        mShowCountTextView.setBackgroundColor(color);
        mColor = color;
    }

    //TODO 1
    /**
     * Handles the onClick for the Count button.  Increments the value of the mCount global and
     * updates the textview.
     *
     * @param view The view (Button) that was clicked.
     */
    public void countUp(View view) {
        mCount +=1;
        mShowCountTextView.setText(Integer.toString(mCount));
    }

    //TODO 2
    /**
     * Handles the onClick for the Reset button.
     * Resets the global count and background
     * variables to the defaults, resets the views to those values,
     * and clears the shared preferences
     *
     * @param view The view (Button) that was clicked.
     */
    public void reset(View view) {
        mCount =0;
        mShowCountTextView.setText(Integer.toString(mCount));
        mColor = ContextCompat.getColor(this, R.color.default_background);
        mShowCountTextView.setBackgroundColor(mColor);
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.clear().apply();
    }

    //TODO 3
    /**
     * Handles the onClick for the 'Save Prefs' button.
     * Saves the Color and Counter to shared preferences
     *
     * @param view The view (Button) that was clicked.
     */
    public void savePrefs(View view) {
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putInt(COUNT_KEY, mCount);
        editor.putInt(COLOR_KEY,mColor);
        editor.apply();
        Log.d("Prefered Count and Color: ", mCount + " " + mColor);
        Toast.makeText(MainActivity.this,"preference saved.",Toast.LENGTH_SHORT).show();
    }

    //TODO 4
    /**
     * Handles the onClick for the 'Restaure Prefs' button.
     * Reads the Color and Counter from the Preferences
     * Updates the color and counter textviews.
     *
     * @param view The view (Button) that was clicked.
     */
    public void restaurePrefs(View view) {
        int defaultColor = ContextCompat.getColor(this, R.color.green_background);
        int restoredColor = mPreferences.getInt(COLOR_KEY,defaultColor);
        int restoredCount = mPreferences.getInt(COUNT_KEY,0);
        // Log the restored count and color
        Log.d("Restored Count and Color: ", restoredCount + " " + restoredColor);


        mShowCountTextView.setBackgroundColor(restoredColor);
        mShowCountTextView.setText(Integer.toString(restoredCount));

        mCount = restoredCount;
        mColor = restoredColor;


    }

}
