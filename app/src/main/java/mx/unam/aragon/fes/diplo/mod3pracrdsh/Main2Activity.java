package mx.unam.aragon.fes.diplo.mod3pracrdsh;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }else{
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Intent intent= getIntent();
        String usuario= intent.getStringExtra("USER");
        String pwd= intent.getStringExtra("PWD");
        String colegio= intent.getStringExtra("COLEGE");
        String bienvenida;

        //Validamos el usuario y contraseña
        if (validaPwd(pwd)){
            bienvenida = "BIENVENIDO "+usuario+" DEL COLEGIO: "+ colegio;
        }else{
            bienvenida= "USUARIO INVALIDO";
        }



        TextView txtBox= (TextView) findViewById(R.id.textView4);
        txtBox.setText(bienvenida);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private boolean validaPwd(String pwd){
        if (pwd.equals("admin123")){
            return true;
        }else{
            return false;
        }
    }

}
