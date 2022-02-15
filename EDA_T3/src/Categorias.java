public class Categorias {

    UniaoBusca bronze = new UniaoBusca(3);
    UniaoBusca prata = new UniaoBusca(3);
    UniaoBusca ouro = new UniaoBusca(4);
    UniaoBusca diamante = new UniaoBusca(5);

    public void VerificaCat(usuario x) {

        int f = 0;
        int g = 0;
        int h = 0;
        int i = 0;
        int j = 0;

        while (true) {
            Integer a = x.GastosMensais.takeRoot();

            if (a != null) {
                f = f + a;
            } else {
                break;
            }
        }

        while (true) {
            Integer b = x.ComprasOnline.takeRoot();
            if (b != null) {
                g = g + b;
            } else {
                break;
            }
        }

        while (true) {
            Integer c = x.MilhasAcumuladas.takeRoot();
            if (c != null) {
                h = h + c;
            } else {
                break;
            }
        }

        while (true) {
            Integer d = x.RestaurantesCadastrados.takeRoot();
            if (d != null) {
                i = i + d;
            } else {
                break;
            }
        }

        while (true) {
            Integer e = x.AmigosIndicados.takeRoot();
            if (e != null) {
                j = j + e;
            } else {
                break;
            }
        }

        if ((f >= 5000) && (g >= 1000) && (h >= 2000) && (x.getCategoriaAtual() == 0)) {
            x.setCategoriaAtual(1);
        }
        else if ((f >= 10000) && (g >= 3000) && (h >= 5000) && (x.getCategoriaAtual() == 1)) {
            x.setCategoriaAtual(2);
        }

        else if ((f >= 20000) && (g >= 8000) && (h >= 5000) && (i >= 5) && (x.getCategoriaAtual() == 2)) {
            x.setCategoriaAtual(3);
        }

        else if ((f >= 50000) && (g >= 12000) && (h >= 10000) && (i >= 5) && (j >= 2) && (x.getCategoriaAtual() == 3)) {
            x.setCategoriaAtual(4);
        }
    }

    public void add(usuario a,usuario b){

        if((a.getCategoriaAtual()==b.getCategoriaAtual())&&(a.getCategoriaAtual()==1)){
            bronze.unionElements(a.getId(), b.getId());
        }
        if((a.getCategoriaAtual()==b.getCategoriaAtual())&&(a.getCategoriaAtual()==2)){
            prata.unionElements(a.getId(), b.getId());
        }
        if((a.getCategoriaAtual()==b.getCategoriaAtual())&&(a.getCategoriaAtual()==3)){
            ouro.unionElements(a.getId(), b.getId());
        }
        if((a.getCategoriaAtual()==b.getCategoriaAtual())&&(a.getCategoriaAtual()==4)){
            diamante.unionElements(a.getId(), b.getId());
        }
    }

}