package lt.gecius.test_dagger2.app

data class Message(val stringMsg: String, private val mMyDependency: MyDependency)