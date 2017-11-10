package javaapplication9;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Cola extends javax.swing.JInternalFrame {
    public class Nodo{
        String codigo;
        String nombre;
        String apellido1;
        String apellido2;
        String DNI;
        String casa;
        String celular;
        String saldo;
        Nodo sig;
        public Nodo(String cod,String nom,String ape1,String ape2,String dni,String ca,String cel,String sal){
            codigo=cod;
            nombre=nom;
            apellido1=ape1;
            apellido2=ape2;
            DNI=dni;
            casa=ca;
            celular=cel;
            saldo=sal;
            sig=null;
        }
    }

    DefaultTableModel modelo;
    String [] cabecera={"N°","CODIGO","C.PAQUETE","C.CLIENTE","F.RESERVACION","F.SALIDA","DIAS","ESTADO","S.PENDIENTE"};
    String [][] data={};
    public Nodo frente,fincola;
    public Nodo pFound;
    int num=0;

    
    public Cola() {
        initComponents();
        fincola=null;
        modelo=new DefaultTableModel(data,cabecera);
        tblRegistro.setModel(modelo);

    }

    
    @SuppressWarnings("unchecked")

    private void mensaje(String data){
        StringTokenizer st=new StringTokenizer(data,",");
        String co=st.nextToken();
        String n=st.nextToken();
        String a1=st.nextToken();
        String a2=st.nextToken();
        String d=st.nextToken();
        String cas=st.nextToken();
        String ce=st.nextToken();
        String sa=st.nextToken();

        String datos="Descripcion del dato eliminado:\n"+
                     "Codigo :"+co+"\n"+
                     "C.Paquete  :"+n+"\n"+
                     "C.Cliente  :"+a1+"\n"+
                     "F.RESERVACION  :"+a2+"\n"+
                     "F.SALIDA  :"+d+"\n"+
                     "DIAS  :"+cas+"\n"+
                     "ESTADO  :"+ce+"\n"+
                     "S.PENDIENTE  :"+sa+"\n";
        JOptionPane.showMessageDialog(this,datos);
    }
    private void encolar(String cod,String nom,String ape1,String ape2,String dni,String ca,String cel,String sal){
        Nodo nuevo=new Nodo(cod,nom,ape1,ape2,dni,ca,cel,sal);
        if(frente==null)
            frente=nuevo;
        else
            fincola.sig=nuevo;
            fincola=nuevo;
            fincola.sig=null;
    }
    private String frente(){
        String eliminado="";
        Nodo aux=frente;
        String co=aux.codigo;
        String n=aux.nombre;
        String a1=aux.apellido1;
        String a2=aux.apellido2;
        String d=aux.DNI;
        String cas=aux.casa;
        String ce=aux.celular;
        String sa=aux.saldo;
        eliminado=co+","+n+","+a1+","+a2+","+d+","+cas+","+ce+","+sa;
        frente=frente.sig;
        return eliminado;
  }
    private Nodo buscar(Nodo frente,String cod){
        Nodo pos=frente;
        while(pos!=null&& !cod.equalsIgnoreCase(pos.codigo))
            pos=pos.sig;
        return pos;
    }
    void verdatos(){
        String cod,nom,ape1,ape2, dni,ca,cel,sal;
        Nodo aux=frente;
        vaciartabla();
        num=0;
        while(aux!=null){
            cod=aux.codigo;
            nom=aux.nombre;
            ape1=aux.apellido1;
            ape2=aux.apellido2;
            dni=aux.DNI;
            ca=aux.casa;
            cel=aux.celular;
            sal=aux.saldo;
            num++;
            Object[]fila={num,cod,nom,ape1,ape2,dni,ca,cel,sal};
            modelo.addRow(fila);
            aux=aux.sig;
        }
    }
    void habilitar(){
        btnactualizar.setEnabled(true);
        btnguardar.setEnabled(false);
    }
    void deshabilitar(){
        btnactualizar.setEnabled(false);
        btnguardar.setEnabled(true);
    }
    void limpiarentradas(){
        txtcodigo.setText("");
        txtnombre.setText("");
        txtapellido1.setText("");
        txtapellido2.setText("");
        txtdni.setText("");
        txtcasa.setText("");
        txtcelular.setText("");
        txtsaldo.setText("");
        txtcodigo.requestFocus();
    }
    void vaciartabla(){
        int filas=tblRegistro.getRowCount();
        for(int i=0;i<filas;i++)
            modelo.removeRow(0);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtapellido1 = new javax.swing.JTextField();
        txtapellido2 = new javax.swing.JTextField();
        txtdni = new javax.swing.JTextField();
        txtcasa = new javax.swing.JTextField();
        txtcelular = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btnreestaurar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btnconsultar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistro = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txtsaldo = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cola");

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Reservaciones");

        jLabel2.setText("Codigo");

        jLabel3.setText("Codigo paquete");

        jLabel4.setText("Codigo cliente");

        jLabel5.setText("Fecha reservacion");

        jLabel6.setText("Fecha Salida");

        jLabel7.setText("Cantidad dias");

        jLabel8.setText("Estado");

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnreestaurar.setText("Cargar");
        btnreestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreestaurarActionPerformed(evt);
            }
        });

        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        btnconsultar.setText("Consultar");
        btnconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultarActionPerformed(evt);
            }
        });

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        tblRegistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblRegistro);

        jLabel9.setText("Saldo pendiente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnreestaurar)
                        .addGap(13, 13, 13)
                        .addComponent(btnactualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnconsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(40, 40, 40)
                                                .addComponent(txtcodigo))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(120, 120, 120)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6))
                                        .addGap(37, 37, 37)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtcasa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(txtapellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(txtapellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(120, 120, 120)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9))
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtcelular, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                            .addComponent(txtsaldo))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtapellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtapellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtsaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnreestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnconsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
      String cod=txtcodigo.getText();
      String nom=txtnombre.getText().toUpperCase();
      String ape1=txtapellido1.getText().toUpperCase();
      String ape2=txtapellido2.getText().toUpperCase();
      String dni=txtdni.getText();
      String ca=txtcasa.getText();
      String cel=txtcelular.getText();
      String sal=txtsaldo.getText();
      encolar(cod,nom,ape1,ape2,dni,ca,cel,sal);
      limpiarentradas();
      verdatos();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnreestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreestaurarActionPerformed
       String texto="";

try
{
//Creamos un archivo FileReader que obtiene lo que tenga el archivo
FileReader lector=new FileReader("09 Reservaciones.csv");

//El contenido de lector se guarda en un BufferedReader
BufferedReader contenido=new BufferedReader(lector);

//Con el siguiente ciclo extraemos todo el contenido del objeto "contenido" y lo mostramos
while((texto=contenido.readLine())!=null)
{
System.out.println(texto);

String cadena = texto;

                        String[] arregloDeCadena = cadena.split(",");
                        System.out.println("Arreglo:");
                                for(int i=0; i<arregloDeCadena.length; i++)
                                        {
                                                
                                            System.out.println(arregloDeCadena[i]);
             

                                        }
                                
      String cod=arregloDeCadena[0];
      String nom=arregloDeCadena[1];
      String ape1=arregloDeCadena[2];
      String ape2=arregloDeCadena[3];
      String dni=arregloDeCadena[4];
      String ca=arregloDeCadena[5];
      String cel=arregloDeCadena[6];
      String sal=arregloDeCadena[7];
      encolar(cod,nom,ape1,ape2,dni,ca,cel,sal);

      verdatos();                
                                                                                                                                       
      
}


}

//Si se causa un error al leer cae aqui
catch(Exception e)
{
System.out.println("Error al leer");
}
    }//GEN-LAST:event_btnreestaurarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        pFound.codigo=txtcodigo.getText();
        pFound.nombre=txtnombre.getText().toUpperCase();
        pFound.apellido1=txtapellido1.getText().toUpperCase();
        pFound.apellido2=txtapellido2.getText().toUpperCase();
        pFound.DNI=txtdni.getText();
        pFound.casa=txtcasa.getText();
        pFound.celular=txtcelular.getText();
        pFound.saldo=txtsaldo.getText();
        limpiarentradas();
        deshabilitar();
        verdatos();
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btnconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultarActionPerformed
        String cod=txtcodigo.getText();
        if(cod.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this,"Ingrese un codigo por favor");
        }else {
            pFound=buscar(frente,cod);
            if(pFound!=null){
                txtnombre.setText(pFound.nombre);
                txtapellido1.setText(pFound.apellido1);
                txtapellido2.setText(pFound.apellido2);
                txtdni.setText(pFound.DNI);
                txtcasa.setText(pFound.casa);
                txtcelular.setText(pFound.celular);
                txtsaldo.setText(pFound.saldo);

                habilitar();
            } else {
                JOptionPane.showMessageDialog(this,"El codigo: "+cod+" , no esta en la lista..");
            }
        }
    }//GEN-LAST:event_btnconsultarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        if(frente==null){
            JOptionPane.showMessageDialog(this,"La cola esta vacia");
            txtcodigo.requestFocus();
        }
 else
        {
            String dato=frente();
            mensaje(dato);
            verdatos();
            limpiarentradas();
            if(frente==null)
                JOptionPane.showMessageDialog(this,"La cola esta vacia");
            deshabilitar();

 }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnconsultar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnreestaurar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRegistro;
    private javax.swing.JTextField txtapellido1;
    private javax.swing.JTextField txtapellido2;
    private javax.swing.JTextField txtcasa;
    private javax.swing.JTextField txtcelular;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtsaldo;
    // End of variables declaration//GEN-END:variables

}
