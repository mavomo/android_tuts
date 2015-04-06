package codepath.github.com.boxofficemovies.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import codepath.github.com.boxofficemovies.R;
import codepath.github.com.boxofficemovies.model.AbrigedCast;
import codepath.github.com.boxofficemovies.model.BoxOffice;
import codepath.github.com.boxofficemovies.model.Movie;
import codepath.github.com.boxofficemovies.networking.volley.BoxOfficeMoviesApi;


/**
 * Created by Michelle on 14/03/2015.
 */
public class BoxOfficeMoviesAdapter extends BaseAdapter implements Response.Listener<BoxOffice>,Response.ErrorListener {

    private final String TAG = "BoxOfficeMoviesAdapter";

    private Context mContext;

    private List<Movie> movies;
    private NetworkImageView mNetworkImageView;
    private ImageLoader mImageLoader;


    private BoxOfficeMoviesApi boxOfficeMoviesApi;
    private final String URL_MOVIES = "lists/movies/box_office.json";
    /**
     * Constructor
     *
     * @param context  The current context.
     */
    public BoxOfficeMoviesAdapter(Context context,List<Movie> boxOfficeMovies) {
        this.mContext = context;
        this.movies = boxOfficeMovies;
        boxOfficeMoviesApi = new BoxOfficeMoviesApi(context);
        mImageLoader = boxOfficeMoviesApi.getImageLoader();
        fetchData(URL_MOVIES);
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
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.item_box_office_movie, parent,false);

            //initialize the view holder
            viewHolder = new ViewHolder();
            viewHolder.ivPosterImage = (NetworkImageView) convertView.findViewById(R.id.ivPosterImage);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.tvCast = (TextView) convertView.findViewById(R.id.tvCast);
            viewHolder.tvCriticsScore = (TextView) convertView.findViewById(R.id.tvCriticsScore);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        Movie movie = getItem(position);

        //Lookup views within item layout
        String title = movie.getTitle();
        String criticScore = movie.getRatings().getCriticsScore();
        List<AbrigedCast> actors = movie.getCasting();
        String thumbnailUrl = movie.getPosters().getThumbmail();

        viewHolder.tvTitle.setText(title);
        viewHolder.tvCriticsScore.setText("" + criticScore + "%");
        viewHolder.tvCast.setText(" " + StringUtils.join(actors, ','));
        viewHolder.ivPosterImage.setImageUrl(thumbnailUrl, mImageLoader);


        return convertView;
    }

    public void fetchData (String url){
        Log.i(TAG, " fetching data");
        boxOfficeMoviesApi.requestMovies(URL_MOVIES, this, this);
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Movie getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public void onErrorResponse(VolleyError error) {
        VolleyLog.e(error, "Unable to load box office movie");
    }

    @Override
    public void onResponse(BoxOffice movieInstance) {
        movies.addAll(movieInstance.getMovies());
        notifyDataSetChanged();

    }

    static class ViewHolder {
        TextView tvTitle;
        TextView tvCriticsScore;
        TextView tvCast;
        NetworkImageView ivPosterImage;
    }


}
