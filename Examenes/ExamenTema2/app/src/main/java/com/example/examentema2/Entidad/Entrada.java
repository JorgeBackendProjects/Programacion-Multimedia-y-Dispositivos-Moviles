package com.example.examentema2.Entidad;

public class Entrada {

    private int codigo, nButaca, precio;
    private String seccion;

    public Entrada() {
        this.codigo = 0;
        this.nButaca = 0;
        this.precio = 0;
        this.seccion = "";
    }

    public Entrada(int codigo, int nButaca, int precio, String seccion) {
        this.codigo = codigo;
        this.nButaca = nButaca;
        this.precio = precio;
        this.seccion = seccion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getnButaca() {
        return nButaca;
    }

    public void setnButaca(int nButaca) {
        this.nButaca = nButaca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    @Override
    public String toString() {
        return "Entrada{" +
                "codigo=" + codigo +
                ", nButaca=" + nButaca +
                ", precio=" + precio +
                ", seccion='" + seccion + '\'' +
                '}';
    }
}
