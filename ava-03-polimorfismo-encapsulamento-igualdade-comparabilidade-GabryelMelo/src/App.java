import modelo.Dinheiro;
import modelo.Veiculo;
import modelo.Data;
import java.util.Arrays;

public class App {
  public static void main(String[] args) {

    System.out.println("Olá mundo!");

    //Casos de teste
    Dinheiro d1 = new Dinheiro(); // construtor vazio significa R$ 0,00
    System.out.println(d1.getReais() == 0);
    System.out.println(d1.getCentavos() == 0);

    Dinheiro d3 = new Dinheiro(3, 45); // três reais e 45 centavos
    System.out.println(d3.getReais() == 3);
    System.out.println(d3.getCentavos() == 45);

    Dinheiro d2 = new Dinheiro(d3); // d2 recebe os valores de d3, R$ 3,45
    System.out.println(d2.getReais() == 3);
    System.out.println(d2.getCentavos() == 45);

    Dinheiro d4 = new Dinheiro(200); // duzentos reais
    System.out.println(d4.getReais() == 200);
    System.out.println(d4.getCentavos() == 0);

    Dinheiro d5 = new Dinheiro("R$ 345,75"); // trezentos e quarenta e cinco reais e setenta e cinco centavos
    System.out.println(d5.getReais() == 345);
    System.out.println(d5.getCentavos() == 75);

    Dinheiro d6 = new Dinheiro("R$ 1.000.000,11"); // um milhão de reais com onze centavos
    System.out.println(d6.getReais() == 1000000);
    System.out.println(d6.getCentavos() == 11);

    Dinheiro d7 = new Dinheiro("R$ 2.567,89");
    System.out.println(d7.getReais() == 2567);
    System.out.println(d7.getCentavos() == 89);

    Dinheiro d8 = new Dinheiro(9.75);
    System.out.println(d8.getReais() == 9);
    System.out.println(d8.getCentavos() == 75);

    Dinheiro d9 = new Dinheiro(17.569); // dezessete reais e cinquenta e seis centavos -- é truncado nas duas casas, não arredondado!
    System.out.println(d9.getReais() == 17);
    System.out.println(d9.getCentavos() == 56);

    //Sobrecarga do método somar
    d3.somar(d4); // somar o valor de d4 em d3
    System.out.println(d3.getReais() == 203);
    System.out.println(d3.getCentavos() == 45);

    d5.somar(100);
    System.out.println(d5.getReais() == 445);
    System.out.println(d5.getCentavos() == 75);

    d6.somar(1.90);
    System.out.println(d6.getReais() == 1000002);
    System.out.println(d6.getCentavos() == 01);
    d6.imprimir(); // R$ 1.000.002,01

    d7.somar("R$ 998.817,86");
    System.out.println(d7.getReais() == 1001385);
    System.out.println(d7.getCentavos() == 75);
    d7.imprimir(); // R$ 1.001.385,75

    Dinheiro d10 = new Dinheiro(8, 98); // oito reais com noventa e oito centavos
    Dinheiro d11 = new Dinheiro(8, 99); // oito reais com noventa e nove centavos
    Dinheiro d12 = null; // nulo
    Dinheiro d13 = new Dinheiro(8, 98); // oito reais com noventa e oito centavos
    Dinheiro d14 = d10; // mesma identidade de d8

    System.out.println(d10.equals(d11) == false);
    System.out.println(d10.equals(d12) == false);
    System.out.println(d10.equals(d13) == true);
    System.out.println(d10.equals(d14) == true);

    System.out.println(new Dinheiro(3.43).equals(new Dinheiro(3, 43)));
    System.out.println(new Dinheiro("R$ 8,97").equals(new Dinheiro(8, 97)));
    System.out.println(!new Dinheiro("R$ 5,43").equals(null)); // nunca é igual a null

    Dinheiro d15 = new Dinheiro(4, 30);
    Dinheiro d16 = new Dinheiro(987, 14);
    Dinheiro d17 = new Dinheiro(0, 1);
    Dinheiro d18 = new Dinheiro(17, 9);
    Dinheiro d19 = new Dinheiro(4, 30);

    // Todas estas assertivas devem imprimir true, claramente.
    System.out.println(d15.compareTo(d16) < 0);
    System.out.println(d15.compareTo(d17) > 0);
    System.out.println(d15.compareTo(d18) < 0);
    System.out.println(d15.compareTo(d19) == 0);

    Comparable d20 = new Dinheiro(8);
    Comparable d21 = new Dinheiro(9);
    Comparable d22 = new Dinheiro(8);
    System.out.println(d20.compareTo(d21) < 0);
    System.out.println(d20.compareTo(d22) == 0);
    System.out.println(d21.compareTo(d20) > 0);

    Dinheiro[] dinheiros = { d15, d16, d17, d18, d19 };

    // 👈 código para classificar em ordem crescente através de java.util.Arrays
    Arrays.sort(dinheiros);

    System.out.println(dinheiros[0].equals(d17));
    System.out.println(dinheiros[1].equals(d15));
    System.out.println(dinheiros[2].equals(d15));
    System.out.println(dinheiros[3].equals(d18));
    System.out.println(dinheiros[4].equals(d16));

    System.out.println(Arrays.toString(dinheiros)); // "stringuifica" o array de dinheiros

    // Casos de Teste Data \\
    System.out.println("========= CASOS DE TESTE DATA =========");

    Data data1 = new Data(); // construtor vazio significa 00/00/0000
    System.out.println(data1.getDia() == 0);
    System.out.println(data1.getMes() == 0);
    System.out.println(data1.getAno() == 0);

    Data data2 = new Data(28, 10, 2021); // Construtor recebe inteiro
    System.out.println(data2.getDia() == 28);
    System.out.println(data2.getMes() == 10);
    System.out.println(data2.getAno() == 2021);

    Data data3 = new Data(data2); // Recebe os valores de data2
    System.out.println(data3.getDia() == 28);
    System.out.println(data3.getMes() == 10);
    System.out.println(data3.getAno() == 2021);

    Data data4 = new Data(13.102021); // Recebe um double no formato dd,mm aa
    System.out.println(data4.getDia() == 13);
    System.out.println(data4.getMes() == 10);
    System.out.println(data4.getAno() == 2021);

    Data data5 = new Data("17/02/2022"); // Recebe String no formato dd/mm/aa
    System.out.println(data5.getDia() == 17);
    System.out.println(data5.getMes() == 02);
    System.out.println(data5.getAno() == 2022);

    data5.somar(10); // Soma um inteiro (de no máximo 2 dígitos) na quantidade de dias
    System.out.println(data5.getDia() == 27);
    System.out.println(data5.getMes() == 02);
    System.out.println(data5.getAno() == 2022);

    data2.somar(4);
    System.out.println(data2.getDia() == 01);
    System.out.println(data2.getMes() == 11);
    System.out.println(data2.getAno() == 2021);

    data2.somar(30);
    System.out.println(data2.getDia() == 01);
    System.out.println(data2.getMes() == 12);
    System.out.println(data2.getAno() == 2021);

    data2.somar(31);
    System.out.println(data2.getDia() == 01);
    System.out.println(data2.getMes() == 01);
    System.out.println(data2.getAno() == 2022);

    data4.somar(19);
    System.out.println(data4.getDia() == 01);
    System.out.println(data4.getMes() == 11);
    System.out.println(data4.getAno() == 2021);

    Data data6 = new Data("01/11/2021");
    Data data7 = new Data("02/11/2021");

    // Verificando igualdade com Equals \\
    System.out.println(data4.equals(data6) == true);
    System.out.println(data1.equals(data4) == false);
    System.out.println(data5.equals(data3) == false);

    // compareTo \\
    System.out.println(data4.compareTo(data6) == 0);
    System.out.println(data4.compareTo(data2) < 0);
    System.out.println(data5.compareTo(data6) > 0);
    System.out.println(data6.compareTo(data7) < 0);

    // Object classe Veiculo \\
    Veiculo v1 = new Veiculo("AAA 1234", "Chevrolet", "Corsa", 1598);
    Veiculo v2 = new Veiculo("BBB 1234", "Chevrolet", "Corsa Sedan", 1598);
    Veiculo v3 = new Veiculo("AAA 1234", "Chevrolet", "Corsa", 1598);
    Veiculo v4 = new Veiculo("CCC 1234", "Ford", "Ka", 997);
    Veiculo v5 = new Veiculo("DDD 1234", "Nissan", "Versa", 1598);
    Veiculo v6 = new Veiculo("CCC 1234", "Ford", "Ka", 997);

    // Implementar equals em Veiculo \\
    System.out.println(v1.equals(v3) == true);
    System.out.println(v2.equals(v4) == false);
    System.out.println(v4.equals(v6) == true);
    System.out.println(v5.equals(v1) == false);

  }
}
