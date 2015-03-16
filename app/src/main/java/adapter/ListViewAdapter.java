package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.androidheroes.butterknifeproject.R;
import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by kerry on 11/03/15.
 */
public class ListViewAdapter extends BaseAdapter {

    LayoutInflater inflater;

    public ListViewAdapter(LayoutInflater inflater){
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        View view = inflater.inflate(R.layout.list_view_item, parent, false);

        holder = new ViewHolder(view);

        /* Don't worry about the images, Picasso will handle it for you */
        Picasso.with(inflater.getContext())
            .load("http://lorempixel.com/200/200/sports/" + (position+1))
            .into(holder.image);

        holder.text.setText("This is a text for the image number: "+position);

        return view;
    }

    /*
        This class is going to contain the views from the list_view_item layout
    */
    static class ViewHolder{
        @InjectView(R.id.image_in_item)
        ImageView image;
        @InjectView(R.id.textview_in_item)
        TextView text;

        public ViewHolder(View view){

            /* For this injection you have to specify the source of the views */
            ButterKnife.inject(this, view);
        }
    }
}
