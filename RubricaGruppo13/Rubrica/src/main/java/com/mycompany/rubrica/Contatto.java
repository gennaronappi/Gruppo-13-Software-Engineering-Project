package com.mycompany.rubrica;

/**
 * @class Contatto
 * @brief Classe che rappresenta un contatto nella rubrica.
 * 
 * La classe Contatto consente di gestire i dettagli di un contatto
 * (nome, cognome, numeri di telefono e indirizzi email).
 * I metodi getter sono programmati in modo da restituire una stringa vuota "", invece di null, nel caso in cui fossero nulli.
 *
 *
 * @author Francesco, Antonio, Gennaro
 *
 */
public class Contatto implements Comparable<Contatto>{
    ///Attributi
    private String nome;          ///< Nome del contatto.
    private String cognome;       ///< Cognome del contatto.
    private String numeroTelefono1; ///< Primo numero di telefono del contatto.
    private String numeroTelefono2; ///< Secondo numero di telefono del contatto.
    private String numeroTelefono3; ///< Terzo numero di telefono del contatto.
    private String email1;       ///< Primo indirizzo email del contatto.
    private String email2;       ///< Secondo indirizzo email del contatto.
    private String email3;       ///< Terzo indirizzo email del contatto.

    ///Metodi
   
    /**
     * @brief Costruttore per creare un nuovo contatto.
     * @param nome Nome del contatto.
     * @param cognome Cognome del contatto.
     */
    public Contatto(String cognome,String nome){
        /// Gli attributi nome e cognome sono settati in UpperCase per evitare problemi nell'ordinamento tra lettere minuscole e maiuscole.
        this.cognome=cognome.toUpperCase();
        this.nome=nome.toUpperCase();    
    }

    /**
     * @brief Costruttore vuoto per creare un contatto senza dettagli iniziali.
     */
    public Contatto(){
        
    }

    /**
     * @brief Imposta il nome del contatto.
     * @param nome Il nuovo nome del contatto.
     */
    public void setNome(String nome) {
        this.nome=nome.toUpperCase();
    }

    /**
     * @brief Restituisce il nome del contatto.
     * @return Il nome del contatto.
     */
    public String getNome() {
        if(this.nome==null) return "";
        else return this.nome;
    }

    /**
     * @brief Imposta il cognome del contatto.
     * @param cognome Il nuovo cognome del contatto.
     */
    public void setCognome(String cognome) {
        this.cognome=cognome.toUpperCase();
    }

    /**
     * @brief Restituisce il cognome del contatto.
     * @return Il cognome del contatto.
     */
    public String getCognome() {
        if(this.cognome==null) return "";
        else return this.cognome;
    }
    
    /**
     * @brief Imposta il primo numero di telefono del contatto.
     * @param numeroTelefono1 Il nuovo numero di telefono.
     */
    public void setNumeroTelefono1(String numeroTelefono1) {
        this.numeroTelefono1=numeroTelefono1;
    }

    /**
     * @brief Imposta il secondo numero di telefono del contatto.
     * @param numeroTelefono2 Il nuovo numero di telefono.
     */
    
    public void setNumeroTelefono2(String numeroTelefono2) {
        this.numeroTelefono2=numeroTelefono2;
    }

    /**
     * @brief Imposta il terzo numero di telefono del contatto.
     * @param numeroTelefono3 Il nuovo numero di telefono.
     */
    
    public void setNumeroTelefono3(String numeroTelefono3) {
        this.numeroTelefono3=numeroTelefono3;
    }

    /**
     * @brief Restituisce il primo numero di telefono del contatto.
     * @return Il primo numero di telefono del contatto.
     */
    public String getNumeroTelefono1() {
        if(this.numeroTelefono1==null) return "";
        else return this.numeroTelefono1;
    }

    /**
     * @brief Restituisce il secondo numero di telefono del contatto.
     * @return Il secondo numero di telefono del contatto.
     */
    public String getNumeroTelefono2() {
        if(this.numeroTelefono2==null) return "";
        else return this.numeroTelefono2;
    }

    /**
     * @brief Restituisce il terzo numero di telefono del contatto.
     * @return Il terzo numero di telefono del contatto.
     */
    public String getNumeroTelefono3() {
        if(this.numeroTelefono3==null) return "";
        else return this.numeroTelefono3;
    }
    
    /**
     * @brief Imposta il primo indirizzo email del contatto.
     * @param email1 Il nuovo indirizzo email.
     */
    public void setEmail1(String email1) {
        this.email1=email1;
    }
    
    /**
     * @brief Imposta il secondo indirizzo email del contatto.
     * @param email2 Il nuovo indirizzo email.
     */
    public void setEmail2(String email2) {
        this.email2=email2;
    }

    /**
     * @brief Imposta il terzo indirizzo email del contatto.
     * @param email3 Il nuovo indirizzo email.
     */    
    public void setEmail3(String email3) {
        this.email3=email3;
    }

    /**
     * @brief Restituisce il primo indirizzo email del contatto.
     * @return Il primo indirizzo email del contatto.
     */
    public String getEmail() {
        if(this.email1==null) return "";
        else return this.email1;
    }
    
    /**
     * @brief Restituisce il secondo indirizzo email del contatto.
     * @return Il secondo indirizzo email del contatto.
     */
    public String getEmai2() {
        if(this.email2==null) return "";
        else return this.email2;
    }
    
    /**
     * @brief Restituisce il terzo indirizzo email del contatto.
     * @return Il terzo indirizzo email del contatto.
     */
    public String getEmai3() {
        if(this.email3==null) return "";
        else return this.email3;
    }
    
    /**
     * @brief Confronta l'uguaglianza tra due contatti basandosi su nome e cognome.
     * @param obj L'oggetto da confrontare.
     * @return true se i contatti sono uguali, false altrimenti.
     */    
    @Override
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj==null) return false;
        if(!(obj instanceof Contatto))
            return false;
        else{
            Contatto c=(Contatto)obj;
            if(!(this.nome.equals(c.getNome())))
                return false;
            if(!(this.cognome.equals(c.getCognome())))
                return false;
            return true;
        }
    }

    /**
     * @brief Confronta due contatti in base al cognome e, in caso di parità, al nome.
     * @param c Il contatto da confrontare.
     * @return Un valore negativo, zero o positivo in base all'ordine.
     */
    @Override
    public int compareTo(Contatto c){
        if(this.cognome.equals(c.cognome))
            return this.nome.compareTo(c.nome);
        else
            return this.cognome.compareTo(c.getCognome());
    }

    /**
     * @brief Restituisce una stringa rappresentativa del contatto.
     * @return Stringa contenente il nome e il cognome.
     */
    @Override
    public String toString() {
        return (this.getCognome()+" "+this.getNome());
    }
}
