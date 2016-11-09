package kelcoaching.com.br.doses_de_empoderamento.mData;

import kelcoaching.com.br.doses_de_empoderamento.R;

/**
 * Created by Administrator on 14/09/2016.
 */
public class Conteudo {

    public int id;
    public String data = "01/01/2016";
    public String descricao = "Uma possível descrição de um conteúdo postado no dia tal";
    public int icon = R.drawable.logo;
    public int video = R.raw.kelvideo;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getVideo() {
        return video;
    }

    public void setVideo(int video) {
        this.video = video;
    }
}
