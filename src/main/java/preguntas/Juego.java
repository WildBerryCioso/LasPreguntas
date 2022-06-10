package preguntas;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.swing.JOptionPane;

/**
 *
 * @author Wilber Hinestroza Palencia
 */
public class Juego extends javax.swing.JFrame {

    String pregunta;
    String respuesta;
    static String nombre;
    String Puntos = "0";
    int level = 1;
    ArrayList<String> Opciones;
    int n_pregunta = 0;

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
        }
        new Juego();
    }

    //--------------------------------------------------------------------------
    //Seleccion de la Pregunta
    //--------------------------------------------------------------------------
    public void seleccionarPregunta(int n) {
        conexion cone = new conexion();
        try {
            cone.Preguntas();
        } catch (Exception e) {

        }
        Opciones = new ArrayList<>();
        pregunta = cone.Preguntas.get(n).getPreguntas();
        Opciones.add(cone.Preguntas.get(n).getRC());
        Opciones.add(cone.Preguntas.get(n).getRI1());
        Opciones.add(cone.Preguntas.get(n).getRI2());
        Opciones.add(cone.Preguntas.get(n).getRI3());
        respuesta = cone.Preguntas.get(n).getRC();

        for (int i = 0; i < 4; i++) {
            Collections.shuffle(Opciones);
        }
    }

    //--------------------------------------------------------------------------
    //Muestra la informacion en el JFrame
    //--------------------------------------------------------------------------
    public void mostrarInformacion() {
        Nombre.setText("Jugador: " + nombre);
        jLabel3.setText("Puntos: " + String.valueOf(Puntos));
        jTextArea1.setText(pregunta);
        jButton1.setText(Opciones.get(0));
        jButton2.setText(Opciones.get(1));
        jButton3.setText(Opciones.get(2));
        jButton4.setText(Opciones.get(3));
    }

    //--------------------------------------------------------------------------
    //Probar si la respuesta es correcta
    //--------------------------------------------------------------------------
    void seleccionRespuesta(int n) {
        if (Opciones.get(n).equals(respuesta)) {
            Puntos = String.valueOf(Integer.parseInt(Puntos) + 100);
            JOptionPane.showMessageDialog(
                    this,
                    "Su respuesta es correcta",
                    "Muy bien :)",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Su respuesta es incorrecta, la respuesta es: " + respuesta,
                    "Perdiste :(",
                    JOptionPane.ERROR_MESSAGE
            );
            Inicio abrir = new Inicio();
            abrir.setVisible(true);
            this.setVisible(false);
        }
        jugar();
    }

    //--------------------------------------------------------------------------
    //Es el que permite iniciar el juego y la finalizacion del mismo
    //--------------------------------------------------------------------------
    public void jugar() {
        Nivel.setText("Nivel:" + (level));
        if (n_pregunta == 5) {
            JOptionPane.showMessageDialog(
                    this,
                    "Juego Terminado" + "\n" + "Jugador: " + nombre + "\n" + "Puntaje: " + Puntos,
                    "Felicitaciones, Ganaste :)",
                    JOptionPane.PLAIN_MESSAGE
            );
            conexion.main();
            Map<String, Object> data = new HashMap<>();
            data.put("Nombre", nombre);
            data.put("Puntos", Puntos);
            String uniqueID = UUID.randomUUID().toString();
            conexion.insertarDatos("Historial", uniqueID, data);
            
            Inicio abrir = new Inicio();
            abrir.setVisible(true);
            this.setVisible(false);
        }
        seleccionarPregunta(n_pregunta);
        mostrarInformacion();
        n_pregunta++;
        level++;
    }

    public Juego() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        jugar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        Nombre = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Nivel = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setText("A");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton2.setText("B");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton3.setText("C");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton4.setText("D");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        Nombre.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Nombre.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Puntos");

        Nivel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Nivel.setText("Categoria");

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton5.setText("Retirarme");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setToolTipText("");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setAutoscrolls(false);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Nivel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                            .addComponent(Nombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Nivel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        seleccionRespuesta(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        seleccionRespuesta(1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        seleccionRespuesta(2);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        seleccionRespuesta(3);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //--------------------------------------------------------------------------
        //En el caso de que el jugador se retire del juego con lo que lleva acumulado
        //--------------------------------------------------------------------------

        JOptionPane.showMessageDialog(
                this,
                "Juego Terminado" + "\n" + "Jugador: " + nombre + "\n" + "Puntaje: " + Puntos,
                "Felicitaciones :)",
                JOptionPane.PLAIN_MESSAGE
        );
        if (Integer.parseInt(Puntos) > 0) {
            Map<String, Object> data = new HashMap<>();
            data.put("Nombre", nombre);
            data.put("Puntos", Puntos);
            String uniqueID = UUID.randomUUID().toString();
            conexion.insertarDatos("Historial", uniqueID, data);
        }
        Inicio abrir = new Inicio();
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nivel;
    public static javax.swing.JLabel Nombre;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
