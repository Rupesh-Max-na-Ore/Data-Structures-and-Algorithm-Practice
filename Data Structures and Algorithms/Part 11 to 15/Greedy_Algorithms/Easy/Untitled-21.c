#include <stdio.h>
#include <stdlib.h>
void main(){
    int a = 9;
    int* b = &a;
    if(
        !b || printf("ddd ")
    ) printf("abc");
}