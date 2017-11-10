package javaapplication9;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;

public class ListaSimple4 extends javax.swing.JInternalFrame {
    public class Nodo{
        String codigo;
        String nombre;
        String apellido1;
        String tarjeta;
        String telefono;
        String direccion;
        String frecuencia;
        Nodo sig;
        public Nodo(String cod,String nom,String ape1,String tar, String tel,String dir,String fre){
            codigo=cod;
            nombre=nom;
            apellido1=ape1;
            tarjeta=tar;
            telefono=tel;
            direccion=dir;
            frecuencia=fre;
        }
    }
    public Nodo ini,fin;
    public Nodo pFound;
    int num=0;

   
    public ListaSimple4() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")

    void encabezado(){
        txaRegistro.setFont(new Font("Comic Sams MS", Font.BOLD,12));
        txaRegistro.setText("");
        txaRegistro.append("");
        txaRegistro.append("    N°  CODIGO      PAIS        CIUDAD     DIRECCION          DESTINO               DESCRIPCION          SEGURIDAD\n");
        txaRegistro.append("------------------------------------------------------------------------------------------------------------------\n");

    }
    void habilitar(){
        btnactualizar.setEnabled(true);
        btneliminar.setEnabled(true);
        btnguardar.setEnabled(false);
    }
    void deshabilitar(){
       btnactualizar.setEnabled(false);
       btneliminar.setEnabled(false);
       btnguardar.setEnabled(true);
    }
    void limpiarentradas(){
        txtcodigo.setText("");
        txtnombre.setText("");
        txtapellido1.setText("");
        txttarjeta.setText("");
        txttelefono.setText("");
        txtdireccion.setText("");
        txtfrecuencia.setText("");
        txtcodigo.requestFocus();
    }
    void verdatos(){
        String cod,nom,ape1,tar,tel,dir,fre;
        Nodo aux=ini;
        num=0;
        encabezado();
        while(aux!=null){
            cod=aux.codigo;
            nom=aux.nombre;
            ape1=aux.apellido1;
            tar=aux.tarjeta;
            tel=aux.telefono;
            dir=aux.direccion;
            fre=aux.frecuencia;
            num++;
            String numera=String.valueOf(num);
            for(int i=String.valueOf(num).length();i<5;i++){
                numera=" "+numera;
            }
            for(int i=cod.length();i<15;i++){
                cod=cod+" ";
            }
            for(int i=nom.length();i<15;i++){
                nom=nom+" ";
            }
            for(int i=ape1.length();i<20;i++){
                ape1=ape1+" ";
            }
            for(int i=tar.length();i<20;i++){
                tar=tar+" ";
            }
            for(int i=tel.length();i<15;i++){
                tel=tel+" ";
            }
            for(int i=dir.length();i<20;i++){
                dir=dir+" ";
            }
            for(int i=fre.length();i<20;i++){
                fre=fre+" ";
            }

           
            
            txaRegistro.append(numera + "   " + cod+nom+ape1+tar + tel + dir + fre  +"\n");
            aux=aux.sig;
            
                    System.out.println("codigo:" + numera);
        }

    }
    Nodo buscar(Nodo inicio,String cod){
        Nodo pos=inicio;
        while(pos!=null&&!cod.equalsIgnoreCase(pos.codigo))
            pos=pos.sig;
        return pos;
    }
    Nodo insertarinicio(Nodo inicio,String cod,String nom,String ape1,String tar,String tel, String dir,String fre){
        Nodo nuevo=new Nodo(cod,nom,ape1,tar,tel,dir,fre);
        nuevo.sig=inicio;
        inicio=nuevo;
        return inicio;
    }
    void eliminar(Nodo actual){
        Nodo anterior=ini;
        while(anterior.sig!=actual&&anterior.sig!=null){
            anterior=anterior.sig;
        }
        if(actual!=null){
            if(anterior==actual)ini=actual.sig;
            else anterior.sig=actual.sig;
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtapellido1 = new javax.swing.JTextField();
        txttarjeta = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btnconsultar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaRegistro = new javax.swing.JTextArea();
        btnactualizar = new javax.swing.JButton();
        btnreestaurar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtfrecuencia = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Lista Simple");
        setPreferredSize(new java.awt.Dimension(690, 430));
        setRequestFocusEnabled(false);

        jLabel1.setText("Codigo");

        jLabel2.setText("Pais");

        jLabel3.setText("Ciudad");

        jLabel4.setText("Capacidad pasajeros");

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
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

        txaRegistro.setEditable(false);
        txaRegistro.setColumns(20);
        txaRegistro.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        txaRegistro.setRows(5);
        jScrollPane1.setViewportView(txaRegistro);

        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        btnreestaurar.setText("Cargar");
        btnreestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreestaurarActionPerformed(evt);
            }
        });

        jLabel6.setText("Dias duracion");

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Destinos Turisticos");

        jLabel9.setText("Codigo destino");

        jLabel11.setText("Descripcion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtapellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(txtcodigo)))
                        .addGap(108, 108, 108)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtfrecuencia)
                                .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(btnreestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(btnconsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtapellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtfrecuencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnreestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnconsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
      String cod=txtcodigo.getText().toUpperCase();;
      String nom=txtnombre.getText().toUpperCase();
      String ape1=txtapellido1.getText().toUpperCase();
      String tar=txttarjeta.getText().toUpperCase();
      String tel=txttelefono.getText().toUpperCase();
      String dir=txtdireccion.getText().toUpperCase();
      String fre=txtfrecuencia.getText().toUpperCase();

      ini=insertarinicio(ini,cod,nom,ape1,tar,tel,dir,fre);
      limpiarentradas();
      verdatos();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        pFound.codigo=txtcodigo.getText().toUpperCase();
        pFound.nombre=txtnombre.getText().toUpperCase();
        pFound.apellido1=txtapellido1.getText().toUpperCase();
        pFound.tarjeta=txttarjeta.getText().toUpperCase();
        pFound.telefono=txttelefono.getText().toUpperCase();
        pFound.direccion=txtdireccion.getText().toUpperCase();
        pFound.frecuencia=txtfrecuencia.getText().toUpperCase();

        limpiarentradas();
        deshabilitar();
        verdatos();
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btnconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultarActionPerformed
        String cod=txtcodigo.getText();
        if(cod.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(this,"Ingrese en codigo por favor");
        }else {
            pFound=buscar(ini,cod);
            if(pFound!=null){
                txtnombre.setText(pFound.nombre);
                txtapellido1.setText(pFound.apellido1);
                txttarjeta.setText(pFound.tarjeta);
                txttelefono.setText(pFound.telefono);
                txtdireccion.setText(pFound.direccion);
                txtfrecuencia.setText(pFound.frecuencia);

                habilitar();
            } else {
                JOptionPane.showMessageDialog(this,"El codigo: "+cod+" , no esta en la lista..");
            }
        }
    }//GEN-LAST:event_btnconsultarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        eliminar(pFound);
        limpiarentradas();
        verdatos();
        if(ini==null)
            JOptionPane.showMessageDialog(this, "La lista esta vacia");
        deshabilitar();
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnreestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreestaurarActionPerformed
       String texto="";

try
{
//Creamos un archivo FileReader que obtiene lo que tenga el archivo
FileReader lector=new FileReader("06 DestinosTuristicos.csv");

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
      String tar=arregloDeCadena[3];
      String tel=arregloDeCadena[4];
      String dir=arregloDeCadena[5];
      String fre=arregloDeCadena[6]; 
      
      ini=insertarinicio(ini,cod,nom,ape1,tar,tel,dir,fre);
      verdatos();
      
      
}


}

//Si se causa un error al leer cae aqui
catch(Exception e)
{
System.out.println("Error al leer");
}
    }//GEN-LAST:event_btnreestaurarActionPerformed

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
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txaRegistro;
    private javax.swing.JTextField txtapellido1;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtfrecuencia;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttarjeta;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables

}
