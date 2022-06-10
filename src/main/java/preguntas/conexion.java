package preguntas;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Wilber Hinestroza Palencia
 */
public class conexion {

    List<Jugador> ListaJugadores = new ArrayList<Jugador>();
    List<Preguntas> Preguntas = new ArrayList<Preguntas>();
    public static Firestore db;

    public static void main() {
        conectar();
        //Inicio.main();
    }
    
    //--------------------------------------------------------------------------
    //Conexion a Firebase
    //--------------------------------------------------------------------------
    private static void conectar() {
        FileInputStream serviceAccount;
        try {
            serviceAccount = new FileInputStream("preguntas-32091.json");
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://preguntas-32091.firebaseio.com/")
                    .build();

            FirebaseApp.initializeApp(options);
            db = FirestoreClient.getFirestore();
            System.out.println("Se conecto");
        } catch (Exception ex) {
            System.out.println("" + ex);
        }
    }
    
    //--------------------------------------------------------------------------
    //Insertar datos en la base de datos
    //--------------------------------------------------------------------------
    public static boolean insertarDatos(
            String coleccion,
            String documento,
            Map<String, Object> data) {
        try {
            DocumentReference docRef = db.collection(coleccion).document(documento);
            ApiFuture<WriteResult> result = docRef.set(data);
            System.out.println("Update Time: " + result.get().getUpdateTime());
            return true;
        } catch (Exception ex) {
        }
        return false;
    }
    
    //--------------------------------------------------------------------------
    //Agregar informacion a la tabla historial
    //--------------------------------------------------------------------------
    public void historial() throws InterruptedException, ExecutionException {
        CollectionReference Historial = conexion.db.collection("Historial");
        ApiFuture<QuerySnapshot> querysnapshot = Historial.get();

        for (DocumentSnapshot document : querysnapshot.get().getDocuments()) {
            Jugador jugador = new Jugador(
                    document.getString("Nombre"),
                    document.getString("Puntos"));
            ListaJugadores.add(jugador);
        }
        tabla();
    }

    private void tabla() {
        agregarFila(Historial.jTable1, 0);
        for (int i = 0; i < ListaJugadores.size(); i++) {
            agregarFila(Historial.jTable1, Historial.jTable1.getRowCount() + 1);
            Historial.jTable1.setValueAt(ListaJugadores.get(i).getNombre(), i, 0);
            Historial.jTable1.setValueAt(ListaJugadores.get(i).getPuntos(), i, 1);
        }
    }
    
    public void agregarFila(JTable table, int fila) {
        DefaultTableModel Modelo = (DefaultTableModel) table.getModel();
        Modelo.setRowCount(fila);
    }

    //--------------------------------------------------------------------------
    //PREGUNTAS
    //--------------------------------------------------------------------------

    private static int aleatorio(int max) {
        int n = 0;
        Random random = new Random();
        n = random.nextInt(max + 0);
        return n;
    }

    public void Preguntas() throws InterruptedException, ExecutionException {
        for (int i = 1; i <= 5; i++) {
            CollectionReference Juego = conexion.db.collection("Preguntas" + i);
            int tamaño = 0;
            ApiFuture<QuerySnapshot> querysnapshot = Juego.get();

            for (DocumentSnapshot document : querysnapshot.get().getDocuments()) {
                tamaño = tamaño + 1;
            }

            int n = aleatorio(tamaño - 1);
            for (DocumentSnapshot document : querysnapshot.get().getDocuments()) {
                if (Integer.parseInt(document.getString("Id")) == n) {
                    Preguntas pregunta = new Preguntas(
                            document.getString("Pregunta"),
                            document.getString("RespuestaC"),
                            document.getString("RespuestaI1"),
                            document.getString("RespuestaI2"),
                            document.getString("RespuestaI3"));
                    Preguntas.add(pregunta);
                }
            }
        }

    }
}
