package games.dev.matchme;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.IllegalCharsetNameException;
import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {
    static MyAdapter Instance ;
    public int id;
    public int gridId;
    public int firstId;
    public int nextId;
    public int firstGridId;
    public int nextGridId;
    public static int sc;
    private Context mContext;
    private List<Items.Items1> mImageIds;
    private final LayoutInflater mInflater;

    private static final List<Items.Items1> matched = new ArrayList<Items.Items1>(){{
        add(new Items.Items1(1,R.drawable.background1));
    }};
    public MyAdapter(Context mContext, List<Items.Items1> mImageIds) {
        mInflater = LayoutInflater.from(mContext);
        Instance = this;
        this.mContext = mContext;
        this.mImageIds = mImageIds;
    }

    @Override
    public int getCount() {
        return mImageIds.size();
    }

    @Override
    public Items.Items1 getItem(int i) {
        return mImageIds.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mImageIds.get(i).drawableId;
    }



    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        View v = view;
        final ImageView picture;
        final TextView score;
        TextView name;


        if (v == null) {
            v = mInflater.inflate(R.layout.grid_item, viewGroup, false);
            v.setTag(R.id.picture, v.findViewById(R.id.picture));
           // v.setTag(R.id.score, v.findViewById(R.id.score));
        }


        picture = (ImageView) v.getTag(R.id.picture);
        score = (TextView) v.getTag(R.id.score);

        final Items.Items1 item = getItem(i);

        picture.setImageResource(item.drawableId);

         { //for(int j = 0; j <2 ;j++) {
             picture.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     id = item.drawableId;
                     gridId = i;
                     //Toast.makeText(mContext, "this is id " + id + " this is grid Id" + gridId, Toast.LENGTH_SHORT).show();


                     getValue(id, gridId);

                 }

                 private void getValue(int id, int gridId) {

                     firstId = id;
                     firstGridId = gridId;
                     if(firstId==nextId && nextGridId!=firstGridId){
                              //Toast.makeText(mContext,"MATCH FOUND",Toast.LENGTH_SHORT).show();

                             incrementScore();
                       //  getData();
                              picture.setImageResource(0);






                     }
                     nextGridId = firstGridId;
                     nextId = firstId;
                 }




             });
         }


       // }
       //picture.setOnClickListener(null);

        return v;
    }
    public  static MyAdapter getActivityInstance()
    {
        return Instance;
    }
    public void incrementScore(){
        sc++;
        //Intent intent = new Intent(MyAdapter.this,MainActivity.class);

       // intent.putExtra("Score",sc);
      //  startActivity(intent);

    }
    public static int getData()
    {
        return sc;
    }





}
