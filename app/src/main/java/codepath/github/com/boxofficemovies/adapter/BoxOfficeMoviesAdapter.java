package codepath.github.com.boxofficemovies.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import codepath.github.com.boxofficemovies.R;
import codepath.github.com.boxofficemovies.model.BoxOfficeMovie;

/**
 * Created by Michelle on 14/03/2015.
 */
public class BoxOfficeMoviesAdapter extends ArrayAdapter<BoxOfficeMovie> {
    private List<BoxOfficeMovie> movies;
    private final String TAG = "BoxOfficeMoviesAdapter";
    /**
     * Constructor
     *
     * @param context  The current context.
     * @param movies  The movies to represent in the ListView.
     */
    public BoxOfficeMoviesAdapter(Context context, List<BoxOfficeMovie> movies) {
        super(context,R.layout.item_box_office_movie, movies);
        this.movies = movies;
    }

    /**
     * Translate a particular '@BoxOfficeMovie' given a position into a relevant row within an adapterView
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Log.i(TAG, " entering getView method");

        ViewHolder viewHolder;

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_box_office_movie, parent,false);

            //initialize the view holder
            viewHolder = new ViewHolder();
            viewHolder.ivPosterImage = (ImageView) convertView.findViewById(R.id.ivPosterImage);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.tvCast = (TextView) convertView.findViewById(R.id.tvCast);
            viewHolder.tvCriticsScore = (TextView) convertView.findViewById(R.id.tvCriticsScore);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        BoxOfficeMovie movie = getItem(position);

        //Lookup views within item layout
        viewHolder.tvTitle.setText(movie.getTitle());
        viewHolder.tvCriticsScore.setText("" + movie.getCriticScore() + "%");
        viewHolder.tvCast.setText(" "+ movie.getCastList());
        Picasso.with(getContext()).load(movie.getPosterUrl()).into(viewHolder.ivPosterImage);

        return convertView;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public BoxOfficeMovie getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder {
        TextView tvTitle;
        TextView tvCriticsScore;
        TextView tvCast;
        ImageView ivPosterImage;
        int position;
    }


}
