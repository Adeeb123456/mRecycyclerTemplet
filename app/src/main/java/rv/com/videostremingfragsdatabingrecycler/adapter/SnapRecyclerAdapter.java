package rv.com.videostremingfragsdatabingrecycler.adapter;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.util.ArrayList;

import rv.com.videostremingfragsdatabingrecycler.BR;
import rv.com.videostremingfragsdatabingrecycler.R;
import rv.com.videostremingfragsdatabingrecycler.databinding.ItemVideoBinding;
import rv.com.videostremingfragsdatabingrecycler.model.VideoItem;


/**
 * Created by USER3 on 1/19/2017.
 */

public class SnapRecyclerAdapter extends RecyclerView.Adapter<SnapRecyclerAdapter.RecyclerViewHolder> implements View.OnClickListener {

    private LayoutInflater layoutInflater;
    private ArrayList<VideoItem> items;
    private onItemListener listener;

    public interface onItemListener {
        void onItemClicked(View v, int position);
    }

    public SnapRecyclerAdapter(ArrayList<VideoItem> items, onItemListener itemListener) {
        this.items = items;
        this.listener = itemListener;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        ItemVideoBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_video, parent, false);
        return new RecyclerViewHolder(binding.getRoot());


    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        final VideoItem item = items.get(position);
        holder.binding.setVariable(BR.videoItem, item);
        holder.binding.getRoot().setTag(R.id.tag_pos, position);
        holder.binding.getRoot().setOnClickListener(this);

        holder.binding.executePendingBindings();

    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onClick(View view) {
        int pos = (int) view.getTag(R.id.tag_pos);

        if (listener != null) {
            listener.onItemClicked(view, pos);
        }
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {

        ItemVideoBinding binding;


        private RecyclerViewHolder(View v) {
            super(v);
            binding = DataBindingUtil.bind(v);
            RelativeLayout.LayoutParams laytParam = (RelativeLayout.LayoutParams) binding.laytVideo.getLayoutParams();
            laytParam.width = v.getContext().getResources().getDisplayMetrics().widthPixels / 4;
            laytParam.height = v.getContext().getResources().getDisplayMetrics().widthPixels / 4;
            binding.tvTitle.getLayoutParams().width = laytParam.width;
        }


    }

    @BindingAdapter("font")
    public static void setFont(TextView textView,String fontName){
        textView.setTypeface(Typeface.createFromAsset(textView.getContext().getAssets(), "fonts/" + fontName));
    }

    @BindingAdapter("logoOrVideoUrl")
    public static void setThumbNail(ImageView imageView, String url) {
        try {

          //  Log.i("debug","laod thumnails url "+url);
          if(  url.startsWith("http://83.111.135.5:8080")){
            //  Log.i("debug"," url starts with ");
          }else {
            //  Log.i("debug","not start with");
              url = url.replace("http", "https");
          }


       /**     Picasso.with(imageView.getContext())
                    .load(url).placeholder(R.drawable.ic_image_holder).transform(new CircleTransform())
                    .fit()
                    .into(imageView);
        */

       imageView.setImageResource(Integer.parseInt(url));

        } catch (Exception e) {
           // Log.i("debug","error snapRecyclerAdapter "+e);
            e.printStackTrace();
            imageView.setImageResource(R.drawable.ic_menu_user);
        }
    }
}