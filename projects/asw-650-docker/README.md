# asw-650-docker

Questo progetto contiene alcuni esempi di contesti per la creazione di immagini e di contenitori *Docker*. 
I contenitori possono essere creati ed eseguiti nell'ambiente [docker](../../environments/docker/). 

In particolare, ci sono tre progetti Docker: 

* il contenitore **a-hello-world**, che quando avviato mostra un saluto 

* il contenitore **b-apache-http-server** per un server HTTP (che pubblica le pagine HTML nella cartella `~/docker/www` dell'host) 

* il contenitore **c-data-volume**, che gestisce un volume di pagine HTML da pubblicare con il server HTTP, alternativo al progetto precedente 

### Ambiente di esecuzione 

Questi contenitori vanno eseguiti nell'ambiente [docker](../../environments/docker/). 

