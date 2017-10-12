package lt.gecius.test_dagger2.app;


import javax.inject.Inject;

public class MyDependency {

    // Inject constructor makes this class available for Dagger to be instantiated as it needs
    // I.e., if a @Provides method needs MyDependency, Dagger will use this constructor to create it
    @Inject
    public MyDependency() {
    }

}
