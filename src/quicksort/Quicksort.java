/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

/**
 *
 * @author Renan Duarte
 */
public class Quicksort {
    private int A[];
    private int tempo = 0; //contagem de tempo de execução
    
    private void troca(int i, int j){
        int temp = A[i];
        tempo += 1;
        A[i] = A[j];
        tempo += 1;
        A[j] = temp;
        tempo += 1;
    }
    
    public Quicksort(int[] A){
        this.A = A;
    }
    
    private int particionar(int p, int r){
        int x = A[r];
        tempo += 1;
        int i = p - 1;
        tempo += 1;
        for(int j=p;j<r;j++){
            if(A[j] <= x){
                i++;
                tempo+=1;
                troca(i,j);
            }
        }
        troca(i+1,r);
        tempo += 1;
        return i+1;
    }
    
    /**
     * Realiza a ordenação rápida
     * @param p início do subvetor A[p..r]
     * @param r final do subvetor A[p..r]
     */
    public void sort(int p, int r){
        if(p<r){
            int q = particionar(p, r);
            sort(p, q-1);
            sort(q+1, r);
        }
    }
    
    public void mostrar(){
        for(int i=0;i<A.length;i++){
            System.out.print(A[i]+" ");
        }
    }

    public void exibirTempo(){
        System.out.println("Tempo de execução: "+tempo+"ms");
    }
    
}

