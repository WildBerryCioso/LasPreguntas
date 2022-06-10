package preguntas;
/**
 *
 * @author Wilber Hinestroza Palencia
 */
public class Preguntas {
    private String Pregunta;
    private String RespuestaC;
    private String RespuestaI1;
    private String RespuestaI2;
    private String RespuestaI3;
    
    //--------------------------------------------------------------------------
    //Constructor Preguntas Get's y Set's
    //--------------------------------------------------------------------------
    
    public Preguntas(){
        
    }
    
    public Preguntas(String pregunta, String RC, String RI1, String RI2, String RI3){
        this.Pregunta = pregunta;
        this.RespuestaC = RC;
        this.RespuestaI1= RI1;
        this.RespuestaI2= RI2;
        this.RespuestaI3= RI3;
    }
    
    public void setPreguntas(String p)
    {
        this.Pregunta = p;
    }   
    public void setRC(String p)
    {
        this.RespuestaC = p;
    }
    public void setRI1(String p)
    {
        this.RespuestaI1 = p;
    }
    public void setRI2(String p)
    {
        this.RespuestaI2 = p;
    }
    public void setRI3(String p)
    {
        this.RespuestaI3 = p;
    }
    
    public String getPreguntas()
    {
        return Pregunta;
    }
    public String getRC()
    {
        return RespuestaC;
    }
    public String getRI1()
    {
        return RespuestaI1;
    }
    public String getRI2()
    {
        return RespuestaI2;
    }
    public String getRI3()
    {
        return RespuestaI3;
    }
}
