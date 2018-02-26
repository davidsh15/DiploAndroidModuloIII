package mx.unam.aragon.fes.diplo.mod3pracrdsh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private String colegios[]= new String[0];
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colegios= new String[]{"FES ARAGON","FES IZTACALA","UNAM CU","TEC MTY"};
        spinner= (Spinner) findViewById(R.id.spinner);
        addColegios(colegios);

        startNewActivity();
    }

    private void startNewActivity(){
        Button boton= (Button) findViewById(R.id.button);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), Main2Activity.class);

                EditText usuario= (EditText) findViewById(R.id.editText);
                EditText pwd=(EditText) findViewById(R.id.editText2);

                String pUsuario=usuario.getText().toString();
                String pPwd=  pwd.getText().toString();
                String pColegio = spinner.getSelectedItem().toString();

                intent.putExtra("USER",pUsuario);
                intent.putExtra("PWD",pPwd);
                intent.putExtra("COLEGE", pColegio);


                startActivity(intent);;
            }
        });
    }

    private void addColegios(String[] colors){
        ArrayAdapter<String> spinnerArrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, colegios);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);
    }

}
