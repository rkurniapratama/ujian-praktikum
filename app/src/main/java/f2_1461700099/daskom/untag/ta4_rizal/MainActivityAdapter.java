package f2_1461700099.daskom.untag.ta4_rizal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.amulyakhare.textdrawable.TextDrawable;

import java.util.ArrayList;
import java.util.Random;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<Data> mData;
    private MainActivityPresenter mPresenter;
    private String[] mColors = {
            "#39add1", // light blue
            "#3079ab", // dark blue
            "#c25975", // mauve
            "#e15258", // red
            "#f9845b", // orange
            "#838cc7", // lavender
            "#7d669e", // purple
            "#53bbb4", // aqua
            "#51b46d", // green
            "#e0ab18", // mustard
            "#637a91", // dark gray
            "#f092b0", // pink
            "#b7c0c7"  // light gray
    };

    public MainActivityAdapter(Context mContext, ArrayList<Data> mData, MainActivityPresenter mPresenter) {
        this.mContext = mContext;
        this.mData = mData;
        this.mPresenter = mPresenter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_main_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tvLabelNama.setText("Nama");
        holder.tvNama.setText(mData.get(position).getNama());
        holder.tvLabelMobile.setText("Mobile");
        holder.tvMobile.setText(mData.get(position).getMobile());
        holder.tvLabelEmail.setText("Email");
        holder.tvEmail.setText(mData.get(position).getEmail());
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(mData.get(position).getNama().substring(0,1).toUpperCase(), getColor());
        holder.ivTextDrawable.setImageDrawable(drawable);
        holder.cvMahasiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getPosition(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (mData != null) ? mData.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvLabelNama, tvNama, tvLabelMobile, tvMobile, tvLabelEmail, tvEmail;
        private ImageView ivTextDrawable;
        private CardView cvMahasiswa;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvLabelNama = (TextView) itemView.findViewById(R.id.tvLabelNama);
            tvNama = (TextView) itemView.findViewById(R.id.tvNama);
            tvLabelMobile = (TextView) itemView.findViewById(R.id.tvLabelMobile);
            tvMobile = (TextView) itemView.findViewById(R.id.tvMobile);
            tvLabelEmail = (TextView) itemView.findViewById(R.id.tvLabelEmail);
            tvEmail = (TextView) itemView.findViewById(R.id.tvEmail);
            ivTextDrawable = (ImageView) itemView.findViewById(R.id.ivTextDrawable);
            cvMahasiswa = (CardView) itemView.findViewById(R.id.cvMahasiswa);
        }
    }

    private int getColor() {
        String color;

        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(mColors.length);

        color = mColors[randomNumber];
        int colorAsInt = Color.parseColor(color);

        return colorAsInt;
    }
}
