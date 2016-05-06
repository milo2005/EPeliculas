package movil.epeliculas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Date;

import movil.epeliculas.models.Pelicula;
import movil.epeliculas.util.C;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nombre, sinopsis;
    Button ok;
    Spinner categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nombre = (EditText) findViewById(R.id.nombre);
        sinopsis= (EditText) findViewById(R.id.sinopsis);

        ok = (Button) findViewById(R.id.btn_add);
        categoria = (Spinner) findViewById(R.id.categoria);

        ok.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Pelicula p =  new Pelicula();
        p.setSinopsis(sinopsis.getText().toString());
        p.setNombre(nombre.getText().toString());
        p.setFechaEstreno(new Date());
        p.setImagen("https://autismodiario.org/wp-content/uploads/2011/10/cine-sala.jpg");
        p.setCategoria(categoria.getSelectedItem().toString());

        C.data.add(p);

        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();

        return super.onOptionsItemSelected(item);
    }
}
