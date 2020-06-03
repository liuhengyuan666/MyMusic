package cn.edu.scujcc.mymusic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LocalMusicAdapter extends RecyclerView.Adapter<LocalMusicAdapter.LocalMusicViewHolder> {
    Context context;
    List<LocalMusicBean>mDatas;

    public LocalMusicAdapter(Context context, List<LocalMusicBean> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
    }

    @NonNull
    @Override
    public LocalMusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.localmusic_list_item, parent, false);
        LocalMusicViewHolder holder = new LocalMusicViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull LocalMusicViewHolder holder, int position) {
        LocalMusicBean musicBean = mDatas.get(position);
        holder.musicName.setText(musicBean.getMusicName());
        holder.singer.setText(musicBean.getSinger());
        holder.duration.setText(musicBean.getDuration());
        holder.current_duration.setText(musicBean.getCurrent_duration());
        //holder.musicPicture.setImageDrawable(musicBean.getMusicPicture());
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class LocalMusicViewHolder extends RecyclerView.ViewHolder {
        TextView musicName, singer, duration, current_duration;
        ImageView musicPicture;
        public LocalMusicViewHolder(@NonNull View itemView) {
            super(itemView);
            musicName = itemView.findViewById(R.id.music_name);
            singer = itemView.findViewById(R.id.singer);
            duration = itemView.findViewById(R.id.duration);
            current_duration = itemView.findViewById(R.id.current_duration);
            musicPicture = itemView.findViewById(R.id.music_picture);
        }
    }
}
