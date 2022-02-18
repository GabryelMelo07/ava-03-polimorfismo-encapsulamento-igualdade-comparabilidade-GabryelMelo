package modelo;

import java.text.NumberFormat;
import java.util.Locale;
import static java.lang.Integer.parseInt;


public class Dinheiro implements Comparable<Dinheiro>{

  private static NumberFormat moeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

  private int centavos;

  public Dinheiro(int reais, int centavos) {
    this.centavos = reais * 100 + centavos;
  }

  public Dinheiro() {
    this.centavos = 0;
  }

  public Dinheiro(Dinheiro d3) {
    this.centavos += d3.centavos;
  }

  public Dinheiro(int reais) {
    this.centavos = reais * 100 + centavos;
  }

  public Dinheiro(String str) {

    String[] vetReais = str.split(",");
    String att = vetReais[0].replaceAll("\\p{Punct}","");
    att = att.replace("R ", "");
    String str2 = att.concat(vetReais[1]);
    int reais = parseInt(str2);
    this.centavos = reais;

  }

  public Dinheiro(double db) {
    int aux = (int)(db*100);
    this.centavos = aux;
  }

  public int getReais() {
    return this.centavos / 100;
  }

  public int getCentavos() {
    return this.centavos % 100;
  }

  public void somar(Dinheiro d) {
    this.centavos += d.centavos;
  }

  public void somar(int soma) {
    this.centavos += (soma * 100);
  }

  public void somar(double soma) {
    this.centavos += (soma * 100);
  }

  public void somar(String str) {

    String[] vetReais = String.valueOf(str).split(",");
    String att = vetReais[0].replaceAll("\\p{Punct}", "");
    att = att.replace("R ", "");
    String str2 = att.concat(vetReais[1]);
    int reais = parseInt(str2);
    this.centavos += reais;

  }

  @Override
  public boolean equals(Object obj){
    if(this == obj) return true;
    if(null == obj) return false;
    if(obj instanceof Dinheiro){
      Dinheiro outroDinheiro = (Dinheiro) obj;
      return this.centavos == outroDinheiro.centavos;
    }
    return false;
  }

  @Override
  public int compareTo(Dinheiro outroDinheiro) {
    return this.centavos - outroDinheiro.centavos;
  }

  public String toString() {
    return moeda.format(this.centavos / 100 + (this.centavos % 100) / 100.0);
  }

  public void imprimir() { // Não é ilegal imprimir Dinheiro? 😏
    System.out.println(this.toString());
  }

}
