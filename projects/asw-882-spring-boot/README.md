# asw-882-spring-boot

Questo progetto contiene alcune applicazioni 
che esemplificano l'uso di [Spring Boot](https://projects.spring.io/spring-boot/):  

* **a-hello** è un esempio minimale di applicazione Spring Boot  

* **b-hello-web** è un esempio minimale di applicazione web Spring Boot 

* **c-hello-web-thymeleaf** esemplifica Spring Web MVC 

* **d1-hello-rest** esemplifica un servizio REST 

* **d2-hello-rest-client** esemplifica un client per il servizio REST **d1-hello-rest**

* **e1-team-rest** esemplifica un servizio REST in cui vengono scambiati oggetti di dominio con JSON e/o XML 

* **e2-team-rest-client** esemplifica un client per il servizio rest **e1-team-rest**

* **f-team-data-jpa** esemplifica l'uso di Spring Data JPA 

* **g-team-data-rest** esemplifica l'uso di Spring Data REST 

* **h-team-data-rest-links** esemplifica l'uso dei link HATEOAS con Spring Data REST

* **i-team-actuator** esemplifica l'uso di Spring Boot Actuator 

* **j-lucky-word-properties** esemplifica l'uso delle proprietà per la configurazione delle applicazioni 

* **k-lucky-word-profiles** esemplifica l'uso dei profili per la configurazione delle applicazioni

* **l1-word-service** è un servizio per la generazione di parole casuali, utilizzato dal servizio **l2-sentence-service**

* **l2-sentence-service** è un servizio per la generazione di frasi casuali, che accede i servizi **l1-word-service**

Le diverse applicazioni hanno una struttura simile, 
e la loro costruzione ed esecuzione è descritta qui di seguito. 

### Build  

Per la costruzione di ciascuna applicazione, vedere le istruzioni 
descritte nella sezione [projects/](../). 

In pratica, per compilare e assemblare ciascuna applicazione, bisogna 

1. posizionarsi nella cartella principale dell'applicazione di interesse - ad esempio `~/projects/asw-882-spring-boot/a-hello`

2. per compilare e assemblare l'applicazione, usare il comando `gradle build` 

### Ambiente di esecuzione 

Ciascuna di queste applicazioni può essere eseguita direttamente nell'ambiente 
[developer](../../environments/developer/), sul nodo **dev**. 
In questo modo, le applicazioni web che espongono servizi alla porta **8080** del nodo **dev** 
vengono anche pubblicate sulla porta **8088** dell'host. 

### Esecuzione 

Per eseguire un'applicazione (ad eccezione delle applicazioni **j-lucky-word-properties**, 
**k-lucky-word-profiles**, **l1-word-service** e **l2-sentence-service**, descritte più avanti): 

1. posizionarsi nella cartella principale dell'applicazione di interesse - ad esempio `~/projects/asw-882-spring-boot/a-hello`

2. eseguire il comando `gradle bootRun` - attenzione, bisogna usare il task `bootRun` di Gradle, e non il task `run`

#### Esecuzione dell'applicazione **j-lucky-word-properties** 

Posizionarsi nella cartella principale dell'applicazione, `~/projects/asw-882-spring-boot/j-lucky-word-properties` e poi: 

* eseguire lo script `../run-with-default-property.sh` per avviare il servizio usando la parola fortunata di default (la parola fortunata è *Default*)

* eseguire lo script `../run-with-argument.sh` per avviare il servizio passando la parola fortunata come un argomento (la parola fortunata è *Argument*)

* eseguire lo script `../run-with-env-variable.sh` per avviare il servizio passando la parola fortunata mediante una variabile d'ambiente (la parola fortunata è *Environment variable*)

#### Esecuzione dell'applicazione **k-lucky-word-profiles** 

Posizionarsi nella cartella principale dell'applicazione, `~/projects/asw-882-spring-boot/j-lucky-word-properties` e poi: 

* eseguire lo script `../run-as-default.sh` per avviare il servizio usando il profilo di default (la parola fortunata è *Default*)

* eseguire lo script `../run-as-english.sh` per avviare il servizio usando il profilo **english** (la parola fortunata è *Happy*)

* eseguire lo script `../run-as-italian.sh` per avviare il servizio usando il profilo **italian** (la parola fortunata è *Evviva*)

#### Esecuzione dell'applicazione per la generazione di frasi casuali 

In terminali diversi, fare quanto segue: 

* nella cartella principale del servizio **l1-word-service** eseguire lo script `../run-word-service-as-subject.sh` 
 
* nella cartella principale del servizio **l1-word-service** eseguire lo script `../run-word-service-as-verb.sh` 

* nella cartella principale del servizio **l1-word-service** eseguire lo script `../run-word-service-as-object.sh` 

* nella cartella principale del servizio **l2-sentence-service** eseguire lo script `../run-sentence-service.sh` 



