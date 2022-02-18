package modelo;

public class Veiculo {

  final String placa;
  final String marca;
  final String modelo;
  final int    cilindrada;

  public Veiculo(String placa, String marca, String modelo, int cilindrada) {
    this.placa      = placa;
    this.marca      = marca;
    this.modelo     = modelo;
    this.cilindrada = cilindrada;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (null == obj)
      return false;
    if (obj instanceof Veiculo) {
      Veiculo outroObj = (Veiculo) obj;
      return this.marca == outroObj.marca && this.modelo == outroObj.modelo;
    }
    return false;
  }

}
