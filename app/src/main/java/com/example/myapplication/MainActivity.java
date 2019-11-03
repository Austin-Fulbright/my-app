package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //*****start*****
    EditText weightInput;
    EditText repsInput;
    TextView calc;
    Button calcB;
    String weight;
    OneRepMax orm;
    int reps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        /*
         * Sets values equal to elements in the app
         * such as TextView and Button.
         */
        calcB = findViewById(R.id.Enter); //Button
        weightInput = findViewById(R.id.weight);//TextEdit
        repsInput = findViewById(R.id.rep);//TextEdit
        calc = findViewById(R.id.Calc);//TextView
        /*
         * This is the action event that you implement
         * for when the button is clicked
         */
        View.OnClickListener s = new View.OnClickListener(){
            /*
             * Implementation of the onClick function inside
             * OnClickListener functional interface.
             */
            public void onClick(View v){
                weight = weightInput.getText().toString();
                double d = Double.parseDouble(weight);
                reps = Integer.parseInt(repsInput.getText().toString());
                /*
                 * This is the one OneRepMax Calculator object
                 * That you implement with its constructor.
                 * It takes in parameters Integer reps and
                 * Weight used Double d.
                 */
                 orm = new OneRepMax(reps, d);
                 String ormS = "Bench 1rm: "+orm.getMax(); //calls function .getMax() from OneRepMax Object
                 calc.setText(ormS);
            }//onClick
        };//s
        calcB.setOnClickListener(s);
//*****End*****
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
