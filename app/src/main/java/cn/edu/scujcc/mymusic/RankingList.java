package cn.edu.scujcc.mymusic;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RankingList extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Album> mList;
    public RankingList(List<Album> list){
        mList = list;
    }

    @NonNull
    @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_ranking_list, parent, false);
            RecyclerView.ViewHolder holder = new MyViewHolder(item);
            return holder;
        }
    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int position) {
        final MyViewHolder holder = (MyViewHolder) viewHolder;
        Album album = mList.get(position);
        String imgPath = album.getAlbumImgPath();
        ImgChangeToBitMap task = new ImgChangeToBitMap(holder.cover);
        task.execute(imgPath);

        holder.top1.setText("1."+album.getTop1());
        holder.top2.setText("2."+album.getTop2());
        holder.top3.setText("3."+album.getTop3());

    }

    @Override
    public int getItemCount() {
        return mList == null?0:mList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView cover;
        TextView top1;
        TextView top2;
        TextView top3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cover = itemView.findViewById(R.id.cover);
            top1 = itemView.findViewById(R.id.top1);
            top2 = itemView.findViewById(R.id.top2);
            top3 = itemView.findViewById(R.id.top3);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onItemClickListener != null){
                        onItemClickListener.onItemClick(v, mList.get(getLayoutPosition()), getLayoutPosition());
                    }
                }
            });
        }

    }

    public interface OnItemClickListener{
        public void onItemClick(View view, Album album, int position);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
}

