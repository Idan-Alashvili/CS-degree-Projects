#include <stdio.h>
#include <stdlib.h>

int main(){
	char cmd[1024];
	int pos = 0;
	char c;
	while (1){
		c = getchar();
		if (c == EOF || c == '\n'){
			cmd[pos] = '\0';
			system(cmd);
			pos = 0;
		}
		else {
			if (pos < sizeof(cmd) - 1){
				cmd[pos++] = c;
			}
		}
	}
	return 0;
}
