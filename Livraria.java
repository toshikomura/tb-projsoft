import java.util.*;
import java.io.*;

class Livro extends Produto{

    protected String nome;
    protected String autor;
    protected String editora;
    protected int anopub;

    /* Construtor */
    public Livro( char tipo, float preco, int cod, int qtdestoque, String nome, String autor, String editora, int anopub){
        this.tipo = tipo;
        this.preco = preco;
        this.cod = cod;
        this.qtdestoque = qtdestoque;
        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
        this.anopub = anopub;
    }

    /* Metodos get and set */
    public String getnome(){
        return this.nome;
    }

    /* Metodo que imprime o produto */
    public void Imprime(){
        System.out.println("Livro");
        System.out.println("tipo: " + this.tipo);
        System.out.println("preço: " + this.preco);
        System.out.println("código: " + this.cod);
        System.out.println("quantidade no estoque: " + this.qtdestoque);
        System.out.println("nome: " + this.nome);
        System.out.println("autor: " + this.autor);
        System.out.println("editora: " + this.editora);
        System.out.println("ano de publicação: " + this.anopub);
    }

}

class Revista extends Produto{

    protected String nome;
    protected String editora;
    protected int mes;
    protected int ano;

    /* Construtor */
    public Revista( char tipo, float preco, int cod, int qtdestoque, String nome, String editora, int mes, int ano){
        this.tipo = tipo;
        this.preco = preco;
        this.cod = cod;
        this.qtdestoque = qtdestoque;
        this.nome = nome;
        this.editora = editora;
        this.mes = mes;
        this.ano = ano;
    }

    /* Metodo get and set */
    public String getnome(){
        return this.nome;
    }

    /* Metodo que imprime o produto */
    public void Imprime(){
        System.out.println("Revista");
        System.out.println("tipo: " + this.tipo);
        System.out.println("preço: " + this.preco);
        System.out.println("código: " + this.cod);
        System.out.println("quantidade no estoque: " + this.qtdestoque);
        System.out.println("nome: " + this.nome);
        System.out.println("editora: " + this.editora);
        System.out.println("mês: " + this.mes);
        System.out.println("ano: " + this.ano);
    }

}

class Caderno extends Produto{

    /* Construtor */
    public Caderno( char tipo, float preco, int cod, int qtdestoque){
        this.tipo = tipo;
        this.preco = preco;
        this.cod = cod;
        this.qtdestoque = qtdestoque;
    }

    /* Metodo que imprime o produto */
    public void Imprime(){
        System.out.println("Caderno");
        System.out.println("tipo: " + this.tipo);
        System.out.println("preço: " + this.preco);
        System.out.println("código: " + this.cod);
        System.out.println("quantidade no estoque: " + this.qtdestoque);
    }

}

class Produto {

    protected char tipo;
    protected int cod;
    protected float preco;
    protected String nome;
    protected int qtdestoque;

    /* Metodo get and set */
    public String getnome(){
        return this.nome;
    }

    public float getpreco(){
        return this.preco;
    }

    public int getcod(){
        return this.cod;
    }

    public char gettipo(){
        return this.tipo;
    }

    public int getqtdestoque(){
        return this.qtdestoque;
    }

    public void setqtdestoque( int qtdestoque){
        this.qtdestoque = qtdestoque;
    }

    /* Metodo que imprime o produto */
    public void Imprime(){

    }

}

class PgtoCartao extends Pagamento{

    protected int conta;
    protected int ag;
    protected int numbanc;

    /* Construtor */
    PgtoCartao( float valorrecebido){
        this.valorrecebido = valorrecebido;
    }

    /* Metodo set pagamento cartao */
    public void IncluiDadosBanc( int conta, int ag, int numbanc){
        //super.IncluiDadosBanc( conta, ag, numbanc);
        this.conta = conta;
        this.ag = ag;
        this.numbanc = numbanc;
    }
}

class PgtoDinheiro extends Pagamento{

    /* Construtor */
    PgtoDinheiro( float valorrecebido){
        this.valorrecebido = valorrecebido;
    }

}

class Pagamento {

    protected float valorrecebido;

    /* Metodo get e set */
    public float getvalorrecebido(){
        return this.valorrecebido;
    }

}

class Catalogo {

    protected ArrayList<Produto> produtos = new ArrayList<Produto>();

    /* Metodo que pesquisa um produto pelo codigo */
    Produto Pesquisar( int cod){

        if ( !produtos.isEmpty() ){
            for ( Produto prod : produtos ){
                if ( prod.getcod() == cod)
                    return prod;
            }
        }
        return null;
    }

    /* Metodo que pesquisa um produto pelo nome */
    Produto Pesquisar( String nome){

        if ( !produtos.isEmpty() ){
            for ( Produto prod : produtos ){
                if ( prod.getnome().equals( nome))
                    return prod;
            }
        }

        return null;
    }

    /* Metodo que pesquisa codigo existente */
    boolean PesquisaCodIgual( int cod){

        if ( !produtos.isEmpty() ){
            for ( Produto prod : produtos ){
                if ( prod.getcod() == cod)
                    return true;
            }
        }

        return false;
    }

    /* Metodo que cadastra produto que eh um Livro */
    void Cadastro( char tipo, float preco, int cod, int qtdestoque, String nome, String autor, String editora, int anopub){

        /* Adiciona o novo Livro no vetor de produtos */
        produtos.add( new Livro( tipo, preco, cod, qtdestoque, nome, autor, editora, anopub));
        System.out.println("Sucesso Livro Adicionado\n");

    }

    /* Metodo que cadastra produto que eh uma Revista */
    void Cadastro( char tipo, float preco, int cod, int qtdestoque, String nome, String editora, int mes, int ano){

        /* Adiciona a nova Revista no vetor de produtos */
        produtos.add( new Revista( tipo, preco, cod, qtdestoque, nome, editora, mes, ano));
        System.out.println("Sucesso Revista Adicionado\n");

    }

    /* Metodo que cadastra produto que e um Caderno */
    void Cadastro( char tipo, float preco, int cod, int qtdestoque){

        /* Adiciona o novo Caderno no vetor de produtos */
        produtos.add( new Caderno( tipo, preco, cod, qtdestoque));
        System.out.println("Sucesso Caderno Adicionado\n");

    }

}

class GerenciamentoProd {

    private boolean first = true;
    Catalogo c;
    Scanner scanner = new Scanner( System.in );

    /* Metodo que informa um produto para cadastro */
    void InformaProduto( char tipo, float preco, int cod, int qtdestoque, String nome, String autor, String editora, int mes, int ano){

        /* Se primeira vez que informa produto deve criar o Catalogo */
        if ( this.first){
            this.c = new Catalogo();
            this.first = false;
        }

        /* Verifica se o codigo informado ja existe */
        if (c.PesquisaCodIgual( cod)){
            System.out.println("\nCódigo informado já existe\n");
        }
        else{

            switch( tipo){
                case 'l':
                case 'L':
                    c.Cadastro( tipo, preco, cod, qtdestoque, nome, autor, editora, ano);

                    break;

                case 'r':
                case 'R':
                    c.Cadastro( tipo, preco, cod, qtdestoque, nome, editora, mes, ano);

                    break;

                case 'c':
                case 'C':
                    c.Cadastro( tipo, preco, cod, qtdestoque);

                    break;

                default:
                    System.out.println("Este não é um produto válido!\n");

            }

        }

    }

    /* Metodo para pesquisar um produto */
    Produto Pesquisar( char tipo, String nome, int cod){

        Produto prod = null;

        System.out.println("\n");

        /* Tipo de pesquisa, pode ser pelo nome ou pelo codigo */
        switch (tipo){

            case 'n':
            case 'N':

                prod = c.Pesquisar( nome);

                break;

            case 'c':
            case 'C':

                prod = c.Pesquisar( cod);

                break;

            default:
                System.out.println("\nEsse tipo de pesquisa é inválida!\n");
        }

        /* impressao do produto */
        if ( prod == null){
            System.out.println("\nEsse tipo de produto não existe\n");
            return null;
        }
        else{
            return prod;
        }

    }

}

/* Foi necessario criar essa classe para computar os produtos mais vendidos */
class Item{

    protected Produto prod;
    protected int qtdvendidos;

    /* Contrutor */
    Item( Produto prod, int qtdvendidos){
        this.prod = prod;
        this.qtdvendidos = qtdvendidos;
    }

    /* Metodo get and set */
    public int getqtdvendidos(){
        return this.qtdvendidos;
    }

    public Produto getprod(){
        return this.prod;
    }

    public void setqtdvendidos( int qtdvendidos){
        this.qtdvendidos = qtdvendidos;
    }

}

class RegistroVenda {

    protected Date data = new Date(System.currentTimeMillis());
    protected ArrayList<Item> itens = new ArrayList<Item>();
    protected Pagamento pgto;
    protected float total = 0;
    protected Produto prod = null;

    /* Metodos get e set */
    public Date getdata(){
        return this.data;
    }

    public Pagamento getpgto(){
        return this.pgto;
    }

    public float gettotal(){
        return this.total;
    }

    /* Metodo que adiciona um novo iten ao registro de venda */
    void ComunicaCodigo( int cod, int quantidade, char tipo, GerenciamentoProd g){

        boolean existe = false; // chuta que nao existe

        /* Se o gerenciamento ainda nao existe */
        if ( g == null) {

            System.out.println("Nenhum produto foi cadastrado");
        }
        else{

            /* Pesquisa diretamente o produto pelo codigo */
            prod = g.Pesquisar( 'c', null, cod);

            /* Se nao produto existe */
            if ( prod == null){

                System.out.println("Produto não encontrado\n");
            }
            else{

                if ( prod.getqtdestoque() - quantidade < 0){
                    System.out.println("A quantidade vendida é maior que a quantidade existente em estoque\n");
                }
                else{
                    /* Saiu uma quantidade de produtos do estoque */
                    prod.setqtdestoque( prod.getqtdestoque() - quantidade);

                    /* Verifica se o produto ja esta na lista */
                    if ( !itens.isEmpty() ){
                        for ( Item i : itens ){
                            if ( i.getprod().getcod() == prod.getcod()){
                                existe = true; // indica que existe
                                /* Acresta mais os produtos vendidos na lista */
                                i.setqtdvendidos( i.getqtdvendidos() + quantidade);
                            }
                        }
                    }

                    /* Adiciona um novo item ao vetor de itens */
                    if ( !existe){
                        itens.add( new Item( prod, quantidade));
                    }
                    System.out.println("Item adicionado com sucesso\n");
                }
            }
        }
    }

    /* Metodo que informa dados do pagamento */
    boolean InformaDadosPgto( float valor, char formapgto){

        if ( formapgto == 'c' || formapgto == 'C'){
            pgto = new PgtoCartao( valor);
            return true;
        }
        else{
            if ( formapgto == 'd' || formapgto == 'D'){
                pgto = new PgtoDinheiro( valor);
                return true;
            }
            else return false;
        }
    }

    /* Metodo que informa dados bancarios */
    void InformaDadosBanc( int conta, int ag, int numbanc){
        PgtoCartao pgtoc = ( PgtoCartao) pgto;
        pgtoc.IncluiDadosBanc( conta, ag, numbanc);
        pgto = pgtoc;
        System.out.println("cartão: " + pgtoc.conta + " " + pgtoc.ag + " " + pgtoc.numbanc);
    }

    /* Metodo que calcula o total de uma venda */
    void CalculaTotal(){

        for ( Item i : itens){
            total = total + ( i.getprod().getpreco() * i.getqtdvendidos());
        }
    }

}

/* Compara os objetos de item para auxiliar no sort em um Arraylist */
class Comparador implements Comparator<Item> {
    public int compare(Item o1, Item o2) {
        if (o1.qtdvendidos > o2.qtdvendidos) return -1;
        else if (o1.qtdvendidos < o2.qtdvendidos) return +1;
        else return 0;
    }
}

class RelatorioVenda {

    protected Date data = new Date(System.currentTimeMillis());
    protected int numero = 1;
    protected float totalgeral = 0;
    protected float trocogeral = 0;
    protected ArrayList<RegistroVenda> registros = new ArrayList<RegistroVenda>();

    /* Metodo que insere um registro no relatorio */
    void InsereRegistro( RegistroVenda r){
        registros.add( r);
    }

    /* Metodo que imprime o relatorio */
    void SolicitaRelatorioSemanal(){

        boolean existe = false; // chuta que nao existe
        int k = 1;
        float totalgeral = 0;
        ArrayList<Item> itensaux = new ArrayList<Item>();

        System.out.println("Carregando registros....");
        System.out.println("-----------------------------------------------");
        System.out.println("Relatório número: " + numero);
        numero += 1;
        System.out.println("Data do relatório: " + data);
        System.out.println("-----------------------------------------------\n");

        /* Para cada registro */
        for ( RegistroVenda r : registros ){

            System.out.println("-----------------------------------------------");
            System.out.println("venda: " + k);
            k += 1;
            System.out.println("data: " + r.getdata());

            System.out.println("-----------------------------------------------");
            System.out.println("cod tipo preço qtd");
            /* Para cada intem do registro */
            for ( Item i : r.itens ){

                /* Verifica se o produto ja esta na lista */
                if ( !itensaux.isEmpty() ){
                    for ( Item itenaux : itensaux ){
                        if ( itenaux.getprod().getcod() == i.getprod().getcod()){
                            existe = true; // indica que existe
                            /* Soma o valor que ja existe com a quantidade vendida do produto do registro atual */
                            itenaux.setqtdvendidos( itenaux.getqtdvendidos() + i.getqtdvendidos());
                        }
                    }
                }

                /* Se o produto ainda nao existe na lista */
                if ( !existe)
                    itensaux.add( i);

                totalgeral = totalgeral + ( i.getprod().getpreco() * i.getqtdvendidos() );
                System.out.println(i.getprod().getcod() + "   " + i.getprod().gettipo() + "    " + i.getprod().getpreco() + "  " + i.getqtdvendidos());
            }

            System.out.println("-----------------------------------------------");
            if ( r.getpgto() instanceof PgtoDinheiro)
                System.out.println("pagamento em: Dinheiro");
            else
                System.out.println("pagamento em: Cartão");
            System.out.println("Total: " + r.total);
            System.out.println("Pago:  " + r.getpgto().getvalorrecebido());
            System.out.println("Troco: " + ( r.getpgto().getvalorrecebido() - r.gettotal() ));

            System.out.println("-----------------------------------------------");
            System.out.println("\n");
            trocogeral = trocogeral + r.getpgto().getvalorrecebido() - r.gettotal();
        }

        System.out.println("-----------------------------------------------");
        System.out.println("Total Geral:  " + totalgeral);
        System.out.println("Troco Geral:  " + trocogeral);

        System.out.println("-----------------------------------------------\n");
        System.out.println("Mais vendidos foram:");


        /* Ordena os produtos mais vendidos */
        Collections.sort( itensaux, new Comparador());
        System.out.println("cod  preco  qtd");

        /* Imprime os itens mais vendidos em ordem decrescente */
        for ( Item i : itensaux){
            System.out.println( i.getprod().getcod() + "    " + i.getprod().getpreco() + "   " + i.getqtdvendidos()  );
        }

        System.out.println("-----------------------------------------------");
        System.out.println("Final do Relatório");
        System.out.println("-----------------------------------------------\n");

    }

}

class Livraria {

    private boolean initg = true; // Inicio para o Gerenciamento de venda
    private boolean initr = true; // Inicio para o Registro de venda
    private boolean initrel = true; // Inicio para o Relatório
    GerenciamentoProd g;
    RegistroVenda r;
    RelatorioVenda rel;
    Scanner scanner = new Scanner( System.in );

    /* Metodo que informa codigo e tipo para colocar no registro de venda */
    void ComunicaCodigo( int cod, int quantidade, char tipo){

        /* Se iniciou o registro de uma venda */
        if ( this.initr){
            this.r = new RegistroVenda();
            this.initr = false;
        }

        this.r.ComunicaCodigo( cod, quantidade, tipo, g);
    }

    /* Metodo que informa dados do pagamento */
    boolean InformaDadosPgto( float valor, char formapgto){

        return this.r.InformaDadosPgto( valor, formapgto);
    }

    /* Metodo que informa dados bancários */
    void InformaDadosBanc( int conta, int ag, int numbanc){

        this.r.InformaDadosBanc( conta, ag, numbanc);
    }

    /* Metodo que finaliza o Restro de uma venda */
    void FinalizaRegistroVenda(){

        /* Se o relatorio ainda nao existe */
        if ( this.initrel){
            this.rel = new RelatorioVenda ();
            this.initrel = false;
        }

        this.r.CalculaTotal();
        this.rel.InsereRegistro(r);
        this.initr = true;
        this.r = null;
    }

    /* Metodo que pesquisar um produto */
    Produto Pesquisar( char tipo, String nome, int cod){

        Produto prod = null;

        /* Se o gerenciamento de venda existe */
        if ( this.g != null){
            return prod = this.g.Pesquisar( tipo, nome, cod);
            //prod.Imprime();
        }
        else
            return null;
            //System.out.println("\nÉ necessário cadastrar um produto, para depois pesquisa-lo\n");
    }

    /* Metodo que informa dados para um novo produto */
    void InformaProduto( char tipo, float preco, int cod, int qtdestoque, String nome, String autor, String editora, int mes, int ano){

        int escolha;

        if ( this.initg){
            this.g = new GerenciamentoProd();
            this.initg = false;
        }

        this.g.InformaProduto( tipo, preco, cod, qtdestoque, nome, autor, editora, mes, ano);

    }

    /* Metodo que solicita um relatorio */
    void SolicitaRelatorioSemanal(){

        if ( this.rel != null){
            this.rel.SolicitaRelatorioSemanal();
            this.initrel = true;
            this.rel = null;
        }
        else
            System.out.println("Nenhuma venda foi registrada\n");
    }

}

class Programa {

    /* Funcao para Cadastrar um produto */
    public static void CadastrarProduto( Livraria l, Scanner scanner){

        char tipo;
        String nome = null;
        String autor = null;
        String editora = null;
        int cod;
        int mes = 0;
        int ano = 0;
        int qtdestoque;
        float preco;

        System.out.println("Você escolheu cadastrar um produto");
        System.out.println("Escolha o que você deseja fazer");
        System.out.println("l - Para cadastrar um Livro");
        System.out.println("r - Para cadastrar uma Revista");
        System.out.println("c - Para cadastrar um caderno");
        tipo = scanner.next().charAt(0);
        scanner.nextLine(); // Consome o /n
        System.out.println("\nDigite o código do produto");
        cod = scanner.nextInt();
        scanner.nextLine(); // Consome o /n
        System.out.println("Digite o preço do produto");
        preco = scanner.nextFloat();
        scanner.nextLine(); // Consome o /n
        System.out.println("Digite a quantidade no estoque do produto");
        qtdestoque = scanner.nextInt();
        scanner.nextLine(); // Consome o /n
        System.out.println("\n");

        /* Tipo de produto, pode ser Livro, Revista ou Caderno */
        switch (tipo){

            case 'l':
            case 'L':

                System.out.println("Livro");
                System.out.println("Digite o nome do livro!");
                nome = scanner.nextLine();
                System.out.println("Digite o nome do autor!");
                autor = scanner.nextLine();
                System.out.println("Digite o nome da editora!");
                editora = scanner.nextLine();
                System.out.println("Digite o ano de publicação!");
                ano = scanner.nextInt();
                scanner.nextLine(); // Consome o /n

                break;

            case 'r':
            case 'R':
                System.out.println("Revista");
                System.out.println("Digite o nome da revista!");
                nome = scanner.nextLine();
                System.out.println("Digite o nome da editora!");
                editora = scanner.nextLine();
                System.out.println("Digite o mes de publicação!");
                mes = scanner.nextInt();
                scanner.nextLine(); // Consome o /n
                System.out.println("Digite o ano de publicação!");
                ano = scanner.nextInt();
                scanner.nextLine(); // Consome o /n

                 break;

            case 'c':
            case 'C':
                System.out.println("Caderno");

                break;

            default:
                System.out.println("Este não é um produto válido!\n");

        }

        l.InformaProduto( tipo, preco, cod, qtdestoque, nome, autor, editora, mes, ano);

    }

    /* Funcao para pesquisar um produto pelo nome ou codigo */
    public static void PesquisarProduto( Livraria l, Scanner scanner){

        char tipo;
        String nome = null;
        int cod = 0;
        Produto prod = null;

        System.out.println("Você escolheu pesquisar um produto");
        System.out.println("Escolha o que você deseja fazer");
        System.out.println("n - Para pesquisar por nome");
        System.out.println("c - Para pesquisar por código");
        tipo = scanner.next().charAt(0);
        scanner.nextLine(); // Consome o /n
        System.out.println("\n");

        /* Tipo de pesquisa, pode ser pelo nome ou pelo codigo */
        switch ( tipo){

            case 'n':
            case 'N':
                System.out.println("Pesquisa por nome");
                System.out.println("Digite o nome do produto!");
                nome = scanner.nextLine();

                break;

            case 'c':
            case 'C':
                System.out.println("Pesquisa por código");
                System.out.println("Digite o código do produto!");
                cod = scanner.nextInt();
                scanner.nextLine(); // Consome o /n

                break;

            default:
                System.out.println("\nEsse tipo de pesquisa é inválida!\n");
        }


        prod = l.Pesquisar( tipo, nome, cod);
        if ( prod == null)
            System.out.println("\nÉ necessário cadastrar um produto, para depois pesquisa-lo\n");
        else
            prod.Imprime();

        System.out.println("\n");

    }

    /* Funcao para registrar uma venda */
    public static void RegristrarVenda( Livraria l, Scanner scanner){

        boolean formapgtofuncionou = false;
        char tipo, sim, formapagamento;
        int cod, quantidade, conta, ag, banc;
        float totalvenda;

        System.out.println("Você escolheu registrar uma venda");

        /* Vai inserindo todos os produtos */
        do{
            System.out.println("Digite o código do produto!");
            cod = scanner.nextInt();
            scanner.nextLine(); // Consome o /n
            System.out.println("Digite a quantidade que foi vendida!");
            quantidade = scanner.nextInt();
            scanner.nextLine(); // Consome o /n
            System.out.println("\nDigite o tipo do produto!");
            System.out.println("l - um Livro");
            System.out.println("r - uma Revista");
            System.out.println("c - um caderno");
            tipo = scanner.next().charAt(0);
            l.ComunicaCodigo( cod, quantidade, tipo);
            System.out.println("Terminou de inserir os produtos ? (s/n)");
            sim = scanner.next().charAt(0);
            System.out.println("\n");
        }while ( sim != 's');

        do{
            System.out.println("\nInforme os dados de pagamento");
            System.out.println("Forma de pagamento!");
            System.out.println("d - dinheiro");
            System.out.println("c - cartão");
            formapagamento = scanner.next().charAt(0);
            scanner.nextLine(); // Consome o /n
            System.out.println("\nValor pago pelo cliente");
            totalvenda = scanner.nextFloat();
            scanner.nextLine(); // Consome o /n

            formapgtofuncionou = l.InformaDadosPgto( totalvenda, formapagamento);
        }while( !formapgtofuncionou);
        System.out.println("\nDados de pagamento adicionado com sucesso");

        /* Se a forma de pagamento eh no cartao */
        if ( formapagamento == 'c' || formapagamento == 'C' ){

            System.out.println("Digite o número da conta!");
            conta = scanner.nextInt();
            scanner.nextLine(); // Consome o /n
            System.out.println("Digite o número da agência!");
            ag = scanner.nextInt();
            scanner.nextLine(); // Consome o /n
            System.out.println("Digite o número do banco!");
            banc = scanner.nextInt();
            scanner.nextLine(); // Consome o /n
            l.InformaDadosBanc( conta, ag, banc);
            System.out.println("Dados bancários adicionados com sucesso");
        }

        l.FinalizaRegistroVenda();
        System.out.println("\n");

    }

    /* Funcao para gerar um relatorio */
    public static void GerarRelatorio( Livraria l, Scanner scanner){

        System.out.println("Você escolheu gerar um relatório\n");

        l.SolicitaRelatorioSemanal();

    }

    /* Funcao main para fazer interface com o usuario */
    public static void main (String [] args ) {

        char tipo;

        int escolha = 1;
        Livraria l = new Livraria();
        Scanner scanner = new Scanner( System.in );

        while (escolha != 5){

            System.out.println("Escolha o que você deseja fazer");
            System.out.println("1 - Para cadastrar um produto");
            System.out.println("2 - Para pesquisar um produto");
            System.out.println("3 - Registrar uma venda");
            System.out.println("4 - Para gerar o relatório");
            System.out.println("5 - Para sair do programa");
            escolha = scanner.nextInt();
            scanner.nextLine(); // Consome o /n
            System.out.println("\n");

            /* tipo de funcionalidade da livraria, pode ser: */
            /* Cadastrar um produto */
            /* Pesquisar um produto */
            /* Registrar uma venda */
            /* Gerar um relatorio */
            /* Encerrar o programa */
            switch(escolha){
                case 1:
                    CadastrarProduto( l, scanner);

                    break;

                case 2:
                    PesquisarProduto( l, scanner);

                    break;

                case 3:
                    RegristrarVenda( l, scanner);

                   break;

                case 4:
                    GerarRelatorio( l, scanner);

                    break;

                case 5:
                    System.out.println("Você escolheu encerrar o programa\n");

                    break;

                default:
                    System.out.println("Opção inexistente\n");
            }

        }

    }

}
