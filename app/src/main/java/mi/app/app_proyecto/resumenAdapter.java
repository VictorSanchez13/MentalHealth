package mi.app.app_proyecto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class resumenAdapter extends ArrayAdapter<itemClass> {
    public resumenAdapter(Context context, itemClass[] itemList) {
        super(context, 0, itemList);
    }

    public resumenAdapter(Context context, java.util.List<itemClass> itemList) {
        super(context, 0, itemList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        itemClass item = getItem(position);
        View v = LayoutInflater.from(getContext()).inflate(R.layout.texto_lista, parent,false);
        TextView tv = (TextView) v.findViewById(R.id.elemento);

        if (item.texto != null){
            tv.setText(item.texto + " (" +item.valor +" USA)");
        }
        return v;
    }

}