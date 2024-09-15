#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <wait.h>
#include <sys/types.h>

int main(){
	pid_t p1,p2,p3,p4,p5,p6;
	int status;
	if (p1=fork()==0){
		if(p2=fork()==0){
			if(p3=fork()==0){
				printf("p3 ");
				exit(0);
			}
			waitpid(p3,&status,0);
			printf("p2 ");
			exit(0);
		}
		waitpid(p2,&status,0);
		if(p4 = fork() == 0){
			if(p6 = fork() == 0){
				printf("p6 ");
				exit(0);
			}
			if(p5 = fork() == 0){
				printf("p5 ");
				exit(0);
			}
			waitpid(p6,&status,0);
			waitpid(p5,&status,0);
			printf("p4 ");
			exit(0);
		}
		waitpid(p4,&status,0);
		printf("p1 ");
	}
	return 0;
}
