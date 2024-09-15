#include <stdio.h>
#include <unistd.h>
#include <wait.h>
#include <stdlib.h>
#include <sys/types.h>

int main(){
	int input;
	do{
		printf("Enter a number between 2-10:\n");
		scanf("%d",&input);
		}
		while (input < 2 || input > 10);

	for(int i = 0; i < input; i++){
		pid_t p = fork();
		if (p == 0){
			printf("I am %d\n",getpid());
		}
		if (p != 0){
			waitpid(p,NULL,0);
			break;
		}
	}
	return 0;
}
