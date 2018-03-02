package lt.gecius.test_dagger2.intoset;

import java.util.Map;

import dagger.Component;

@Component(modules = TestModule.class)
public interface TestComponent {

    Map<String, Item> getMap();
}
