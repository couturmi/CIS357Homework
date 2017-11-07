package couturier_crowe.android.hw4;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.joda.time.DateTime;

import couturier_crowe.android.hw4.dummy.HistoryContent;

public class CalculateActivity extends AppCompatActivity {

    public static final int SETTINGS_RESULT = 1;

    public static final int HISTORY_RESULT = 2;


    String distUnit = "kilometers";
    String bearUnit = "degrees";

    EditText latitudep1;
    EditText latitudep2;
    EditText longitudep1;
    EditText longitudep2;

    TextView distance;
    TextView bearing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        latitudep1 = (EditText) findViewById(R.id.latitudep1);
        latitudep2 = (EditText) findViewById(R.id.latitudep2);
        longitudep1 = (EditText) findViewById(R.id.longitudep1);
        longitudep2 = (EditText) findViewById(R.id.longitudep2);

        Button calculate = (Button) findViewById(R.id.calculateButton);
        Button clear = (Button) findViewById(R.id.clearButton);

        distance = (TextView) findViewById(R.id.distanceText);
        bearing = (TextView) findViewById(R.id.bearingText);

        calculate.setOnClickListener(view -> this.makeCalculations());

        clear.setOnClickListener(v -> {
            latitudep1.setText("");
            latitudep2.setText("");
            longitudep1.setText("");
            longitudep2.setText("");
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.settings) {
            Intent intent = new Intent(CalculateActivity.this, SettingsActivity.class);
            startActivityForResult(intent, SETTINGS_RESULT); //UNIT_SELECTION
            return true;
        }else if(item.getItemId() == R.id.action_history) {
            Intent intent = new Intent(CalculateActivity.this, HistoryActivity.class);
            startActivityForResult(intent, HISTORY_RESULT );
            return true;
        }
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == SETTINGS_RESULT) {
            distUnit = data.getStringExtra("distance");
            bearUnit = data.getStringExtra("bearing");
            makeCalculations();
            System.out.println("DIST: "+distUnit);
        }else if (resultCode == HISTORY_RESULT) {
            String[] vals = data.getStringArrayExtra("item");
            this.latitudep1.setText(vals[0]);
            this.longitudep1.setText(vals[1]);
            this.latitudep2.setText(vals[2]);
            this.longitudep2.setText(vals[3]);
            this.makeCalculations();  // code that updates the calcs.
        }
    }

    public void makeCalculations() {
        if(anyInputsEmpty()){
            distance.setText("Distance: Please enter data in all fields");
            bearing.setText("Bearing: Please enter data in all fields");
            return;
        }
        float[] results = new float[2];
        //results[0] is distance in meters
        //results[1] is bearing in degrees

        String strLatP1 = latitudep1.getText().toString();
        String strLatP2 = latitudep2.getText().toString();
        String strLongP1 = longitudep1.getText().toString();
        String strLongP2 = longitudep2.getText().toString();

        double latP1 = Double.parseDouble(strLatP1);
        double latP2 = Double.parseDouble(strLatP2);
        double longP1 = Double.parseDouble(strLongP1);
        double longP2 = Double.parseDouble(strLongP2);

        Location.distanceBetween(latP1, longP1, latP2, longP2, results);

        java.math.BigDecimal distValue = new java.math.BigDecimal(Float.toString((results[0] / 1000)));
        distValue = distValue.setScale(2, java.math.BigDecimal.ROUND_HALF_UP);

        java.math.BigDecimal bearValue = new java.math.BigDecimal(Float.toString(results[1]));
        bearValue = bearValue.setScale(2, java.math.BigDecimal.ROUND_HALF_UP);

        if(distUnit.equals("miles")) {
            float dVal = distValue.floatValue();
            dVal = dVal * (float)0.6;
            String strDist = Float.toString(dVal);
            distance.setText("Distance: " + strDist + " miles");
        }
        else if(distUnit.equals("kilometers")) {
            String strDist = Float.toString(distValue.floatValue());
            distance.setText("Distance: " + strDist + " kilometers");
        }
        if(bearUnit.equals("mils")) {
            float bVal = bearValue.floatValue();
            bVal = bVal * (float)17.77;
            String strBear = Float.toString(bVal);
            bearing.setText("Bearing: " + strBear + " mils");
        }
        else if(bearUnit.equals("degrees")) {
            String strBear = Float.toString(bearValue.floatValue());
            bearing.setText("Bearing: " + strBear + " degrees");
        }
        HistoryContent.HistoryItem item = new HistoryContent.HistoryItem(strLatP1.toString(),
                strLongP1.toString(), strLatP2.toString(), strLongP2.toString(), DateTime.now());
        HistoryContent.addItem(item);
    }

    private boolean anyInputsEmpty() {
        if(latitudep1.getText() == null || latitudep1.getText().toString().matches("")) {
            return true;
        }
        if(latitudep2.getText() == null || latitudep2.getText().toString().matches("")) {
            return true;
        }
        if(longitudep1.getText() == null || longitudep1.getText().toString().matches("")) {
            return true;
        }
        if(longitudep2.getText() == null || longitudep2.getText().toString().matches("")) {
            return true;
        }
        return false;
    }

}
