package modelo;

import static java.lang.Integer.parseInt;

public class Data implements Comparable<Data> {

  private int dias;
  private int mes;
  private int ano;

  public Data(String str) {
    String[] att = str.split("/");
    this.dias = parseInt(att[0]);
    this.mes = parseInt(att[1]);
    this.ano = parseInt(att[2]);
  }

  public Data(int dia, int mes, int ano) {
    this.dias = dia;
    this.mes = mes;
    this.ano = ano;
  }

  public Data() {
    this.dias = 0;
    this.mes = 0;
    this.ano = 0;
  }

  public Data(Data data2) {
    this.dias = data2.dias;
    this.mes = data2.mes;
    this.ano = data2.ano;
  }

  public Data(double db) {
    this.dias = (int)(db);
    this.mes = (int)(db * 100) % 100;
    this.ano = (int)(db * 1000000) % 10000;
  }

  public int getDia() {
    return this.dias;
  }

  public int getMes() {
    return this.mes;
  }

  public int getAno() {
    return this.ano;
  }

  //Jan 01, Fev 02, Março 03, Abril 04, Maio 05, Jun 06, Jul 07, Ago 08, Set 09, Out 10, Nov 11, Dez 12
  //  31      28      31        30        31       30      31     31      30       31      30      31

  public void somar(int soma) {
    if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
      if(dias + soma > 31){
        this.dias += soma - 31;
        this.mes += 1;
        if(mes > 12){
          this.dias = 1;
          this.mes = 1;
          this.ano += 1;
        }
      } else {
        this.dias += soma;
      }
    } else if(mes == 4 || mes == 6 || mes == 9 || mes == 11){
      if(dias + soma > 30){
        this.dias += soma - 30;
        this.mes += 1;
        if(mes > 12){
          this.dias = 1;
          this.mes = 1;
          this.ano += 1;
        }
      } else {
        this.dias += soma;
      }
    } else if(mes == 2){
      if(ano % 4 == 0){
        if (dias + soma > 29) {
          this.dias += soma - 29;
          if (mes > 12) {
            this.dias = 1;
            this.mes = 1;
            this.ano += 1;
          } else {
            this.mes += 1;
          }
        } else {
          this.dias += soma;
        }
      } else if(ano % 4 != 0){
        if (dias + soma > 28) {
          this.dias += soma - 28;
          if (mes > 12) {
            this.dias = 1;
            this.mes = 1;
            this.ano += 1;
          } else {
            this.mes += 1;
          }
        } else {
          this.dias += soma;
        }
      }
    }
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (null == obj)
      return false;
    if (obj instanceof Data) {
      Data outraData = (Data) obj;
      return this.dias == outraData.dias && this.mes == outraData.mes && this.ano == outraData.ano;
    }
    return false;
  }

  @Override
  public int compareTo(Data outraData) {
    if(this.ano > outraData.ano) {
      return 1;
    } else if(this.ano == outraData.ano && this.mes > outraData.mes){
      return 1;
    } else if(this.ano == outraData.ano && this.mes == outraData.mes && this.dias > outraData.dias){
      return 1;
    } else if(this.ano < outraData.ano) {
      return -1;
    } else if(this.ano == outraData.ano && this.mes < outraData.mes){
      return -1;
    } else if(this.ano == outraData.ano && this.mes == outraData.mes && this.dias < outraData.dias){
      return -1;
    }
    return 0;
  }

}
