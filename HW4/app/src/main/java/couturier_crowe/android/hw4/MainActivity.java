package couturier_crowe.android.hw4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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

        calculate.setOnClickListener(v -> {
            //calculate and display the distance and bearings
        });

        clear.setOnClickListener(v -> {
            //clear the EditTexts
        });

    }
}
