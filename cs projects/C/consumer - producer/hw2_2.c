#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <semaphore.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h> 

int main(int argc,char * argv[]){
  pid_t p1,p2,p3,p4,p5,p6;
  int status;
  sem_t* sem[6];
  char sem_name[10];  
  for (int i = 0; i < 6; i++) {
        sprintf(sem_name, "family%d", i);
        sem[i] = sem_open(sem_name, O_CREAT, 0777, 0);
        if (!sem[i]) {
            perror("sem_open error");
            return -1;
        }
        sem_init(sem[i], 1, 0);
    }
  
  p2 = fork();        
  sem_post(sem[0]);     
  if(p2 == 0 ) {
    sem_wait(sem[1]);
    puts("p2");
    printf("ID: %d, Parent ID: %d.\n", getpid(), getppid());    
    p3 = fork();
    if(p3 == 0 ){
      sem_post(sem[2]); 
      sem_wait(sem[3]); 
      puts("p3");
      printf("ID: %d, Parent ID: %d.\n", getpid(), getppid());
      sem_post(sem[4]);
      exit(0);
    }
    wait(NULL);
    exit(0);
  }
  
  sem_wait(sem[0]);       
  if ((p4 = fork()) == 0){
    puts("p4");
    printf("ID: %d, Parent ID: %d.\n", getpid(), getppid());
    sem_post(sem[1]);        
    sem_wait(sem[2]);  
    p6 = fork();
    if(p6 == 0){
      puts("p6");
      printf("ID: %d, Parent ID: %d.\n", getpid(), getppid());
      sem_post(sem[3]);    
      exit(0);
    }
    
    sem_wait(sem[4]); 
    p5 = fork();
    if( p5 == 0){
      puts("p5");
      printf("ID: %d, Parent ID: %d.\n", getpid(), getppid());
      sem_post(sem[5]);
      exit(0);
    }
    wait(NULL);    
    wait(NULL);
    exit(0);
  }

  sem_wait(sem[5]);
  puts("p1");
  printf("ID: %d, Parent ID: %d.\n", getpid(), getppid());
  return 0; 
}
