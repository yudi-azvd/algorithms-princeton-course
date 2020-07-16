package AlgorithmsPrincetonCourse.Deque;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import AlgorithmsPrincetonCourse.Assignments.queues.IDeque;
import AlgorithmsPrincetonCourse.Assignments.queues.LinkedListDeque;


public class DequeTest {
  /**
   * LEMBRAR DE REFATORAR TESTES PARA
   * USAR APENAS UM TESTE PARA VÁRIAS 
   * IMPLEMENTAÇÕES DE IDEQUE
   */

  @Test
  public void theLastFirstlyAddedShouldAlwaysBeFirst() {
    IDeque<Integer> deque = new LinkedListDeque<>();
    deque.addFirst(0);
    deque.addFirst(1);
    
    int first = deque.removeFirst();
    
    assertEquals(1, first);
    
    deque = new LinkedListDeque<>();
    deque.addFirst(0);
    deque.addFirst(1);
    deque.addFirst(2);
    deque.addFirst(3);
    deque.addFirst(4);
    
    int size;
    for (int i = 4; i >= 0; --i) {
      first = deque.removeFirst();
      size = deque.size();
      assertEquals(i, first);
      assertEquals(i, size);
    }
  }

  @Test
  // theLastlyLastAddedShoulAlwaysBeLast ???
  public void theLastLastlyAddedShoulAlwaysBeLast() {
    IDeque<Integer> deque = new LinkedListDeque<>();
    deque.addLast(0);
    deque.addLast(1);
    
    int last = deque.removeLast();
    
    assertEquals(1, last);
    
    deque = new LinkedListDeque<>();

    int finalSize = 5;

    for (int i = 0; i < finalSize; i++) {
      deque.addLast(i);
    }

    // the last is finalSize - 1
    int size;
    for (int i = finalSize; i > 0; --i) {
      last = deque.removeLast();
      size = deque.size();
      assertEquals(4, last);
      assertEquals(i-1, size);
    }
  }
}