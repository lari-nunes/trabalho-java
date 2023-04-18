package modelo;
public class Carro {
    private String cor;
    private String modelo;
    private String combustivel;
    private int potencia;

    public Carro(String cor, String modelo, String combustivel, int potencia){
        this.cor = cor;
        this.modelo = modelo;
        this.combustivel = combustivel;
        this.potencia = potencia;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    // Método para imprimir os atributos do carro
      public void imprimir() {
          System.out.println("Cor: " + cor);
           System.out.println("Modelo: " + modelo);
          System.out.println("Tipo de combustível: " + combustivel);
            System.out.println("Potência: " + potencia);
       }
    }
