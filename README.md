[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=17518896)
**Titolo: Gestione di un centro sportivo**  

Un centro sportivo intende implementare un software per la gestione dei soci e degli istruttori che frequentano le sue strutture.  

Il software deve essere realizzato attraverso la classe principale **CentroSportivo** e deve permettere l’inserimento, la gestione e la rimozione di soci e istruttori, oltre a verificare eventuali conflitti di assegnazione.  

### Specifiche:  
1. **Soci**  
   - I soci sono caratterizzati da **nome**, **cognome**, e **codice socio** (un codice univoco alfanumerico).  
   - È possibile:  
     - Registrare un socio tramite il metodo `aggiungiSocio()` che riceve come parametri **nome**, **cognome**, e **codice socio** e restituisce `true` se l'inserimento è avvenuto con successo, `false` altrimenti (es. se il socio è già presente). 
     - Rimuovere un socio dal sistema tramite il metodo `rimuoviSocio()`, che riceve come parametro il **codice socio** e restituisce `true` se la rimozione è avvenuta con successo, `false` altrimenti (es. se il socio non esiste o se è ancora assegnato a un istruttore).  
     - Ottenere le informazioni di un socio tramite il metodo `getSocio()`, che restituisce un riferimento al socio o `null` se il codice non esiste.  

2. **Istruttori**  
   - Gli istruttori sono caratterizzati da **nome**, **cognome**, e **codice istruttore** (un codice univoco alfanumerico).  
   - È possibile:  
     - Registrare un istruttore tramite il metodo `aggiungiIstruttore()`, che riceve come parametri **nome**, **cognome**, e **codice istruttore** e restituisce `true` se l'inserimento è avvenuto con successo, `false` altrimenti (es. istruttore già presente). 
     - Rimuovere un istruttore dal sistema tramite il metodo `rimuoviIstruttore()`, che riceve come parametro il **codice istruttore** e restituisce `true` se la rimozione è avvenuta con successo, `false` altrimenti (es. se l’istruttore ha soci assegnati o se l'istruttore non esiste).  
     - Ottenere le informazioni di un istruttore tramite il metodo `getIstruttore()`, che restituisce un riferimento all'istruttore o `null` se il codice non esiste.  

3. **Assegnazioni**  
   - I soci possono essere assegnati a uno o più istruttori tramite il metodo `assegnaIstruttore()`, che riceve come parametri il **codice socio** e il **codice istruttore**. Il metodo restituisce:  
     - `true` in caso di assegnazione riuscita.  
     - `false` in caso di fallimento (es. socio o istruttore inesistente o se il socio è già stato assegnato allo stesso istruttore).  
   - Un socio può essere rimosso da un’assegnazione con un istruttore specifico tramite il metodo `rimuoviAssegnazione()`, che riceve il **codice socio** e il **codice istruttore**. Il metodo restituisce `true` se l’assegnazione è stata rimossa, `false` altrimenti (es. socio o istruttore inesistente o se il socio non è stato assegnato all'istruttore).  
   - Dato il codice di un istruttore, è possibile ottenere la lista dei soci assegnati tramite il metodo `getSoci()` della classe CentroSportivo che restituisce una stringa contenente tutti i soci (uno per riga).
   
4. **Attività**
	- E' possibile aggiungere delle attività individuali al centro sportivo. Un' attività prevede un socio, un instruttore, una data, un orario di inizio, un orario di fine e una descrizione.
	- E' possibile aggiungere una nuova attività se e solo se il socio è associato al relativo istruttore. In caso contrario il metodo ritornerà il valore `false`.
	- `aggiungiAttivita()`, che riceve come parametri il **codice socio**, il **codice istruttore**, la **data**, l' **orario di inizio** e l' **orario di fine**.  
	
	(Extra: il metodo ritornerà false anche nel caso in cui il socio e/o l'istruttore in quel determinato giorno e in quella determinata ora sono già impegnati in altre attività.
	
	Data memorizzata come AAAAMMGG e orario come HH:MM).
	
5. **Caricamento dei dati**  
   - Il metodo `caricaDati()` permette di leggere da un file soci, istruttori, assegnazioni e attività. (Solito formato del file)
   
6. **Salvataggio dei dati**  
   - Il metodo `salvaDati()` permette di esportare in un file di testo lo stato attuale del sistema, salvando soci, istruttori, assegnazioni e attività con il formato specificato per il caricamento.