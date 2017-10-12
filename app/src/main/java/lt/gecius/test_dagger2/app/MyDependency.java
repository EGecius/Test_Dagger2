package lt.gecius.test_dagger2.app;


import javax.inject.Inject;

public class MyDependency {

    private InjectAnnotatedDependency mInject;
    private ProvidesAnnotatedDependency mProvides;

    // Inject constructor makes this class available for Dagger to be instantiated as it needs
    // I.e., if a @Provides method needs MyDependency, Dagger will use this constructor to create it
    @Inject
    public MyDependency(InjectAnnotatedDependency inject, ProvidesAnnotatedDependency provides) {
        mInject = inject;
        mProvides = provides;
    }

    @Override
    public String toString() {
        return "MyDependency{" +
                "mInject=" + mInject +
                ", mProvides=" + mProvides +
                '}';
    }
}
