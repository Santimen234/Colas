import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Ventana {
    private JTextArea txtLista;
    private JTextField txtCodigo;
    private JTextField txtCantidad;
    private JButton btnActualizar;
    private JButton btnListar;
    private JPanel principal;
    private JList listMesh;
    private JList listRepetidores;

    DefaultListModel<DispositivoJavierMorales> dlm1 = new DefaultListModel<DispositivoJavierMorales>();
    DefaultListModel<DispositivoJavierMorales> dlm2 = new DefaultListModel<DispositivoJavierMorales>();

    public void llenarjList(){
        dlm1.removeAllElements();
        dlm2.removeAllElements();
        for (DispositivoJavierMorales d : listado.
                DdjList()){
            if(d.getTipo().equals("MESH")){
                dlm1.addElement(d);
            }else{
                dlm2.addElement(d);
            }
        }
        listMesh.setModel(dlm1);
        listRepetidores.setModel(dlm2);
    }
    /*public void llenarjListRepetidores(){
        dlm2.removeAllElements();
        for (DispositivoJavierMorales d : listado.jList()){
            if(d.getTipo().equals("REPETIDOR")){
                dlm2.addElement(d);
            }
        }
        listRepetidores.setModel(dlm2);
    }*/

    Cola listado = new Cola();

    public Ventana() {

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // listado.elementosPredefinidos();
                txtLista.setText(listado.listarElementos());
                llenarjList();
               // llenarjListRepetidores();
            }
        });


        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtCodigo.getText().isEmpty() || txtCantidad.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Rellene los campos");
                }else {
                    try {
                        listado.desencolar(txtCodigo.getText(), Integer.parseInt(txtCantidad.getText()));
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
                txtLista.setText(listado.listarElementos());
                llenarjList();
               // llenarjListRepetidores();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
