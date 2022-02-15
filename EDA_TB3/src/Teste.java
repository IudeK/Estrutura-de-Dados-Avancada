public class Teste {
    
public static void main(String[] args) {

Categorias x = new Categorias();

usuario Joao = new usuario("Joao",15);
usuario Pedro = new usuario("Pedro",20);

//é Criado o usuario sem categoria

Joao.GastosMensais.add(5000);
Joao.ComprasOnline.add(5000);
Joao.MilhasAcumuladas.add(5000);

x.VerificaCat(Joao);

System.out.println(Joao.getCategoriaAtual());


Pedro.GastosMensais.add(5000);
Pedro.ComprasOnline.add(5000);
Pedro.MilhasAcumuladas.add(5000);

x.VerificaCat(Pedro);

System.out.println(Pedro.getCategoriaAtual());


/*
//Entra na categoria bronze = 1
System.out.println(Joao.categoriaAtual);

Joao.GastosMensais.add(10000);
Joao.ComprasOnline.add(3000);
Joao.MilhasAcumuladas.add(5000);

x.VerificaCat(Joao);
// Entra na categoria prata = 2
System.out.println(Joao.categoriaAtual);
*/
/*
Joao.GastosMensais.add(20000);
Joao.ComprasOnline.add(8000);
Joao.MilhasAcumuladas.add(5000);
Joao.RestaurantesCadastrados.add(5);

x.VerificaCat(Joao);
//Entra na categoria ouro = 3
System.out.println(Joao.categoriaAtual);


/*

Joao.GastosMensais.add(50000);
Joao.ComprasOnline.add(12000);
Joao.MilhasAcumuladas.add(10000);
Joao.RestaurantesCadastrados.add(5);
Joao.AmigosIndicados.add(2);

x.VerificaCat(Joao);
// Entra na categoria diamante = 4
System.out.println(Joao.categoriaAtual);
*/

//x.add(Joao, Pedro);

x.add(Joao, Pedro);


} 
   
}
