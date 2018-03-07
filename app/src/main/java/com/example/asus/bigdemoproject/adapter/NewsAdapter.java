package com.example.asus.bigdemoproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.bigdemoproject.R;
import com.example.asus.bigdemoproject.bean.NewsBean;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by ASUS on 2017/12/27.
 */

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<NewsBean> mlist;
    private Context mcontext;
    private RecyclerView.ViewHolder holder;

    public NewsAdapter(List<NewsBean> mlist, Context mcontext) {
        this.mlist = mlist;
        this.mcontext = mcontext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        holder = null;
        if (viewType==0) {
            View inflate = LayoutInflater.from(mcontext).inflate(R.layout.item_type_0, parent, false);
            holder=new FirstView(inflate);
        }if(viewType==1) {

            View view = LayoutInflater.from(mcontext).inflate(R.layout.item_type_1, parent, false);
            holder= new OtherView(view);
        }
        return holder;
    }

    @Override
    public int getItemViewType(int position) {
        return mlist.get(position).getType();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type=mlist.get(position).getType();
        switch (type) {
        case 0:
        ((FirstView) holder).tv_title.setText(mlist.get(position).getTitle());
        String path0 = mlist.get(position).getPic().get(0).getThumbnail_pic();
        String path1 = mlist.get(position).getPic().get(1).getThumbnail_pic();
        String path2 = mlist.get(position).getPic().get(2).getThumbnail_pic();

        Picasso.with(mcontext).load(path0).into(((FirstView) holder).img_0);
        Picasso.with(mcontext).load(path1).into(((FirstView) holder).img_1);
        Picasso.with(mcontext).load(path2).into(((FirstView) holder).img_2);

        break;
        case 1:
        String otherpath0 = mlist.get(position).getPic().get(0).getThumbnail_pic();
        Picasso.with(mcontext).load(otherpath0).into(((OtherView) holder).img_4);
        ((OtherView) holder).tv_title2.setText(mlist.get(position).getTitle());
        break;
        }
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    class FirstView extends  RecyclerView.ViewHolder {

        private final ImageView img_0;
        private final ImageView img_1;
        private final ImageView img_2;
        private final TextView tv_title;

        public FirstView(View itemView) {
            super(itemView);
            img_0 = itemView.findViewById(R.id.img_0);
            img_1 = itemView.findViewById(R.id.img_1);
            img_2 = itemView.findViewById(R.id.img_2);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }

    class OtherView extends RecyclerView.ViewHolder {

        private final TextView tv_title2;
        private final ImageView img_4;

        public OtherView(View itemView) {
            super(itemView);
            tv_title2 = itemView.findViewById(R.id.tv_title2);
            img_4 = itemView.findViewById(R.id.img_4);
        }
    }
}
