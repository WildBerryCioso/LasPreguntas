package preguntas;
/**
 *
 * @author Wilber Hinestroza Palencia
 */
public class Jugador {
    private String Nombre;
    private String Puntos;
    
    //--------------------------------------------------------------------------
    //Constructor Jugador Get's y Set's
    //--------------------------------------------------------------------------
    
    public Jugador(){
        
    }
    
    public Jugador(String nombre, String puntos){
        this.Nombre = nombre;
        this.Puntos = puntos;
    }
    
    public void setNombre(String nombre)
    {
        this.Nombre = nombre;
    }
    
    public void setPuntos(String puntos)
    {
        this.Puntos = puntos;
    }
    
    public String getNombre()
    {
        return Nombre;
    }
    
    public String getPuntos()
    {
        return Puntos;
    }
}
