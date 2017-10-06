package couturier_crowe.android.hw4;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculateActivity extends AppCompatActivity {

    public static final int UNIT_SELECTION = 1;

    String distUnit = "kilometers";
    String bearUnit = "degrees";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EditText latitudep1 = (EditText) findViewById(R.id.latitudep1);
        EditText latitudep2 = (EditText) findViewById(R.id.latitudep2);
        EditText longitudep1 = (EditText) findViewById(R.id.longitudep1);
        EditText longitudep2 = (EditText) findViewById(R.id.longitudep2);

        Button calculate = (Button) findViewById(R.id.calculateButton);
        Button clear = (Button) findViewById(R.id.clearButton);

        TextView distance = (TextView) findViewById(R.id.distanceText);
        TextView bearing = (TextView) findViewById(R.id.bearingText);

 /*     // Trying to follow what was shown in the lectures.
        // Using "toolbar" instead of the button that was used in the example does not seem right,
        // but I'm not sure what else I should try.
        toolbar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalculateActivity.this, SettingsActivity.class);
                startActivityForResult(intent, UNIT_SELECTION);

                Intent payload = getIntent();
                if(payload.hasExtra("distances")) {
                    distUnit = payload.getStringExtra("distances");
                }
                if(payload.hasExtra("bearings")) {
                    bearUnit = payload.getStringExtra("bearings");
                }
            }
        });*/

        calculate.setOnClickListener(v -> {
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



            if(distUnit == "miles") {
                float dVal = distValue.floatValue();
                dVal = dVal * (float)0.6;
                String strDist = Float.toString(dVal);
                distance.setText("Distance: " + strDist + " miles");
            }
            if(distUnit == "kilometers") {
                String strDist = Float.toString(distValue.floatValue());
                distance.setText("Distance: " + strDist + " kilometers");
            }
            if(bearUnit == "mils") {
                float bVal = bearValue.floatValue();
                bVal = bVal * (float)17.77;
                String strBear = Float.toString(bVal);
                bearing.setText("Bearing: " + strBear + " mils");
            }
            if(bearUnit == "degrees") {
                String strBear = Float.toString(bearValue.floatValue());
                bearing.setText("Bearing: " + strBear + " degrees");
            }
        });

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
            startActivity(intent);
            finish();
            return true;
        }
        return false;
    }

}
