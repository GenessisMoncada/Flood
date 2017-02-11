package ve.ucab.flood;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Confirmation2Activity extends AppCompatActivity {


    //declaro variables que voy a mostrar
    TextView tvRioIngresado, tvTelefonoIngresado;
    private static  final String TAG = Confirmation2Activity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation2);

        Bundle parametros = getIntent().getExtras();

        String rio      = parametros.getString("rio");
        String telefono = parametros.getString("telefono");

        tvRioIngresado = (TextView) findViewById(R.id.tvRioIngresado);
        tvTelefonoIngresado = (TextView) findViewById(R.id.tvTelefonoIngresado);

        tvRioIngresado.setText(rio);
        tvTelefonoIngresado.setText(telefono);

    }
//Aleterta para confirmar datos
    @Override
    public void onBackPressed() {
        Log.v(TAG, "onBackPressed");
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setMessage("¿Desea modificar los datos?");
        builder.setTitle(" ");
        builder.setPositiveButton("Modificar", new DialogInterface.OnClickListener() {
            Intent intent;
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                intent = new Intent(Confirmation2Activity.this,MainActivity.class);
                //con estas líneas se finaliza el activity
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();

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
