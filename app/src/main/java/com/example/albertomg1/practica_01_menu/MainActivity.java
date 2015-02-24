package com.example.albertomg1.practica_01_menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;


public class MainActivity extends Activity {

    final public static String NOMBRE = "com.example.alberto.practica_01.nombre";
    final public static String APELLIDO = "com.example.alberto.practica_01.ape";
    final public static String SEXO = "com.example.alberto.practica_01.sexo";
    final public static String TRAB = "com.example.alberto.practica_01.trab";
    final public static String EST = "com.example.alberto.practica_01.est";
    final public static String UNI = "com.example.alberto.practica_01.uni";
    final public static String PESO = "com.example.alberto.practica_01.peso";
    final public static String FECHA = "com.example.alberto.practica_01.fecha";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar kg = (SeekBar) findViewById(R.id.Peso);
        TextView t1 = (TextView) findViewById(R.id.Pes);

        kg.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onStopTrackingTouch(SeekBar kg) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar kg) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar kg, int progress, boolean fromUser) {
                // TODO Auto-generated method stub

            }
        }
        );


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
        if (id == R.id.action_activity) {
            enviar(findViewById(id));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void enviar(View view){

        EditText namecontent = (EditText) findViewById(R.id.Name); //(EditText) -> Hacer un cast
        String name = namecontent.getText().toString();

        EditText surnamecontent = (EditText) findViewById(R.id.Surname);
        String surname = surnamecontent.getText().toString();

        RadioGroup sexcontent = (RadioGroup) findViewById(R.id.radioSex);
        int selected_radio = sexcontent.getCheckedRadioButtonId();
        RadioButton radio_sex_button = (RadioButton) findViewById(selected_radio);
        String sex = radio_sex_button.getText().toString();

        CheckBox jobcontent = (CheckBox) findViewById(R.id.trab);
        String job = "No treballa";
        CheckBox studycontent = (CheckBox) findViewById(R.id.est);
        String study = "No estudia";

        if (jobcontent.isChecked()) {
            job = "Treballa";
        }

        if (studycontent.isChecked()) {
            study = "Estudia";
        }

        ToggleButton togleboton = (ToggleButton) findViewById(R.id.togglebutton);
        String uni = "No té estudis universitaris";

        if (togleboton.isChecked()){
            uni = "Té estudis universitaris";
        }

        SeekBar kg = (SeekBar) findViewById(R.id.Peso);
        int weight = kg.getProgress();

        EditText borncontent = (EditText) findViewById(R.id.data);
        String born = borncontent.getText().toString();


        Intent in= new Intent(this,MainActivity2.class);
        in.putExtra(NOMBRE, name);
        in.putExtra(APELLIDO, surname);
        in.putExtra(SEXO, sex);
        in.putExtra(TRAB, job);
        in.putExtra(EST, study);
        in.putExtra(UNI, uni);
        in.putExtra(PESO, weight);
        in.putExtra(FECHA, born);
        startActivity(in);

    }
}
