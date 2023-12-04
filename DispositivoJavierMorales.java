public class DispositivoJavierMorales {
    private String codigo;
    private String marca;
    private int cantidad;
    private String tipo;

    public DispositivoJavierMorales(String codigo, String marca, int cantidad, String tipo) {
        this.codigo = codigo;
        this.marca = marca;
        this.cantidad = cantidad;
        this.tipo = tipo;
    }

    public DispositivoJavierMorales() {
        this.codigo = "A100";
        this.marca = "CISCO";
        this.cantidad = 30;
        this.tipo = "MESH";
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "codigo= " + codigo + ", marca= " + marca + ", cantidad= " + cantidad + ", tipo= " + tipo;
    }
}
