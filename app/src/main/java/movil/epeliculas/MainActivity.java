package movil.epeliculas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import movil.epeliculas.adapters.PeliculaAdapter;
import movil.epeliculas.models.Pelicula;

public class MainActivity extends AppCompatActivity {

    List<Pelicula> data;
    PeliculaAdapter adapter;

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);

        data = new ArrayList<>();
        adapter= new PeliculaAdapter(this, data);

        list.setAdapter(adapter);
        loadPeliculas();

    }

    public void loadPeliculas(){
        Pelicula p1 = new Pelicula();
        p1.setNombre("Civil War");
        p1.setFechaEstreno(new Date());
        p1.setCategoria("Accion");
        p1.setSinopsis("Guerra entre Capitan America y Ironman");
        p1.setImagen("http://www.24horas.cl/incoming/capturajpg-1855006/ALTERNATES/w620h350/Captura.JPG");

        Pelicula p2 = new Pelicula();
        p2.setNombre("Batman v Superman");
        p2.setFechaEstreno(new Date());
        p2.setCategoria("Accion");
        p2.setSinopsis("Guerra entre Batman y Superman");
        p2.setImagen("http://www.ew.com/sites/default/files/styles/tout_image_gallery_612/public/i/2016/03/02/batman-v-superman-dawn-of-justice-000220568.jpg?itok=fYKcugql");

        Pelicula p3 = new Pelicula();
        p3.setNombre("Conjuro 2");
        p3.setFechaEstreno(new Date());
        p3.setCategoria("Terror");
        p3.setSinopsis("Pelicula de terror inspirada en sucesos reales");
        p3.setImagen("http://www.el-nacional.com/escenas/nueva-entrega-pelicula-estrenara-junio_NACIMA20160109_0049_19.jpg");

        data.add(p1);
        data.add(p2);
        data.add(p3);

        adapter.notifyDataSetChanged();


    }
}

