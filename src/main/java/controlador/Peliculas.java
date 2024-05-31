/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Kevin
 */
public class Peliculas {

    private int id_peli;
    private String nombre_peli;
    private String precio_peli;

    public Peliculas() {
    }

    public Peliculas(int id_peli, String nombre_peli, String precio_peli) {
        this.id_peli = id_peli;
        this.nombre_peli = nombre_peli;
        this.precio_peli = precio_peli;
    }

    public int getIdMoneda() {
        return id_peli;
    }

    public void setIdMoneda(int id_peli) {
        this.id_peli = id_peli;
    }

    public String getNombreMoneda() {
        return nombre_peli;
    }

    public void setNombreMoneda(String nombre_peli) {
        this.nombre_peli = nombre_peli;
    }
    
    public String getValorMoneda() {
        return precio_peli;
    }

    public void setValorMoneda(String precio_peli) {
        this.precio_peli = precio_peli;
    }

    @Override
    public String toString() {
        return "TiposDeMoneda{" + "id_moneda=" + id_peli + ", nombre_moneda=" + nombre_peli + ", valor_moneda=" + precio_peli +'}';
    }
}
