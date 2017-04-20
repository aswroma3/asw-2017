# asw-840-jms

Questo progetto contiene alcune applicazioni distribuite 
basate sulla **comunicazione asincrona** come **Java Message Service** (**JMS**) e **Java EE**: 

* **0-preparazione-server** 
  non è un'applicazione come le altre, ma contiene degli script 
  per la preparazione degli oggetti amministrati sull'application server Java EE *GlassFish*  

* **a-simple-producer**
  un'applicazione che genera e invia un certo numero di messaggi *JMS* 

* **b-simple-synch-consumer** 
  un'applicazione che riceve messaggi *JMS* in modo sincrono 

* **c-cancellable-synch-consumer** 
  un'applicazione che riceve messaggi *JMS* in modo sincrono, 
  variante di **b-simple-synch-consumer**, 
  che può essere arrestata premendo il tasto *ENTER*/*INVIO* della tastiera 
  
* **d-simple-asynch-consumer** 
  un'applicazione che riceve messaggi *JMS* in modo asincrono 
  (può essere arrestata premendo il tasto *ENTER*/*INVIO* della tastiera) 

* **e-message-queue-browser** 
  un'applicazione per leggere messaggi *JMS* da una coda 
  (i messaggi non vengono consumati, ma rimangono nella coda) 
  
* **f-simple-filter** 
  un'applicazione che riceve messaggi *JMS* in modo asincrono 
  da un canale per messaggi, li filtra (li trasforma) e li invia 
  ad un altro canale per messaggi 
  (può essere arrestata premendo il tasto *ENTER*/*INVIO* della tastiera) 

* **g-multiple-producers-consumers** 
  un'applicazione che istanzia più produttori e più consumatori di messaggi *JMS* 
  e genera un log dello scambio di messaggi 
  
Le diverse applicazioni hanno una struttura simile, 
e la loro costruzione ed esecuzione è descritta qui di seguito. 

## Build  

Per la costruzione di ciascuna di queste applicazioni 
(tranne **0-preparazione-server**, che non richiede costruzione), 
vedere le istruzioni descritte nella sezione [projects/](../). 

## Componenti eseguibili 

Ciascuna applicazione (tranne **0-preparazione-server**, che non è un'applicazione)
è composta da un solo componente eseguibile di tipo *appclient*, 
che dopo la costruzione è presente 
nella cartella **dist/client** dell'applicazione. 

## Ambiente di esecuzione 

Ciascuna applicazione va eseguita nell'ambiente 
[glassfish](../../environments/glassfish/): 
gli script di **0-preparazione-server** sul nodo **glassfish** e
le applicazioni sul nodo **client**.

## Preparazione 

Preliminarmente all'esecuzione delle applicazioni *JMS* 
è necessario avviare e configurare l'application server *GlassFish* sul server **glassfish**, come segue: 

* sul nodo **glassfish**, posizionarsi nella cartella **0-preparazione-server** 

   a. lo script `a-start-glassfish.sh` avvia l'application server *GlassFish*
      (di solito non è necessario avviare manualmente *GlassFish*, 
      poiché *Vagrant* lo fa ad ogni avvio della macchina virtuale **glassfish**)

   b. lo script `b-create-jms-resources.sh` consente di creare le risorse *JMS* necessarie alle diverse applicazioni 
      (questo script va eseguito una sola volta, e comunque prima di eseguire le applicazioni di questo progetto) 

   c. lo script `c-list-jms-resources.sh` consente di elencare le risorse *JMS* presenti nel sistema 
      (per verifica) 

   d. lo script `d-delete-jms-resources.sh` consente di cancellare le risorse *JMS*, se non sono più necessarie  

   e. lo script `e-stop-glassfish.sh` arresta l'application server *GlassFish* 
      (ma di solito non è necessario farlo)  


## Esecuzione 

Per eseguire un'applicazione (dopo la *Preparazione*) si proceda in questo modo: 

1. sul nodo **client** 

   a. posizionarsi nella cartella principale dell'applicazione 

   b. eseguire lo script `dist/client/run-appclient.sh` 
      (in questo caso l'applicazione invia messaggi o riceve messaggi alla/dalla coda `jms/asw/Queue`)

   c. in alternativa, con il comando `dist/client/run-appclient.sh jms/asw/Topic` 
      l'applicazione invia messaggi o riceve messaggi al/dal topic `jms/asw/Topic`)
      
Alcune considerazioni aggiuntive: 

* per realizzare un sistema con un produttore di messaggi e un consumatore di messaggi per la coda `jms/asw/Queue`
  
  * in un client, eseguire `b-simple-synch-consumer/dist/client/run-appclient.sh` 
    oppure `c-cancellable-synch-consumer/dist/client/run-appclient.sh`
    oppure `d-simple-asynch-consumer/dist/client/run-appclient.sh`

  * in un altro client, eseguire `a-simple-producer/dist/client/run-appclient.sh`
  
* per realizzare un sistema con un produttore di messaggi e un consumatore di messaggi per il topic `jms/asw/Topic`
  
  * in un client, eseguire `b-simple-synch-consumer/dist/client/run-appclient.sh jms/asw/Topic` 
    oppure `c-cancellable-synch-consumer/dist/client/run-appclient.sh jms/asw/Topic`
    oppure `d-simple-asynch-consumer/dist/client/run-appclient.sh jms/asw/Topic`
    
  * in un altro client, eseguire `a-simple-producer/dist/client/run-appclient.sh jms/asw/Topic`
  
* per realizzare un sistema con un produttore di messaggi per `jms/asw/Queue`, 
  un filtro di messaggi da `jms/asw/Queue` a `jms/asw/Topic` 
  e un consumatore di messaggi da `jms/asw/Topic`

  * in un client, eseguire `b-simple-synch-consumer/dist/client/run-appclient.sh jms/asw/Topic` 
    oppure `c-cancellable-synch-consumer/dist/client/run-appclient.sh jms/asw/Topic`
    oppure `d-simple-asynch-consumer/dist/client/run-appclient.sh jms/asw/Topic`

  * in un altro client, eseguire `f-simple-filter/dist/client/run-appclient.sh jms/asw/Queue jms/asw/Topic`

  * in un altro client ancora, eseguire `a-simple-producer/dist/client/run-appclient.sh jms/asw/Queue`
