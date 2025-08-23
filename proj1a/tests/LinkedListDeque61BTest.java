import jh61b.utils.Reflection;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

/** Performs some basic linked list tests. */
public class LinkedListDeque61BTest {

    @Test
    /** In this test, we have three different assert statements that verify that addFirst works correctly. */
    public void addFirstTestBasic() {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();

        lld1.addFirst("back"); // after this call we expect: ["back"]
        assertThat(lld1.toList()).containsExactly("back").inOrder();

        lld1.addFirst("middle"); // after this call we expect: ["middle", "back"]
        assertThat(lld1.toList()).containsExactly("middle", "back").inOrder();

        lld1.addFirst("front"); // after this call we expect: ["front", "middle", "back"]
        assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();

        /* Note: The first two assertThat statements aren't really necessary. For example, it's hard
           to imagine a bug in your code that would lead to ["front"] and ["front", "middle"] failing,
           but not ["front", "middle", "back"].
         */
    }

    @Test
    /** In this test, we use only one assertThat statement. IMO this test is just as good as addFirstTestBasic.
     *  In other words, the tedious work of adding the extra assertThat statements isn't worth it. */
    public void addLastTestBasic() {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();

        lld1.addLast("front"); // after this call we expect: ["front"]
        lld1.addLast("middle"); // after this call we expect: ["front", "middle"]
        lld1.addLast("back"); // after this call we expect: ["front", "middle", "back"]
        assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();
    }

    @Test
    /** This test performs interspersed addFirst and addLast calls. */
    public void addFirstAndAddLastTest() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

        /* I've decided to add in comments the state after each call for the convenience of the
           person reading this test. Some programmers might consider this excessively verbose. */
        lld1.addLast(0);   // [0]
        lld1.addLast(1);   // [0, 1]
        lld1.addFirst(-1); // [-1, 0, 1]
        lld1.addLast(2);   // [-1, 0, 1, 2]
        lld1.addFirst(-2); // [-2, -1, 0, 1, 2]

        assertThat(lld1.toList()).containsExactly(-2, -1, 0, 1, 2).inOrder();
    }

    //Below, you'll write your own tests for LinkedListDeque61B.
    @Test
    /**This method will test the size() method and isEmpty() method */
    public void sizeAndisEmptyTest() {
        Deque61B<String> d = new LinkedListDeque61B<>();
        assertThat(d.isEmpty()).isTrue();
        assertThat(d.size()).isEqualTo(0);

        d.addFirst("a");
        assertThat(d.isEmpty()).isFalse();
        assertThat(d.size()).isEqualTo(1);

        d.addLast("b");
        assertThat(d.size()).isEqualTo(2);

        d.addFirst("c");
        assertThat(d.size()).isEqualTo(3);

    }

    @Test
    /**This test will test the get method */
    public void getTest() {
        Deque61B<String> d = new LinkedListDeque61B<>();
        d.addLast("a");
        d.addLast("b");
        d.addLast("c");
        assertThat(d.get(0)).isEqualTo("a");
        assertThat(d.get(1)).isEqualTo("b");
        assertThat(d.get(2)).isEqualTo("c");

        assertThat(d.get(5)).isNull();
        assertThat(d.get(-2)).isNull();
    }

    @Test
    public void removeFirstAndRemoveLastTest() {
        Deque61B<String> d = new LinkedListDeque61B<>();
        d.addLast("a");
        d.addLast("b");
        d.addLast("c");

        d.removeFirst();
        assertThat(d.toList()).containsExactly("b", "c").inOrder();
        d.addFirst("a");

        d.removeLast();
        assertThat(d.toList()).containsExactly("a", "b").inOrder();
    }

    @Test
    public void getRecursiveTest() {
        Deque61B<Integer> d = new LinkedListDeque61B<>();
        // 空与非法索引
        assertThat(d.getRecursive(0)).isNull();
        assertThat(d.getRecursive(-1)).isNull();

        // 添加元素
        for (int i = 0; i < 5; i++) d.addLast(i); // [0,1,2,3,4]
        for (int i = 0; i < 5; i++) {
            assertThat(d.getRecursive(i)).isEqualTo(i);
            // 与 get 一致
            assertThat(d.getRecursive(i)).isEqualTo(d.get(i));
        }

        // 越界
        assertThat(d.getRecursive(5)).isNull();
        assertThat(d.getRecursive(100)).isNull();

        // 删除后再次检查
        d.removeFirst(); // [1,2,3,4]
        d.removeLast();  // [1,2,3]
        assertThat(d.getRecursive(0)).isEqualTo(1);
        assertThat(d.getRecursive(2)).isEqualTo(3);
        assertThat(d.getRecursive(3)).isNull();

        // 单元素场景
        Deque61B<String> single = new LinkedListDeque61B<>();
        single.addFirst("x");
        assertThat(single.getRecursive(0)).isEqualTo("x");
        assertThat(single.getRecursive(1)).isNull();
    }
}