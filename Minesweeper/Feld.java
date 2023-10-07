import javafx.scene.image.Image;
/**
 * Die Klasse Feld dient der Verwaltung der einzelnen Felder, welche sich im 
 * Spielfeld befinden. Bei diesen kann es sich entweder um ein verdecktes, ein aufgedecktes
 * oder ein verdecktes markiertes Feld handeln. Felder können eine Bombe haben. 
 * 
 * @author Tim Busch, Beatrice Wellmann
 * @version 1
 */
public class Feld
{
    private boolean istBombe;
    private int nachbarBombenAnzahl; 
    private Feldstatus feldstatus; 
    private int reihe;
    private int spalte;

    /**
     * Konstruktor für Objekte der Klasse Feld
     * @param reihe die Reihe in der das Feld im Spielfeld liegt
     * @param spalte die Spalte in der das Feld im Spielfeld liegt 
     */
    public Feld(int reihe, int spalte)
    {
        this.reihe = reihe;
        this.spalte = spalte;
        nachbarBombenAnzahl = 0; 
        feldstatus = Feldstatus.VERDECKT; 
        istBombe = false; 
    }

    /**
     * Liefert den Namen des zu verwendenden Bildes (Frei, Markiert oder Explosion) 
     * in Abhängigkeit vom Feldstatus (AUFGEDECKT, MARKIERT oder VERDECKT)
     */
    private String getBildName(){
        switch(feldstatus){
            case VERDECKT: return "Frei";  
            case MARKIERT: return "Markiert";  
            default: 
                if(istBombe) {
                    return "Explosion";
                } 
                else {
                    return (""+nachbarBombenAnzahl);
                }
        }
    }

    /**
     * Liefert das Bild des Feldes.
     * @return das Bild des Feldes
     */
    public Image getBild(){
        return new Image("bilder/"+getBildName()+".png"); 
    }

    /**
     * Liefert eine Aussage darüber, ob das Feld eine Bombe hat. 
     * @return 
     */
    public boolean istBombe(){
        return this.istBombe;
    }

    /**
     * Belegt das Feld mit einer Bombe. 
     */
    public void setBombe(){
        this.istBombe = true; 
    }

    /**
     * Liefert die Anzahl der benachbarten Felder, welche eine Bombe haben.
     * @return die Anzahl der benachbarten Felder, welche eine Bombe haben
     */
    public int getNachbarBombenAnzahl(){
        return nachbarBombenAnzahl;
    }
    
    /**
     * Setzt den Wert nachbarBombenAnzahl für das Feld.
     * @param die gewünschte Anzahl an Bomben
     */
    public void setNachbarBombenAnzahl(int anzahl){
        nachbarBombenAnzahl = anzahl; 
    }
    
    /**
     * Liefert den Status des Feldes (AUFGEDECKT, MARKIERT oder VERDECKT). 
     * @return der Status des Feldes
     */
    public Feldstatus getFeldstatus(){
        return this.feldstatus;
    }
    
    /**
     * Setzt den Status des Feldes. 
     * @param der gewünschte Status (AUFGEDECKT, MARKIERT oder VERDECKT)
     */
    public void setFeldstatus(Feldstatus s){
        this.feldstatus = s;
    }
    
    /**
     * Liefert die Reihe, in der das Feld liegt. 
     * @return die Reihe, in der das Feld liegt
     */
    public int getReihe(){
        return reihe;
    }
    
    /**
     * Liefert die Spalte, in der das Feld liegt. 
     * @return die Spalte, in der das Feld liegt
     */
    public int getSpalte(){
        return spalte;
    }

}
