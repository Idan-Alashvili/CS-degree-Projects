#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <semaphore.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>

int main(int argc, char *argv[]) {
    sem_t* sem[6];
    char sem_name[10];
    for (int i = 0; i < 6; i++) {
        sprintf(sem_name, "family%d", i);
        sem[i] = sem_open(sem_name, O_CREAT, 0777, 0);
        if (sem[i] == SEM_FAILED) {
            perror("sem_open error");
            return -1;
        }
    }

    // Ensure the first semaphore is initialized to 1
    sem_post(sem[0]);
    pid_t p2 = fork();
    if (p2 == 0) {
        sem_wait(sem[5]); // Wait for the sixth semaphore
        puts("p2");
    	printf("ID: %d, Parent ID: %d.\n", getpid(), getppid());    
        exit(0);
    }

    pid_t p3 = fork();
    if (p3 == 0) {
        sem_wait(sem[1]); // Wait for the second semaphore
        puts("p3");
   	printf("ID: %d, Parent ID: %d.\n", getpid(), getppid());    
        sem_post(sem[2]); // Signal the third semaphore
        exit(0);
    }

    pid_t p4 = fork();
    if (p4 == 0) {
        sem_wait(sem[0]); // Wait for the first semaphore
        puts("p4");
    	printf("ID: %d, Parent ID: %d.\n", getpid(), getppid());    
        sem_post(sem[1]); // Signal the second semaphore
        exit(0);
    }

    pid_t p5 = fork(); 
    if (p5 == 0) {
        sem_wait(sem[2]); // Wait for the third semaphore
        puts("p5");
    	printf("ID: %d, Parent ID: %d.\n", getpid(), getppid());    
        sem_post(sem[3]); // Signal the fourth semaphore
        exit(0);
    }

    pid_t p6 = fork();
    if (p6 == 0) {
        sem_wait(sem[4]); // Wait for the fifth semaphore
        puts("p6");
    	printf("ID: %d, Parent ID: %d.\n", getpid(), getppid());    
        sem_post(sem[5]); // Signal the sixth semaphore
        exit(0);
    }

    sem_wait(sem[3]); // Wait for the fourth semaphore
    puts("p1");
    printf("ID: %d, Parent ID: %d.\n", getpid(), getppid());    
    sem_post(sem[4]); // Signal the fifth semaphore

    // Wait for all child processes of p1 to finish
    for (int i = 0; i < 5; i++) {
        wait(NULL);
    }

    // Clean up semaphores
    for (int i = 0; i < 6; i++) {
        sprintf(sem_name, "family%d", i);
        sem_unlink(sem_name);
        sem_close(sem[i]);
    }

    return 0;
}
