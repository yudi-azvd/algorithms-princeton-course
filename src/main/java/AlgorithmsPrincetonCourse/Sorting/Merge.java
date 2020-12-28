package AlgorithmsPrincetonCourse.Sorting;

import java.util.Arrays;

/**
 * Versão mais simples do algoritmo Mergesort, sem melhorias.
 */
public class Merge {
  public static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
    assert isSorted(a, lo, mid);
    assert isSorted(a, mid+1, hi);

    // copiar a[] em aux[]
    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k];
    }
    
    // k é iterador de a[]
    int i = lo, j = mid+1;
    for (int k = lo; k <= hi; k++) {
      if (i > mid)
        a[k] = aux[j++];
      else if (j > hi)
        a[k] = aux[i++];
      else if (aux[i] < aux[j])
        a[k] = aux[i++];
      else
        a[k] = aux[j++];
    }

    assert isSorted(a, lo, hi);
  }

  
  private static void sort(int[] a, int[] aux, int lo, int hi) {
    if (hi <= lo) return;

    int mid = (lo + hi)/2;
    sort(a, aux, lo, mid);
    sort(a, aux, mid+1, hi);
    // if (a[mid] < a[mid+1]) return; // possível melhoria
    merge(a, aux, lo, mid, hi);
    System.out.println(Arrays.toString(a)); 

    assert isSorted(a, lo, hi);
  }

  
  /**
   * Usa {@link Insertion#sort(int[], int, int)} para ordenar pequenos 
   * subarrays. Um nome mais claro seria sortWithInsertionSortCutoff. 
   * Nesse ponto talvez seja necessário atualizar esse algoritmo quando 
   * estudar Insertionsort.
   */
  // private static void sortWithCutoff(int[] a, int[] aux, int lo, int hi) {
  //   if (hi <= lo) return;

  //   // if (hi <= lo +  cutoff - 1) {
  //   //   Insertion.sort(a, lo, hi);
  //   //   return;
  //   // }

  //   int mid = (lo + hi)/2;
  //   sortWithCutoff(a, aux, lo, mid);
  //   sortWithCutoff(a, aux, mid+1, hi);
  //   merge(a, aux, lo, mid, hi);


  //   assert isSorted(a, lo, hi);
  // }

  public static void sort(int[] a) {
    int[] aux = new int[a.length];

    sort(a, aux, 0, a.length-1);
  }

  public static boolean isSorted(int[] a, int lo, int hi) {
    for (int i = lo + 1; i <= hi; i++)
      if (a[i-1] > a[i])
        return false;
    return true;
  }


  public static void main(String[] args) {
    int[] a = new int[] {
      // 13, 15, 1, 9, 10, 6, 6, 2, 7
      101, 97, 115, 121, 113, 117, 101, 115, 116, 105, 111, 110
      // 1, 2, 9, 13, 15,  6, 6, 7, 10
    };  
    
    sort(a);

    // merge(a, aux, 0, a.length/2, a.length-1);

    System.out.println(Arrays.toString(a));
  }
}
