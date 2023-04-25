package wrs.WARES.TestsWares;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.WARES.tests.R;

class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    private String[] names;
    private int[] imageIds;
    private Context mContext;


    public Adapter(String[] names, int[] imageIds, Context context) {
        this.names = names;
        this.imageIds = imageIds;
        mContext = context;
    }
    public int getItemCount(){
        return names.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;


        public ViewHolder(CardView v){
            super(v);
            cardView = v;

        }
    }
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.cards, parent, false);
        return new ViewHolder(cv);
    }

    public void onBindViewHolder(ViewHolder holder, final int position){

        final CardView cardView = holder.cardView;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.info_image);
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(names[position]);
        TextView textView = (TextView) cardView.findViewById(R.id.info_text);
        textView.setText(names[position]);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position)
                {
                    case 0:
                        Intent intent = new Intent(mContext, Psycho.class);
                        mContext.startActivity(intent);
                        return;
                    case 1:
                        Intent intent2 = new Intent(mContext, Brain.class);
                        mContext.startActivity(intent2);
                        return;
                    case 2:
                        Intent intent3 = new Intent(mContext, Pciho.class);
                        mContext.startActivity(intent3);
                        return;
                    case 3:
                        Intent intent4 = new Intent(mContext, OpenExplanation.class);
                        mContext.startActivity(intent4);
                        return;
                    case 4:
                        Intent intent5 = new Intent(mContext, Donate.class);
                        mContext.startActivity(intent5);
                        return;
                }

            }
        });
    }

}

