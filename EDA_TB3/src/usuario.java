public class usuario {

    private String nome;
    private int id;
    public HeapBinario<Integer> GastosMensais = new HeapBinario<Integer>(true);
    public HeapBinario<Integer> ComprasOnline = new HeapBinario<Integer>(true);
    public HeapBinario<Integer> MilhasAcumuladas = new HeapBinario<Integer>(true);
    public HeapBinario<Integer> RestaurantesCadastrados = new HeapBinario<Integer>(true);
    public HeapBinario <Integer> AmigosIndicados = new HeapBinario<Integer>(true);
    private int categoriaAtual;


    public usuario(String nome, int id){
        this.nome=nome;
        this.categoriaAtual=0;
        this.id=id;

    }

    

    public String getNome() {
        return nome;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public int getCategoriaAtual() {
        return categoriaAtual;
    }



    public void setCategoriaAtual(int categoriaAtual) {
        this.categoriaAtual = categoriaAtual;
    }



    public void adicionarGastos(int qtd){

        GastosMensais.add(qtd);

    }

    public void adicionarCompras(int qtd){

        ComprasOnline.add(qtd);

    }

    public void adicionarMilhas(int qtd){

        MilhasAcumuladas.add(qtd);

    }

    public void adicionarRestaurantes(int qtd){

        RestaurantesCadastrados.add(qtd);

    }

    public void adicionarAmigos(int qtd){

        AmigosIndicados.add(qtd);

    }


}
