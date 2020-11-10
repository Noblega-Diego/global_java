package global;

import java.util.ArrayList;
import utiles.Lectura;
import utiles.Utiles;
public class RecetaProducto {
    private static String [][]  listaInsumos= {{"1000", "Harina", "Kg", "50"} , {"1001", "Huevos", "Un", "3"}, {"1002", "Tomate en Salsa", "Lt", "45"}, {"1003", "Queso Muzzarella", "Kg", "550"}, {"1004", "Queso Provolone", "Kg", "620"}, {"1005", "Queso Roquefort", "Kg", "650"}, {"1006", "Jamon Cocido", "Kg", "400"}, {"1007", "Salame", "Kg", "450"}, {"1008", "Lata Pimiento Morron", "Un", "130"},{"1009", "Aceite", "Lt", "60"},{"1010", "Carne Molida", "Kg", "180"},{"1011", "Cebollas", "Kg", "60"}, {"1012", "Sal", "Kg", "75"}};
    //código del Insumo, denominacióndel Insumo a declarar, unidad de medidadel Insumo, precio de costode cada insumo por la unidad de medida asignada
    public static void main(String[] args) {
        ArrayList<ProductoManufacturado> productos = new ArrayList<ProductoManufacturado>();
        
        do{
            ProductoManufacturado productoManufacturado = new ProductoManufacturado();
            int codigo, tiempoFabricacion;
            String denominacion;
            double margenGanancia;
            codigo = Lectura.leerIntM("ingrese el codigo del producto:");
            denominacion = Lectura.leerStringM("ingrese la denominacion:");
            tiempoFabricacion = Lectura.leerIntM("ingrese el tiempo de fabricacion:");
            margenGanancia = Lectura.leerDoubleM("ingrese el margen de ganancia:");
            productoManufacturado.setCodigo(codigo);
            productoManufacturado.setDenominacion(denominacion);
            productoManufacturado.setTiempoFabricacion(tiempoFabricacion);
            productoManufacturado.setMargenGanancia(margenGanancia);

            int cantidadInsumos;
            do{
                cantidadInsumos = Lectura.leerIntM("ingrese la cantidad de insummos:");
                if(cantidadInsumos > 1 && cantidadInsumos <= 13) break;
                System.out.println("ingrese nuevamente la cantidad");
            }while(true);
            productoManufacturado.cantidadDeInsumos(cantidadInsumos);
            for(int index = 0; index < cantidadInsumos; index++){
                int cod;
                int lugar = -1;
                do{
                   cod = Lectura.leerIntM("ingrese el codigo del insumo a buscar:");
                   lugar = buscarInsumo(cod);
                   if(lugar != -1) break;
                    System.out.println("no se ha encontrado el insumo");
                }while(true);
                System.out.println("insumo seleccionado: " + listaInsumos[lugar][1]);
                String denominacionn = listaInsumos[lugar][1];
                double cantidad;
                double costoCalculado;
                double costoPorMedida = Double.valueOf(listaInsumos[lugar][3]);
                String unidadMedida = listaInsumos[lugar][2];
                cantidad = Lectura.leerDoubleM("ingrese la cantidad:");
                costoCalculado = cantidad * costoPorMedida;
                
                productoManufacturado.addInsumo(index, String.valueOf(cod), denominacionn, cantidad, costoCalculado, unidadMedida);
            };
            productos.add(productoManufacturado);
        }while(Utiles.continuarM("¿desea seguir añadiendo productos?"));
        
        mostrarProductos(productos);
    }
    
    
    public static void mostrarProductos(ArrayList<ProductoManufacturado> productos){
        for(ProductoManufacturado producto :productos){
            System.out.println(Utiles.rellenarEspaciosSimple("Codigo Producto: ",20) + producto.getCodigo());
            System.out.println(Utiles.rellenarEspaciosSimple("Producto: ",20) + producto.getDenominacion());
            System.out.println(Utiles.rellenarEspaciosSimple("Tiempo Elaboracion: ",20)+ producto.getTiempoFabricacion());
            System.out.println("Insumos:");
            System.out.println(Utiles.rellenarEspaciosSimple("Codigo", 10)+ 
                    Utiles.rellenarEspaciosSimple("Insumo", 20) + 
                    Utiles.rellenarEspaciosSimple("Cantidad/Unidad Medida", 25) + 
                    "Precio Costo Calculado");
            for (int i = 0; i < producto.getInsumos().length; i++) {
                System.out.println(Utiles.rellenarEspaciosSimple(producto.getInsumos()[i][0], 10) + 
                        Utiles.rellenarEspaciosSimple(producto.getInsumos()[i][1], 20) +
                        Utiles.rellenarEspaciosSimple(producto.getInsumos()[i][2], 25) +
                        producto.getInsumos()[i][3]);
            }
            System.out.println("-------------------------------------------------------");
            System.out.println(Utiles.rellenarEspaciosSimple("Costo Total Producto:",25 )+ producto.costoTotalProducto());
            System.out.println(Utiles.rellenarEspaciosSimple("Margen de Ganancia:",25 ) + producto.getMargenGanancia());
            System.out.println(Utiles.rellenarEspaciosSimple("Precio de Venta Final:",25 ) + producto.precioVentaProducto());
            System.out.println("-----------------------------------------------------------------------------------");
        }
        
    }
    
    public static int buscarInsumo(int codigo){
        for(int i = 0; i < listaInsumos.length; i++){
            if(String.valueOf(codigo).equals(listaInsumos[i][0])){
                return i;
            }
        }
        return -1;
    }
    
}
