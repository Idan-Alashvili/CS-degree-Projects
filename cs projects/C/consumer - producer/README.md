# Shared Memory Synchronization Project

### Course: מערכות הפעלה (Operating Systems)
### Project Grade: 98
### Author: Idan Alashvili

## Project Overview

This project demonstrates **shared memory synchronization** between a **producer** and a **consumer** using POSIX shared memory. The producer generates characters and writes them into a shared memory segment, while the consumer reads the characters from the shared memory. Synchronization between the producer and consumer is achieved using simple signaling mechanisms.

### Key Features:
- **Shared Memory**: The producer and consumer communicate using a shared memory segment created and managed through POSIX APIs.
- **Synchronization**: Synchronization is handled using two bytes in the shared memory: one for data and one for signaling between the producer and consumer.
- **Producer-Consumer Model**: The producer writes characters ('A' to 'Z') into shared memory, and the consumer reads these characters sequentially.

## Files

- **Producer**: `producer.c`
  - The producer program that creates and writes characters into the shared memory segment. It also signals the consumer when data is ready.

- **Consumer**: `consumer.c`
  - The consumer program that reads characters from the shared memory segment and prints them. It also signals the producer when it is ready for new data.

## How It Works

### Producer:
1. **Setup**: Creates a shared memory segment and initializes it.
2. **Data Writing**: Writes characters 'A' to 'Z' into the shared memory.
3. **Synchronization**: Signals the consumer when data is ready and waits until the consumer has processed the data.

### Consumer:
1. **Setup**: Opens the existing shared memory segment.
2. **Data Reading**: Reads characters from the shared memory and prints them.
3. **Synchronization**: Signals the producer that it is ready to receive new data and waits for the producer to signal that data is available.

### Signal Mechanism:
- **Signal Function**: Updates a byte in shared memory to indicate the state (e.g., data is available or ready for new data).
- **Wait Function**: Blocks execution until a specific condition in the shared memory is met.

## Usage on Linux

### Running the Producer:
1. Compile the producer code:
   ```bash
   gcc -o producer producer.c -lrt
2. Run the producer program:
  ```bash
   gcc -o consumer consumer.c -lrt
```
### Running the Consumer:
1. Compile the consumer code:
  ```bash
  gcc -o consumer consumer.c -lrta
```
2. Run the consumer program:
  ```bash
  ./consumer
```
### Example Output:
- ## Producer Output :
  ```yaml
  Producer wrote: A
  Producer wrote: B
  ...
  Producer wrote: Z
- Consumer Output:
  ```arduino
  Consumer read: A
  Consumer read: B
  ...
  Consumer read: Z

# Shared Memory Synchronization Project

## Files

- **`producer.c`**: Contains code to produce and write characters to shared memory and synchronize with the consumer.
- **`consumer.c`**: Contains code to consume and read characters from shared memory and synchronize with the producer.
- **`Makefile`** (Optional): You can add a Makefile for easier compilation.

## Future Improvements

- Implement more complex synchronization mechanisms for multiple producers and consumers.
- Enhance error handling and resource management.
- Explore different IPC (Inter-Process Communication) methods and compare their performance.

## Acknowledgements

This project was completed as part of the "מערכות הפעלה" course on Linux and demonstrates fundamental concepts in operating systems and inter-process communication.
