long* getProcessTime(int time_count, int* time, int* result_count) {
    *result_count = 2;  
    long* result = (long*)malloc(2 * sizeof(long));
    
    long dp1 = 0, dp2 = 0; 
    long new_dp1, new_dp2;
    
    for (int i = 0; i < time_count; i++) {
        new_dp1 = (dp1 + time[i] > dp2) ? dp1 + time[i] : dp2;
        new_dp2 = (dp2 + time[i] > dp1) ? dp2 + time[i] : dp1;
        
        dp1 = new_dp1;
        dp2 = new_dp2;
    }
    
    result[0] = dp1;
    result[1] = dp2;
    
    return result;
}
int main() {
    int n;
    
    printf("Enter the number of processes: ");
    scanf("%d", &n);

    int* time = (int*)malloc(n * sizeof(int));
    printf("Enter the times for each process: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &time[i]);
    }
    
    int result_count;
    long* result = getProcessTime(n, time, &result_count);
    
    printf("Sum of times for core 1: %ld\n", result[0]);
    printf("Sum of times for core 2: %ld\n", result[1]);

    free(time);
    free(result);
    
    return 0;
}