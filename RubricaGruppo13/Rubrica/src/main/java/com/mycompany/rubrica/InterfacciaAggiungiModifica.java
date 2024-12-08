package com.mycompany.rubrica;

import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
/**
 * @class InterfacciaAggiungiModifica
 * @brief Questa classe rappresenta l'interfaccia per aggiungere o modificare un contatto.
 *
 * Tramite questa interfaccia, l'utente potrà modificare i contatti in rubrica.
 * L'interfaccia è stata implementata come applicazione in JavaFX
 * 
 * 
 */
public class InterfacciaAggiungiModifica {
    ///Attributi
    Label aggiungiOppureModifica; ///< Etichetta per indicare l'operazione corrente (aggiunta o modifica).
    VBox[] campi = new VBox[8];   ///< Contenitore VBox per i campi di input. Contiene 8 elementi.
    Button conferma;              ///< Pulsante per confermare l'operazione.
    Button annulla;               ///< Pulsante per annullare l'operazione.

    ///Metodi
    /**
     * @brief Restituisce il nome inserito dall'utente.
     * @return Una stringa contenente il nome.
     */
    public String getNome() {
       ///Corpo vuoto
    }

    /**
     * @brief Restituisce il cognome inserito dall'utente.
     * @return Una stringa contenente il cognome.
     */
    public String getCognome() {
       ///Corpo vuoto
    }

    /**
     * @brief Restituisce i numeri di telefono inseriti dall'utente.
     * @return Un array di interi contenente i numeri di telefono.
     */
    public int[] getNumeroTelefono() {
       ///Corpo vuoto
    }

    /**
     * @brief Restituisce gli indirizzi email inseriti dall'utente.
     * @return Un array di stringhe contenente gli indirizzi email.
     */
    public String[] getEmail() {
        ///Corpo vuoto
    }
}

