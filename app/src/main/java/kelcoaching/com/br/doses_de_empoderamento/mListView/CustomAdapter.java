package kelcoaching.com.br.doses_de_empoderamento.mListView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;

import kelcoaching.com.br.doses_de_empoderamento.BuildConfig;
import kelcoaching.com.br.doses_de_empoderamento.R;
import kelcoaching.com.br.doses_de_empoderamento.mData.Conteudo;
import kelcoaching.com.br.doses_de_empoderamento.mDetail.DetailActivity;


public class CustomAdapter extends BaseAdapter {

    Context c;
    ArrayList<Conteudo> conteudos;

    TextView nameTxt;
    TextView descricaoTxt;
    ImageView imgView;
    VideoView vidView;

    public static String PACKAGE_NAME;

    public CustomAdapter(Context c, ArrayList<Conteudo> conteudos){
        this.c = c;
        this.conteudos = conteudos;
    }

    @Override
    public int getCount() {
        return conteudos.size();
    }

    @Override
    public Object getItem(int position) {
        return conteudos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(c).inflate(R.layout.model,parent,false);
        }

        nameTxt = (TextView) convertView.findViewById(R.id.nameTxt);
        descricaoTxt = (TextView) convertView.findViewById(R.id.descricao);
        imgView = (ImageView) convertView.findViewById(R.id.image);
        vidView = (VideoView) convertView.findViewById(R.id.video);

        final String name = conteudos.get(position).getData();
        final String descricao = conteudos.get(position).getDescricao();
        final int image = conteudos.get(position).getIcon();
        final int video = conteudos.get(position).getVideo();

        //BIND DATA
        nameTxt.setText(name);
        if(video < 0 && image < 0){
            descricaoTxt.setVisibility(View.VISIBLE);
            imgView.setVisibility(View.INVISIBLE);
            vidView.setVisibility(View.INVISIBLE);
            descricaoTxt.setText(descricao);
        }else if(video < 0){
            imgView.setVisibility(View.VISIBLE);
            descricaoTxt.setVisibility(View.INVISIBLE);
            vidView.setVisibility(View.INVISIBLE);
            imgView.setImageResource(image);
        }else{
            vidView.setVisibility(View.VISIBLE);
            descricaoTxt.setVisibility(View.INVISIBLE);
            imgView.setVisibility(View.INVISIBLE);
            MediaController mediaController = new MediaController(c);
            vidView.setMediaController(mediaController);
            vidView.setVideoURI(Uri.parse("android.resource://" + BuildConfig.APPLICATION_ID + "/" + video));
            vidView.seekTo(10000);
            mediaController.setAnchorView(vidView);
        }


        //ITEMCLICK
        convertView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openDetailAcitivty(name,descricao,image,video);
            }
        });

        return convertView;
    }

    //OPEN DETAIL ACTIVITY AND PASS DATA
    private void openDetailAcitivty(String name, String descricao, int image, int video){
        Intent i = new Intent(c, DetailActivity.class);

          //PACK DATA
        i.putExtra("NAME_KEY", name);
        i.putExtra("DESC_KEY", descricao);
        i.putExtra("IMAGE_KEY", image);
        i.putExtra("VIDEO_KEY", video);

        //Open acitivity
        c.startActivity(i);
    }
}
