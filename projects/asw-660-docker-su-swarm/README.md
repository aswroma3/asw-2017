# asw-660-docker-su-swarm 

Questo progetto contiene una applicazione di esempio 
e gli script per il suo rilascio sullo swarm docker **swarm.inf.uniroma3.it**. 

Questa applicazione è accessibile al link [http://swarm.inf.uniroma3.it:8080/](http://swarm.inf.uniroma3.it:8080/). 

### Premessa 

Copiare nella cartella *swarm.inf.uniroma3.it/resources/certs* i certificati ricevuti per posta elettronica. 

### Applicazione **sentence**

**Poiché questa applicazione è stata già rilasciata sullo swarm docker, 
le istruzioni che seguono vanno intese come esempio, e non come istruzioni da eseguire direttamente!!!**

Istruzioni per il rilascio dell'applicazione **sentence** su **swarm.inf.uniroma3.it** 
(operazioni da eseguire dalla cartella *sample-sentence-service*): 
  
* nella macchina [developer](../../environments/developer/), eseguire lo script `./build-all-projects.sh`

* poi, nella macchina [docker](../../environments/docker/), eseguire lo script `./build-all-images.sh`

* poi, nella macchina [docker](../../environments/docker/), eseguire lo script `./push-all-images.sh`

* infine, nella macchina [docker](../../environments/docker/), eseguire lo script `./start-sentence-stack.sh`

Dopo di che, l'applicazione sarà accessibile al link [http://swarm.inf.uniroma3.it:8080/](http://swarm.inf.uniroma3.it:8080/). 


