import org.junit.Test;

import static com.google.common.truth.Truth.*;

public class SLListTest {

    @Test
    public void testSLListAdd() {
        SLList test1 = SLList.of(1, 3, 5); /* test1: {1, 3, 5} */
        SLList test2 = new SLList(); /* test2: {} */

        test1.add(1, 2); /* test1: {1, 2, 3, 5}*/
        test1.add(3, 4); /* test1: {1, 2, 3, 4, 5}*/
        assertWithMessage("test1 does not have a size of 5").that(test1.size()).isEqualTo(5);
        assertWithMessage("test1 does not have 3 at index 2 or 4 at index 3").that(test1.equals(SLList.of(1, 2, 3, 4, 5))).isTrue();

        test2.add(1, 1); /* test2: {1} */
        assertWithMessage("test2 does not contain 1").that(test2.equals(SLList.of(1))).isTrue();
        assertWithMessage("test2 does not have a size of 1").that(test2.size()).isEqualTo(1);

        test2.add(10, 10); /* test2: {1, 10} */
        assertWithMessage("test2 is incorrect after adding at an out-of-bounds index").that(test2.equals(SLList.of(1, 10))).isTrue();
        test1.add(0, 0); /* test1: {0, 1, 2, 3, 4, 5}*/
        assertWithMessage("test1 is incorrect after addition at the front").that(test1.equals(SLList.of(0, 1, 2, 3, 4, 5))).isTrue();
    }

    @Test
    public void testSLListReverse() {
        // TODO: Add tests

        // 空链表测试
        SLList emptyList = new SLList();
        emptyList.reverse();
        assertWithMessage("Reversing an empty list should still be empty").that(emptyList.equals(new SLList())).isTrue();

        // 单元素链表测试
        SLList singleElementList = SLList.of(1);
        singleElementList.reverse();
        assertWithMessage("Reversing a single-element list should not change it").that(singleElementList.equals(SLList.of(1))).isTrue();

        // 多元素链表测试
        SLList multiElementList = SLList.of(1, 2, 3, 4, 5);
        multiElementList.reverse();
        assertWithMessage("Reversing a multi-element list failed").that(multiElementList.equals(SLList.of(5, 4, 3, 2, 1))).isTrue();

        // 重复元素测试
        SLList duplicateElementList = SLList.of(1, 2, 2, 1);
        duplicateElementList.reverse();
        assertWithMessage("Reversing a list with duplicate elements failed").that(duplicateElementList.equals(SLList.of(1, 2, 2, 1))).isTrue();
    }
}
