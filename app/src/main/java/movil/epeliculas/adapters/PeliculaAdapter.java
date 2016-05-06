package movil.epeliculas.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import movil.epeliculas.R;
import movil.epeliculas.models.Pelicula;

/**
 * Created by Dario Chamorro on 4/05/2016.
 */
public class PeliculaAdapter extends BaseAdapter {

    Context context;
    List<Pelicula> data;
    SimpleDateFormat format;

    public PeliculaAdapter(Context context, List<Pelicula> data) {
        this.context = context;
        this.data = data;
        format =  new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if(v == null)
            v = View.inflate(context
                    , R.layout.template_pelicula, null);

        Pelicula p = data.get(position);

        TextView nombre = (TextView) v.findViewById(R.id.nombre);
        TextView categoria = (TextView) v.findViewById(R.id.categoria);
        TextView sinopsis = (TextView) v.findViewById(R.id.sinopsis);
        TextView estreno = (TextView) v.findViewById(R.id.estreno);
        ImageView img = (ImageView) v.findViewById(R.id.img);

        nombre.setText(p.getNombre());
        categoria.setText(p.getCategoria());
        sinopsis.setText(p.getSinopsis());
        estreno.setText(format.format(p.getFechaEstreno()));

        Picasso.with(context)
                .load(Uri.parse(p.getImagen()))
                .into(img);

        return v;
    }
}
