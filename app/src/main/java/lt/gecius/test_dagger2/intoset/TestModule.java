package lt.gecius.test_dagger2.intoset;


import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public class TestModule {

    public static final String ITEM_1 = "item_1";
    public static final String ITEM_2 = "item_2";

    public static final String NAME_1 = "name_1";
    public static final String NAME_2 = "name_2";

    @Provides @IntoMap
    @StringKey(ITEM_1)
    public Item provideItem1() {
        return new Item(NAME_1);
    }

    @Provides @IntoMap
    @StringKey(ITEM_2)
    public Item provideItem2() {
        return new Item(NAME_2);
    }

}
