package com.mycompany.rubrica;
/**
 * @class Contatto
 * @brief Classe che rappresenta un contatto nella rubrica.
 */
public class Contatto {
    // Attributi
    private String nome;          ///< Nome del contatto.
    private String cognome;       ///< Cognome del contatto.
    private int[] numeroTelefono; ///< Array contenente fino a 3 numeri di telefono.
    private String[] email;       ///< Array contenente fino a 3 indirizzi email.

    // Metodi
    /**
     * @brief Costruttore per creare un nuovo contatto.
     * @param nome Nome del contatto.
     * @param cognome Cognome del contatto.
     * @param numeroTelefono Array di numeri di telefono (massimo 3).
     * @param email Array di email (massimo 3).
     */
    public Contatto(String nome, String cognome, int[] numeroTelefono, String[] email) {
        // Corpo vuoto
    }

    /**
     * @brief Imposta il nome del contatto.
     * @param nome Il nuovo nome.
     */
    public void setNome(String nome) {
        // Corpo vuoto
    }

    /**
     * @brief Restituisce il nome del contatto.
     * @return Il nome del contatto.
     */
    public String getNome() {
        return null; // Corpo vuoto
    }

    /**
     * @brief Imposta il cognome del contatto.
     * @param cognome Il nuovo cognome.
     */
    public void setCognome(String cognome) {
        // Corpo vuoto
    }

    /**
     * @brief Restituisce il cognome del contatto.
     * @return Il cognome del contatto.
     */
    public String getCognome() {
        return null; // Corpo vuoto
    }

    /**
     * @brief Restituisce una stringa rappresentativa del contatto.
     * @return Stringa con il nome e il cognome.
     */
    @Override
    public String toString() {
        return null; // Corpo vuoto
    }
}