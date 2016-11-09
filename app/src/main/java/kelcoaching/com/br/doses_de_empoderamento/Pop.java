package kelcoaching.com.br.doses_de_empoderamento;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.VideoView;

/**
 * Created by lucasn on 07/10/2016.
 */
public class Pop extends Activity {

    ImageView img;
    VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popwindow);

        DisplayMetrics d = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(d);

        int width = d.widthPixels;
        int height = d.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.6));

        //RECEIVE DATA
        Intent i = this.getIntent();
        int image = i.getExtras().getInt("IMAGE_KEY");

        img = (ImageView) findViewById(R.id.pop);
        if(image >= 0 )
        img.setImageResource(image);

    }
}
