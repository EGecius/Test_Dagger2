package lt.gecius.test_dagger2.di.intoset;

import dagger.Component;
import lt.gecius.test_dagger2.app.IntoSetActivity;

@Component (modules = IntoSetModule.class)
public interface IntoSetComponent {

    void injectInto(IntoSetActivity activity);
}
