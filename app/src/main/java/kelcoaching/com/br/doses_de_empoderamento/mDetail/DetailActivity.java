package kelcoaching.com.br.doses_de_empoderamento.mDetail;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import kelcoaching.com.br.doses_de_empoderamento.Pop;
import kelcoaching.com.br.doses_de_empoderamento.R;

/**
 * Created by anderson.deoliveira on 10/10/2016.
 */

public class DetailActivity extends AppCompatActivity{

    TextView nameTxt;
    ImageView img;
    String name;
    int image;
    int video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetailActivity.this, Pop.class);
                i.putExtra("IMAGE_KEY", image);
                startActivity(i);
            }
        });

        Context context = this;
        collapsingToolbarLayout.setContentScrimColor(ContextCompat.getColor(context, R.color.colorPrimary));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //INITIALIZE VIEWS
        nameTxt = (TextView) findViewById(R.id.description);
        img = (ImageView) findViewById(R.id.imgView);

        //RECEIVE DATA
        Intent i = this.getIntent();
        name = i.getExtras().getString("DESC_KEY");
        image = i.getExtras().getInt("IMAGE_KEY");
        video = i.getExtras().getInt("VIDEO_KEY");

        //BIND DATA
        nameTxt.setText(name);
        if(image >=0)
        img.setImageResource(image);
    }

}
