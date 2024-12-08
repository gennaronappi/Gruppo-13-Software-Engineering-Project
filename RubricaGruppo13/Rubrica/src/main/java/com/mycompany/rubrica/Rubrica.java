package com.mycompany.rubrica;
import java.util.*;
import java.io.*;

/**
 * @class Rubrica
 * @brief Classe main del programma
 * 
 * La classe Rubrica è la classe principale, in quanto gestisce la struttura dati che andrà a contenere i contatti,
 * risultando una rubrica a tutti gli effetti, e implementando una interfaccia grafica
 * che permetta all'utente di interagire con questa struttura dati.
 * La struttura dati scelta è un TreeSet, così da ordinare automaticamente i contatti in ordine alfabetico.
 * La classe prevede inoltre l'impiego di un Database,
 * per salvare le info della struttura dati nel momento in cui l'applicazione viene chiusa.
 * 
 * 
 * @author Francesco
 * @date 8 Dicembre 2024
 * @version 1.0
 */
public class Rubrica {

    
    public static void main(String[] args) {
        ///Attributi
        Set<Contatto> lista=new TreeSet<>();///< Creazione della struttura dati
        InterfacciaRubrica view=new InterfacciaRubrica();///< Creazione dell'interfaccia principale
        
        ///Metodi
        /**
         * @brief  Il metodo toString restituisce una stringa con l'elenco di tutti i contatti
         * @return Elenco dei contatti
         */
        @Override
        public String toString(){
        }
        
        /**
         * @brief Il metodo aggiungiContatto viene invocato
         * quando l'utente clicca sull'omonimo tasto presente in InterfacciaRubrica
         * @param c Il contatto viene preso in input dai campi di InterfacciaAggiungiModifica
         * quando l'utente clicca sul tasto "Salva"
         * @pre Il nome O il cognome del contatto DEVONO essere non nulli
         * @post Il contatto viene aggiunto alla struttura dati
         */
        public void aggiungiContatto(Contatto c){
        }
        
        /**
         * @brief Il metodo modificaContatto viene invocato
         * quando l'utente clicca su un tasto "Modifica" presente in InterfacciaRubrica
         * @param cOld Rappresenta il contatto con le vecchie info,viene selezionato dall'utente
         * @param cNew Rappresenta il contatto con le nuove info, che andrà a rimpiazzare cOld.
         * Le info vengono prese in input dai campi di InterfacciaAggiungiModifica
         * quando l'utente clicca sul tasto "Salva"
         * @pre Il nome O il cognome di cNew DEVONO essere non nulli
         * @post Le info del contatto vengono modificate
         */
        public void modificaContatto(Contatto cOld, Contatto cNew){ 
        }
        
        /**
         * @brief Il metodo rimuoviContatto viene invocato
         * quando l'utente clicca su un tasto "Elimina" presente in InterfacciaRubrica
         * @param c Il contatto viene selezionato dall'utente
         * @pre La rubrica deve essere non vuota
         * @post Il contatto viene rimosso dalla struttura dati
         */
        public void rimuoviContatto(Contatto c){
        }
        
        /**
         * @brief Il metodo ricercaContatto viene invocato
         * quando l'utente clicca sul tasto "Cerca" presente in InterfacciaRubrica
         * @param s La stringa viene presa in input dalla casella di ricerca presente in InterfacciaRubrica
         * quando l'utente clicca sul tasto "Cerca"
         * @return Una struttura dati contenente tutti i contatti che comprendono la stringa nel nome o nel cognome
         * @post La nuova struttura dati viene mostrata al posto di quella completa
         */
        public Set<Contatto> ricercaContatto(String s){  
        }
        
        /**
         * @brief Il metodo dowloadContatti viene invocato
         * quando l'utente clicca sull'omonimo tasto presente in InterfacciaRubrica
         * @return Un file dove ssono presenti tutti i contatti contenuti nella rubrica
         */
        public FileOutputStream downloadContatti(){
        }
        
        /**
         * @brief Il metodo uploadContatti viene invocato
         * quando l'utente clicca sul tasto "Upload file" presente in InterfacciaRubrica
         * @param file Il file viene inserito in input dall'utente tramite InterfacciaUpload
         * @post I contatti presenti nel file vengono aggiunti alla struttura dati
         */
        public void uploadContatti(FileInputStream file){
        }
        
        
        
    }
    
}
