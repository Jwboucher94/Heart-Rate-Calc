package com.example.jack.heartrate;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends ActionBarActivity {

    TextView textMaxView;
    TextView textLowView;
    TextView textHighView;
    private int usrAge;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editAgeText =
                (EditText) findViewById(R.id.editAgeText);
        textMaxView =
                (TextView) findViewById(R.id.textMaxView);
        textLowView =
                (TextView) findViewById(R.id.textLowView);
        textHighView =
                (TextView) findViewById(R.id.textHighView);
        editAgeText.addTextChangedListener(ageTextWatcher);
        updateAll();
    }

    private TextWatcher ageTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try
            {
                usrAge = Integer.parseInt(s.toString());
            }
            catch (NumberFormatException e)
            {
                usrAge = 0;
            }
            updateAll();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void updateAll() {
        int max = updateMax();
        textMaxView.setText(Integer.toString(max));
        int low = updateLow(max);
        textLowView.setText(Integer.toString(low));
        int high = updateHigh(max);
        textHighView.setText(Integer.toString(high));
    }

    private int updateMax() {
        return 220-usrAge;
    }
    private int updateLow(int max) {
        return max/2;
    }
    private int updateHigh(int max) {
        return (int) (max * .85);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
