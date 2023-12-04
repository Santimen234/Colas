import javax.swing.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Cola {

    private Queue<DispositivoJavierMorales> listado;

    public Cola() {
        listado = new LinkedList<DispositivoJavierMorales>();
        elementosPredefinidos();

    }

    public void encolar(DispositivoJavierMorales dato){
        listado.add(dato);
    }

    public void desencolar (String codigo, int cantidad) throws Exception{
        if(listado.isEmpty()){
            throw new Exception("No existen dispositivos");
        }
        DispositivoJavierMorales eliminar = null;
        for (DispositivoJavierMorales d : listado){
            if(d.getCodigo().equalsIgnoreCase(codigo)){
                eliminar = d;
                if (cantidad > eliminar.getCantidad() || cantidad < 0){
                    JOptionPane.showMessageDialog(null,"La cantidad ingresada no es correcta o supera la cantidad de dispositivos");
                    return;
                }else {
                    eliminar.setCantidad(eliminar.getCantidad()-cantidad);
                }
            }
        }

        if(eliminar == null){
            JOptionPane.showMessageDialog(null, "El codigo no es correcto o no existe");
            return;
        }

        if (eliminar.getCantidad() == 0){
            listado.remove(eliminar);
        }

    }

    private void elementosPredefinidos(){
        listado.add(new DispositivoJavierMorales());
        listado.add(new DispositivoJavierMorales("A002", "NOKIA", 45, "REPETIDOR"));
        listado.add(new DispositivoJavierMorales("A456", "SAMSUNG", 51, "MESH"));
        listado.add(new DispositivoJavierMorales("A222", "XIAOMI", 128, "MESH"));
        listado.add(new DispositivoJavierMorales("A051", "CISCO", 342, "REPETIDOR"));
        listado.add(new DispositivoJavierMorales("A578", "APPLE", 12, "REPETIDOR"));
    }

    public List<DispositivoJavierMorales> jList(){
        return listado.stream().collect(Collectors.toList());
    }

    public String listarElementos(){
        String resultado ="";
        for (DispositivoJavierMorales d:listado){
            resultado += d.toString() + "\n";
        }
        return listado.size()>0?resultado:"No hay elementos";
    }


}
