#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <sys/mman.h>
#include <sys/stat.h>
#include <sys/types.h>

#define SHM_NAME "/my_shared_memory"
#define SHM_SIZE 2 // 1 byte for data, 1 byte for synchronization signal

// Signal function
void Signal(char * mem, int offset) {
    mem[offset] = 0x01;
}

// Wait function
void Wait(char * mem, int offset) {
    while (mem[offset] != 0x00) {
        usleep(100);
    }
}

int main() {
    int shm_fd = shm_open(SHM_NAME, O_CREAT | O_RDWR, 0666);
    if (shm_fd == -1) {
        perror("shm_open");
        exit(EXIT_FAILURE);
    }

    if (ftruncate(shm_fd, SHM_SIZE) == -1) {
        perror("ftruncate");
        exit(EXIT_FAILURE);
    }

    char * shared_memory = mmap(0, SHM_SIZE, PROT_READ | PROT_WRITE, MAP_SHARED, shm_fd, 0);
    if (shared_memory == MAP_FAILED) {
        perror("mmap");
        exit(EXIT_FAILURE);
    }

    // Initialize signals
    shared_memory[1] = 0x00; // Consumer signal
    shared_memory[0] = 0x00; // Data placeholder

    for (char ch = 'A'; ch <= 'Z'; ch++) {
        //wait for the consumer
        Wait(shared_memory, 1);

        shared_memory[0] = ch;
        printf("Producer wrote: %c\n", ch);

        //signal the consumer
        Signal(shared_memory, 1);

        sleep(1);
    }

    munmap(shared_memory, SHM_SIZE); // Clean
    shm_unlink(SHM_NAME);

    return 0;
}
