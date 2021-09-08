public class Pessoa {
    String tipo;

    Pessoa (String tipo) {
        this.tipo = tipo;
    }
    
    void adicionaTipo(String tipo) {
        this.tipo = tipo;
    }

    void deletaTipo() {
        this.tipo = null;
    }
}