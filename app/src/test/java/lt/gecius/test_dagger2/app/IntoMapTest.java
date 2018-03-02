package lt.gecius.test_dagger2.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.Map;

import lt.gecius.test_dagger2.intoset.DaggerTestComponent;
import lt.gecius.test_dagger2.intoset.Item;
import lt.gecius.test_dagger2.intoset.TestComponent;
import lt.gecius.test_dagger2.intoset.TestModule;

public class IntoMapTest {

    TestComponent mTestComponent =  DaggerTestComponent.builder().build();

    @Test
    public void test1() {
        Map<String, Item> map = mTestComponent.getMap();

        assertEquals(map.get(TestModule.ITEM_1).name, TestModule.NAME_1);
        assertEquals(map.get(TestModule.ITEM_2).name, TestModule.NAME_2);
    }

}