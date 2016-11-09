package kelcoaching.com.br.doses_de_empoderamento.mData;

import java.util.ArrayList;

import kelcoaching.com.br.doses_de_empoderamento.R;


public class ConteudoCollection {

    public static ArrayList<Conteudo> getConteudo(){
        ArrayList<Conteudo> conteudos = new ArrayList<>();
        Conteudo conteudo = null;

        //ADD DATA TO COLLECTION
        conteudo = new Conteudo();
        conteudo.setData("08-11-2016");
        conteudo.setIcon(R.drawable.img1);
        conteudo.setVideo(-1);
        conteudo.setDescricao("\"Ouse fazer diferentre, e o poder lhe será dado!\"");
        conteudos.add(conteudo);

        conteudo = new Conteudo();
        conteudo.setData("05-11-2016");
        conteudo.setIcon(-1);
        conteudo.setVideo(R.raw.kelvideo);
        conteudo.setDescricao("\"Nunca aceite menos do que você merece!\"");
        conteudos.add(conteudo);

        conteudo = new Conteudo();
        conteudo.setData("29-07-2016");
        conteudo.setIcon(-1);
        conteudo.setVideo(-1);
        conteudo.setDescricao("\"Sorte é apelido, o verdadeiro nome do sucesso chama-se dedicação!\"");
        conteudos.add(conteudo);

        conteudo = new Conteudo();
        conteudo.setData("15-05-2016");
        conteudo.setIcon(R.drawable.img2);
        conteudo.setVideo(-1);
        conteudo.setDescricao("\"Daqui a um ano, você vai desejar ter começado hoje!\"");
        conteudos.add(conteudo);

        return conteudos;
    }
}
