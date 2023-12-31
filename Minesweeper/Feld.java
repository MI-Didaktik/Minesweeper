import javafx.scene.image.Image;
/**
 * Die Klasse Feld dient der Verwaltung der einzelnen Felder, welche sich im Spielfeld befinden. 
 * Bei diesen kann es sich entweder um ein verdecktes, ein aufgedecktes oder ein verdecktes markiertes Feld handeln. 
 * Felder können eine Bombe haben. 
 * 
 * @author Tim Busch, Beatrice Wellmann
 * @version 1
 */
public class Feld
{
    private Feldstatus feldstatus; 
    private boolean istBombe;
    private int nachbarBombenAnzahl; 
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
     * Konstruktor zu Testzwecken
     * NICHT ANPASSEN
     * @param istBombe enthält das Feld eine Bombe
     * @param nachbarBombenAnzahl die Anzahl Nachbarbomben
     * @param feldstatus der Feldstatus
     * @param reihe die Reihe in der das Feld im Spielfeld liegt
     * @param spalte die Spalte in der das Feld im Spielfeld liegt 
     */
    protected Feld(boolean istBombe, int nachbarBombenAnzahl, Feldstatus feldstatus, int reihe, int spalte){
        this.istBombe = istBombe;
        this.nachbarBombenAnzahl = nachbarBombenAnzahl;
        this.feldstatus = feldstatus;
        this.reihe = reihe;
        this.spalte = spalte;
    }

    /**
     * Liefert das Bild des Feldes.
     * @param breite die Breite des Bildes
     * @param hoehe die Höhe des Bildes
     * @param spielstatus
     * @return das Bild des Feldes
     */
    public Image getBild(int breite, int hoehe, Spielstatus spielstatus){
        return new Image("bilder/" + getBildName(spielstatus) + ".png",breite,hoehe,false,false);
    }

    /**
     * Liefert eine Aussage darüber, ob das Feld eine Bombe hat. 
     * @return 
     */
    public boolean istBombe(){
        return this.istBombe;
    }

    /**
     * Setzt die Variable istBombe auf den gewünschten boolean. 
     * @param b boolean, der angibt, ob das Feld eine Bombe enthält
     */
    public void setBombe(boolean b){
        this.istBombe = b; 
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
     * @param anzahl die gewünschte Anzahl an Bomben
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
     * @param status der gewünschte Status (AUFGEDECKT, MARKIERT oder VERDECKT)
     */
    public void setFeldstatus(Feldstatus status){
        this.feldstatus = status;
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

    /**
     * Liefert den Namen des zu verwendenden Bildes (Frei, Markiert oder Explosion) 
     * in Abhängigkeit vom Feldstatus (AUFGEDECKT, MARKIERT oder VERDECKT) und Spielstatus (GEWONNEN)
     * @param spielstatus
     * @return bildname
     */
    protected String getBildName(Spielstatus spielstatus){
        switch(feldstatus){
            case VERDECKT: return "Verdeckt";  
            case MARKIERT: return "Markiert";  
            default: 
                if(istBombe && spielstatus == Spielstatus.GEWONNEN) {
                    return "Bombe";
                } 
                else if (istBombe){
                    return "Explosion";
                }
                else {
                    return (""+nachbarBombenAnzahl);
                }
        }
    }

}
