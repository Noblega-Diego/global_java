package global;
public class ProductoManufacturado {
    private int codigo;
    private String denominacion;
    private int tiempoFabricacion;
    private String [][] insumos;
    private double margenGanancia;

    //insumos
    //Codigo Insumo, Denominacion del insumo, Cantidad Insumo, Precio costo calculado
    public void addInsumo(int lugar,String codigo,String denominacionn,double cantidad, double costoCalculado, String unidadMedida){
        this.insumos[lugar][0] = codigo;
        this.insumos[lugar][1] = denominacionn;
        this.insumos[lugar][2] = String.valueOf(cantidad) + unidadMedida;
        this.insumos[lugar][3] = String.valueOf(costoCalculado);
    }
    
    public double costoTotalProducto(){
        double sumaTotal = 0.0;
        for(int i = 0; i < this.insumos.length; i++){
            sumaTotal += Double.parseDouble(this.insumos[i][3]);
        }
        return sumaTotal;
    }
    
    public double precioVentaProducto(){
        double costo = costoTotalProducto();
        double ganancia = (margenGanancia/100) * costo;
        return ganancia + costo;
    }
    public void cantidadDeInsumos(int cantidad){
        this.insumos = new String[cantidad][4];
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public int getTiempoFabricacion() {
        return tiempoFabricacion;
    }

    public void setTiempoFabricacion(int tiempoFabricacion) {
        this.tiempoFabricacion = tiempoFabricacion;
    }

    public String[][] getInsumos() {
        return insumos;
    }

    public void setInsumos(String[][] insumos) {
        this.insumos = insumos;
    }

    public double getMargenGanancia() {
        return margenGanancia;
    }

    public void setMargenGanancia(double margenGanancia) {
        this.margenGanancia = margenGanancia;
    }
    
}
