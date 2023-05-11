package com.example.ferrari;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] listaTitulos = {"Ferrari 456", "Ferrari 308 GTB", "Ferrari F40", "Ferrari F50", "Ferrari F355",
            "Ferrari 550", "Ferrari Enzo", "Ferrari F430", "Ferrari FF", "Ferrari LaFerrari"};

    int[] listaIcones = {R.drawable.car1, R.drawable.car2, R.drawable.car3, R.drawable.car4, R.drawable.car5,
            R.drawable.car6, R.drawable.car7, R.drawable.car8, R.drawable.car9, R.drawable.car10};

    String[] listaDescricao = {"A 456 é um automóvel grand tourer da Ferrari. Equipado com motor V12, teve duas versões bases: a primeira, produzida até 1997, denominada apenas 456 e uma segunda versão, denominada 456M (a da foto), produzida de 1998 a 2003",
            "Apresentado em 1975 no Salão do Automóvel de Paris, a Pininfarina usou para produzir o 308 GTB componentes mecânicos do 308 GT4 e teve sua inspiração estilística do 246 GT e 365 GT4 BB.",
            "A Ferrari F40 é um automóvel superesportivo coupé de duas portas, de tração traseira e motor central-traseiro, projetado com conceitos aerodinâmicos utilizados em carros de competição. Porém, seu foco de vendas era estritamente comercial, não sendo planejado para corridas.",
            "A Ferrari F50 é um supercarro de motor central-traseiro, duas portas, roadster, produzido pela marca italiana Ferrari que foi apresentado em 1995 para celebrar o quinquagésimo aniversário da companhia. O carro possui motor aspirado de 4.7L V12 com 60 válvulas (3 de admissão e 2 de exaustão por cilindro), que levava o carro à velocidade máxima de 328 km/h.",
            "O Ferrari F355 é um carro desportivo construído pela Ferrari entre 1994 e 1999. É uma evolução do Ferrari 348, e foi substituído pelo Ferrari 360. Seguindo a linha de sucesso dos modelos de entrada da marca, o F355 é coupé V8 de motor central e dois lugares.",
            "A 550 Maranello é um super esportivo da Ferrari equipado com motor V12 5.5 DOHC de 485cv, e atinge a velocidade máxima de 320 km/h. O número do modelo refere-se ao deslocamento total do motor (5.5 litros) e o nome do modelo de Maranello refere-se à cidade onde a sede da Ferrari estão localizados.",
            "O carro foi desenvolvido em 2002 com tecnologias usadas na Fórmula 1.  Recebeu o nome do criador da companhia, Enzo Anselmo Ferrari. O motor 6.0 V12 com 48 válvulas foi o primeiro da nova geração da Ferrari. O seu desenho é baseado no V8 do Maserati Quattroporte.",
            "O design do F430 foi desenvolvido em conjunto pela Ferrari e pelo estúdio Pininfarina. O estilo se inspira em antigos carros de corrida, com destaque para o modelo 1961, campeão do mundo de Fórmula 1 com Phil Hill, e também nos modernos - na traseira, ele é uma cópia reduzida do modelo Enzo.",
            "O modelo foi a primeira Ferrari para quatro adultos. O motor, um V12 6.3 de 660 cv. O modelo causou polêmica por utilizar um sistema de tração nas quatro rodas, tecnologia condenada pelos puristas da marca.",
            "É o primeiro modelo com tecnologia híbrida da marca. A associação de um motor V12 6.3 traseiro de 800 cv a um elétrico de 163 cv entrega a potência combinada de 963 cv. O câmbio é automatizado de sete marchas e a máxima de 350 km/h. Com 499 unidades, ela ainda está em produção, mas os exemplares já se esgotaram."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

}

// Classe que declara os componentes que utilizaremos
class ViewCarros{
    ImageView imageIcone;
    TextView titulo, descricao;
}

class CarrosFerrari{

    private int icone;
    private String titulo;
    private String descricao;

    public CarrosFerrari(int icone, String titulo, String descricao) {
        this.icone = icone;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public int getIcone() {
        return icone;
    }

    public void setIcone(int icone) {
        this.icone = icone;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

/* Essa classe por padrão inclui o:
    -> construtor MeuAdapter
    -> add()
    -> getCount()
    -> getView()

OBS. É possível criar esses métodos com o auxílio da IDE através do generate.
OBS. No caso, vai ser implementado apenas a Classe getView - para mostrar o conteúdo na tela.
*/
class MeuAdapter extends ArrayAdapter{


    public MeuAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(@Nullable Object object) {
        super.add(object);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

        // Criando atributo da minha View
        View minhaView;
        minhaView = convertView;

        // Criando um atributo para a Classe ViewCarro
        ViewCarros viewCarros;

        if(convertView == null){

            //Inflar os itens na tela
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            minhaView = inflater.inflate(R.layout.minha_celula, parent, false);

            // Instanciando os componentes do layout minha_celula e colocando na minha view
            viewCarros = new ViewCarros();
            viewCarros.imageIcone = minhaView.findViewById(R.id.imageIcone);
            viewCarros.titulo = minhaView.findViewById(R.id.textTitulo);

            minhaView.setTag(viewCarros);

        }else{

            viewCarros = (ViewCarros) minhaView.getTag();
        }

        // Criando um atributo para a Classe CarrosFerrari
        CarrosFerrari carrosFerrari;

        // Define a quantidade de itens
        carrosFerrari = (CarrosFerrari) this.getItem(position);

        viewCarros.imageIcone.setImageResource(carrosFerrari.getIcone());
        viewCarros.titulo.setText(carrosFerrari.getTitulo());

        return minhaView;
    }
}


/* No Androidmanifest.xml vamos modificar o tema para NoActionBar, faremos a seguinte modificação:
* android:theme="@style/Theme.AppCompat.Light.NoActionBar"
*
* ------------------------------------------------------------------------------------------------
*
* Entendendo o processo de criação entre a ListView e o Adapter
*
* O ListView quando é criado, pergunta ao Adapter qual é a quantidade de itens que ele terá, e recebe a resposta
* atráves do método getCount().
*
* Quando recebe a quantidade ele começa a se preparar para exibir os itens, vendo a quantidade que caberá na tela,
* vamos imaginar que sejam apenas 5 itens qua possam ser exibidos, nisso o Android vai inflar esses 5 itens e vai
* devolver para o ListView através do método getView(), além disso o Android acaba inflando mais duas views, para
* reaproveitarmos.
*
* Está view que é criada para reaproveitamento é a view que recebemos como parâmetro no método getView(), chamamos
* ela de convertView.
* */