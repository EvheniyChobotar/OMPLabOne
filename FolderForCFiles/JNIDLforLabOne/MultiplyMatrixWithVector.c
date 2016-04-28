#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include <omp.h>
#include "JNIHeaderforLabOne.h"

void    Initialization();
void    TestCorrectInitialization();
double  ParallelCalculate();
double  SequentialCalculte();
void    FreeMemory();

double  **A, *B, *C, SUM,   
           t_start, t_end;
long N;

JNIEXPORT jdouble JNICALL Java_mainPack_Main_nativeParallelMultiplyMatrixWithVector(JNIEnv *env, jobject obj1, jint Dimension)
{
    N = Dimension;
    Initialization(); 
    TestCorrectInitialization();
    double time = ParallelCalculate(); 
    FreeMemory();    
    return time;
}

JNIEXPORT jdouble JNICALL Java_mainPack_Main_nativeSequentialMultiplyMatrixWithVector(JNIEnv *env, jobject obj1, jint Dimension)
{
    N = Dimension;
    Initialization(); 
    TestCorrectInitialization();
    double time = SequentialCalculte();
    FreeMemory();    
    return time;
}

void Initialization()
{
   
    int i,j;
    A = (double**)malloc(N*sizeof(double));
    for(i=0;i<N;i++)
        A[i]=(double*)malloc(N*sizeof(double));
   
    B = (double*)malloc(N*sizeof(double));
    C = (double*)malloc(N*sizeof(double));

    for (i = 0; i < N; i++)
        for (j = 0; j < N; j++)
            A[i][j] = (double)i;
    for (i=0; i < N; i++)
        B[i] = 1.0;
     
}

void TestCorrectInitialization()
{
    if(N<2)
    {
        printf("Usage: mxv N [+]\n");
        exit(1);
    }
    
    if ( !A || !B || !C ) 
    {
        printf("Not enough memory!\n");
        exit(2);
    }
}

double  ParallelCalculate()
{
    omp_set_num_threads(4);
    int i,j;
    t_start = omp_get_wtime();   
    
#pragma omp parallel for default(none) shared(A, B, C, N)  private(i, j, SUM)
   
    for (i=0; i < N; i++) {
        SUM = 0.0;
        for(j=0; j < N; j++)
            SUM += A[i][j] * B[j];
        C[i] = SUM;
    }
    t_end = omp_get_wtime();
    
    return t_end - t_start;
}

double SequentialCalculte()
{
    int i,j;
    t_start = omp_get_wtime();   
    
    for (i=0; i < N; i++) {
        SUM = 0.0;
        for(j=0; j < N; j++)
            SUM += A[i][j] * B[j];
        C[i] = SUM;
    }
    t_end = omp_get_wtime();
    
    return t_end - t_start;
}

void FreeMemory()
{
    free(A);
    free(B);
    free(C);
}
