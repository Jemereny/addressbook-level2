package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {


    @Test
    public void elementsAreUnique() throws Exception {
        // empty list
        assertAreUnique();

        // only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");

        // all objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);

        // some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, new Integer(1));
        assertNotUnique(null, 1, new Integer(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    @Test
    public void elementsNotNull() throws Exception
    {
        // Empty
        assertIsNotNull();

        // No null object
        assertIsNotNull("");
        assertIsNotNull(1);
        assertIsNotNull("abc");
        assertIsNotNull('a');
        assertIsNotNull(1, "abc", 'a');

        // At least 1 null
        assertIsNull(1, null);
        assertIsNull("abc", null);
        assertIsNull('a', null);
        assertIsNull("ABC",null, 123);
        assertIsNull(null, "ABC", 123);

        // Some null object
        assertIsNull(null, null, null);
        assertIsNull(null, null, 123);
        assertIsNull(null, "ABC", 'A', null);
        assertIsNull(123, "abc", null, null);
    }

    private void assertIsNull(Object... items)
    {
        assertTrue(Utils.isAnyNull(items));
    }

    private void assertIsNotNull(Object... items)
    {
        assertFalse(Utils.isAnyNull(items));
    }

}
