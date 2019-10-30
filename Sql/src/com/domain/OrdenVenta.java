package com.domain;

public class OrdenVenta {
	
	private int nroOrden;
	private int nroLinea;
	private int codigoArt;
	private String descripcionArt;
	private String estadoOrden;
	private long cantPrimaria;
	private long cantSecundaria;
	private String hora;
	private String fecha;
	private String dispositivo;
	private int mesa;
	private int comensales;

	
	public int getNroOrden() {
		return nroOrden;
	}
	public void setNroOrden(int nroOrden) {
		this.nroOrden = nroOrden;
	}
	public int getNroLinea() {
		return nroLinea;
	}
	public void setNroLinea(int nroLinea) {
		this.nroLinea = nroLinea;
	}
	public int getCodigoArt() {
		return codigoArt;
	}
	public void setCodigoArt(int codigoArt) {
		this.codigoArt = codigoArt;
	}
	public String getDescripcionArt() {
		return descripcionArt;
	}
	public void setDescripcionArt(String descripcionArt) {
		this.descripcionArt = descripcionArt;
	}
	public long getCantPrimaria() {
		return cantPrimaria;
	}
	public void setCantPrimaria(long cantPrimaria) {
		this.cantPrimaria = cantPrimaria;
	}
	public long getCantSecundaria() {
		return cantSecundaria;
	}
	public void setCantSecundaria(long cantSecundaria) {
		this.cantSecundaria = cantSecundaria;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getDispositivo() {
		return dispositivo;
	}
	public void setDispositivo(String dispositivo) {
		this.dispositivo = dispositivo;
	}
	public int getMesa() {
		return mesa;
	}
	public void setMesa(int mesa) {
		this.mesa = mesa;
	}
	public int getComensales() {
		return comensales;
	}
	public void setComensales(int comensales) {
		this.comensales = comensales;
	}
	public String getEstadoOrden() {
		return estadoOrden;
	}
	public void setEstadoOrden(String estadoOrden) {
		this.estadoOrden = estadoOrden;
	}

	
}
