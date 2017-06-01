# asw-885-spring-cloud

Questo progetto contiene alcune applicazioni 
che esemplificano l'uso di [Spring Cloud](http://projects.spring.io/spring-cloud/) 
per la realizzazione di applicazioni *multi-servizi*. 

Gli esempi sono relativi a due applicazioni principali, mostrate in più versioni: 

* l'applicazione **lucky-word**  

* l'applicazione **sentence**  


### Applicazione **lucky-word**

L'applicazione **lucky-word** è formata da due servizi: 

* **a1-common-config-server** è un configuration server (Spring Cloud Config) 

* **a2-lucky-word-cloud-config-client** è invece l'applicazione web, che accede come client al configuration server 

Per eseguire questa applicazione, bisogna costruire e avviare i due servizi, come di consueto per le applicazioni Spring Boot. 


### Applicazione **sentence**

L'applicazione **sentence** è invece formata da più servizi, e realizzata in più versioni (alcune delle quali condividono gli stessi servizi): 
  
* **b-common-eureka-server** è un discovery server (Eureka), da usare in tutte le versioni dell'applicazione  

* **c-word-service** è il servizio per la generazione di parole casuali, da usare in tutte le versioni dell'applicazione  

* **d1-sentence-service-discovery** è una versione del servizio per la generazione delle frasi, che utilizza solo il service discovery Eureka 

* **d2-sentence-service-ribbon** è una versione del servizio per la generazione delle frasi, che utilizza il load balancer lato client Ribbon 

* **d3-sentence-service-feign** è una versione del servizio per la generazione delle frasi, che utilizza il client REST basato su Feign 

* **d4-sentence-service-hystrix** è una versione del servizio per la generazione delle frasi, che utilizza Hystrix come circuit breaker 

* **d5-sentence-service-zuul** è una versione del servizio per la generazione delle frasi, che utilizza Zuul come API gateway 

* **e1-sentence-service** è un'altra versione del servizio per la generazione delle frasi, da usare insieme a **e2-common-zuul-gateway**, in cui il servizio per le frasi è separato dal gateway Zuul     

Per eseguire questa applicazione, bisogna costruire i diversi servizi, come di consueto, 
e poi avviarli (di solito vengono forniti degli script per l'avvio dei singoli servizi). 


### Build  

Per la costruzione di ciascuna applicazione, vedere le istruzioni 
descritte nella sezione [projects/](../). 

In pratica, per compilare e assemblare ciascuna applicazione, bisogna 

1. posizionarsi nella cartella principale dell'applicazione di interesse - ad esempio `~/projects/asw-885-spring-cloud/a1-common-config-server`

2. per compilare e assemblare l'applicazione, usare il comando `gradle build` 

### Ambiente di esecuzione 

Ciascuna di queste applicazioni può essere eseguita direttamente nell'ambiente 
[developer](../../environments/developer/), sul nodo **dev**. 
In questo modo, le applicazioni web che espongono servizi alla porta **8080** del nodo **dev** 
vengono anche pubblicate sulla porta **8088** dell'host. 

Si suggerisce però di modificare la configurazione del nodo **dev**
dell'ambiente [developer](../../environments/developer/)
assegnandogli una quantità maggiore di risorse. Ad esempio: `v.cpus = 2` e `v.memory = 4096`

### Esecuzione 

Per eseguire un'applicazione, bisogna avviare individualmente i servizi che la compongono, 
usando gli script forniti con i singoli servizi oppure il comando `gradle bootRun` 
