package couturier_crowe.android.hw4;

import android.icu.math.BigDecimal;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText latitudep1 = (EditText) findViewById(R.id.latitudep1);
        EditText latitudep2 = (EditText) findViewById(R.id.latitudep2);
        EditText longitudep1 = (EditText) findViewById(R.id.longitudep1);
        EditText longitudep2 = (EditText) findViewById(R.id.longitudep2);

        Button calculate = (Button) findViewById(R.id.calculateButton);
        Button clear = (Button) findViewById(R.id.clearButton);

        TextView distance = (TextView) findViewById(R.id.distanceText);
        TextView bearing = (TextView) findViewById(R.id.bearingText);

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

            String strDist = Float.toString(distValue.floatValue());
            distance.setText("Distance: " + strDist + " kilometers");
            String strBear = Float.toString(bearValue.floatValue());
            bearing.setText("Bearing: " + strBear + " degrees");
        });

        clear.setOnClickListener(v -> {
            //clear the EditTexts
        });

    }
}
