package games.dev.matchme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import org.w3c.dom.Text;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridView = (GridView)findViewById(R.id.Grid_view_images);
        MyAdapter mAdapter = new MyAdapter(getApplicationContext() , Items.getImages());
        gridView.setAdapter(mAdapter);




    }

    public void checkScore(){
        TextView score = (TextView)findViewById(R.id.score);
        int data = MyAdapter.getData();
        MyAdapter mAdapter = new MyAdapter(getApplicationContext() , Items.getImages());
        while(data!=0){
        data = mAdapter.getData();
        score.setText("Score = "+data);

    }}

    @Override
    protected void onResume() {

        super.onResume();
        checkScore();
    }

}
