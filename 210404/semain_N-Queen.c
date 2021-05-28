#include <stdio.h>
#include <stdlib.h>

int n;
int cnt = 0;
int chess[15];

int check(int line){
    for(int i=0; i<line; i++){
        if(chess[i]==chess[line] || abs(chess[line]-chess[i]) == line - i)
          return 0;
    }
    return 1;
}

void nqueen(int line){
    if (line==n){
        cnt++;
        return;
    }
    for(int i=0; i<n; i++){
        chess[line] = i;
        if(check(line)){
            nqueen(line + 1);
        }
    }
}

int main() {
    scanf("%d", &n);
    nqueen(0);
    printf("%d", cnt);
    return 0;
}
