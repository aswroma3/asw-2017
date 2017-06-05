# Docker 

Ambiente di esecuzione composto da un cluster (*swarm*) di nodi Docker, 
composto da tre macchine virtuali **swarm-1**, **swarm-2** e **swarm-3**. 

## Descrizione delle macchine virtuali 

Le tre macchine virtuali hanno la stessa struttura: 

### swarm-i

La macchina virtuale **swarm-i** (10.11.1.70+i) 
ha il seguente software 

* Ubuntu Trusty (14.04 LTS) a 64 bit 

* Docker 

* Docker Compose 

Configurazione di rete 

* Indirizzo IP: 10.11.1.70+i (per esempio, **swarm-i** ha l'indirizzo 10.11.1.71)

* Porte pubblicate sull'host: 8080 -> 8080+i (per esempio, **swarm-i** ha la porta 8080 pubblicata sulla porta 8081 dell'host)
  
## Configurazione  
 
Dopo aver creato l'ambiente (`vagrant up`) e dopo averlo riavviato (`vagrant reload`), 
è necessario collegarsi al nodo *swarm-1* (`vagrant ssh swarm-1`) 
ed eseguire (una volta per tutte) lo script `setup-swarm-sh`. 