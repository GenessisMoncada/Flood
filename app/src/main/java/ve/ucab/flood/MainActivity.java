package ve.ucab.flood;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    //Primero que nada declarar las variables
    EditText editRio, editTelefono;
    Button botonSiguiente;
    RelativeLayout activityConfirmacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //2do Le doy valor a las variables
        editRio        = (EditText) findViewById(R.id.editarNombreRio);
        editTelefono   = (EditText) findViewById(R.id.editarTelefono);
        botonSiguiente = (Button) findViewById(R.id.boton_siguiente);
        activityConfirmacion = (RelativeLayout) findViewById(R.id.activity_confirmation2);

     //   SetOnclickListener

        botonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
     // Se validará que todos los campos estén llenos, sino error
                //Declaro las variables que va a leer c/campo
                String rio = null, telefono = null;
                Intent intent;
                boolean isDataValid = true;

                //Pregunto si el campo no esta vacío y le asigno ese valor a rio
                if(!editRio.getText().toString().equals("")){//devuelve true or false
                  rio = editRio.getText().toString();
                }
                else{//Si el campo esta vacio muestra error
                    editRio.setError("Este campo es obligatorio");
                    isDataValid = false;
                }

                //Pregunto si el campo no esta vacío y le asigno ese valor a telefono
                if(!editTelefono.getText().toString().equals("")){//devuelve true or false
                    telefono = editTelefono.getText().toString();
                }
                else{//Si el campo esta vacio muestra error
                    editTelefono.setError("Este campo es obligatorio");
                    isDataValid = false;
                }

                //Pregunto si data Valid está corrrecto; es decir, en true
                //Si está correcto entonces abrirá el nuevo activity

                if(isDataValid){

                    intent = new Intent(MainActivity.this,Confirmation2Activity.class);
                    intent.putExtra("rio",rio);
                    intent.putExtra("telefono",telefono);
                    startActivity(intent);
                }


            }
        });
    }

    @Override
    public void onBackPressed() {
            AlertDialog.Builder builder= new AlertDialog.Builder(this);
            builder.setMessage("¿Desea cerrar la aplicación?");
            builder.setTitle(" ");
            final Intent intent;
            Intent intent1;
            builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //estas lineas cierran la aplicación
                    android.os.Process.killProcess(android.os.Process.myPid());


                }
            });
            builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();
    }
}
