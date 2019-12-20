This is the companion website to the paper **Generation of Invalid Test Inputs from Over-Constrained Test Models for Combinatorial Robustness Testing** by Konrad Fögen and Horst Lichter. It is submitted to the IEEE International Workshop on*Combinatorial Testing and its Applications* [(IWCT-2020)](http://gist.nju.edu.cn/iwct2020/) and currently in review.

- *src/main/java/de/rwth/swc/iwct2020* contains source code which implements the system models used for experimentation
- *src/test/java/de/rwth/swc/iwct2020/experiments* contains the test to execute the experiment
- *src/test/java/de/rwth/swc/iwct2020/example* contains two example tests to illustrate the usage of soft constraint handling strategies

To obtain more detailed reports, the test methods must be executed either individually in the IDE or via `mvn clean test`. Please keep in mind that executing all scenarios might take some time. 

Reference implementations of the algorithms presented in the paper are also published. See https://coffee4j.github.io/ for more information.

```java
class ExampleTest {

    @CombinatorialTest
    @ModelFromMethod("testModel")
    @Generator(
            algorithms = {Ipog.class, IpogNeg.class},
            factories = {HardConstraintCheckerFactory.class, DiagnosticConstraintCheckerFactory.class})
    void testExample(String title, String firstName, String givenName) {
        /* Stimulate the System under Test */
    }

    static InputParameterModel testModel() {
        return testModel("example")
                .parameters(
                        parameter("Title").values("Mr", "Mrs", "123"),
                        parameter("FirstName").values("John", "Jane", "123"),
                        parameter("GivenName").values("Doe", "123")
                ).errorConstraints(
                        constrain("Title", "FirstName").withName("valid-mr")
                                .by((String title, String firstName) ->
                                        !(title.equals("Mr") && firstName.equals("Jane"))
                                     && !(title.equals("Mr") && firstName.equals("123"))),
                        constrain("Title").withName("valid-title") 
                                .by((String title) -> !title.equals("123")),
                        constrain("FirstName").withName("valid-firstname")
                                .by((String firstName) -> !firstName.equals("123")),
                        constrain("GivenName").withName("valid-givenname")
                                .by((String givenName) -> !givenName.equals("123")),
                        constrain("Title", "FirstName").withName("valid-mrs")
                                .by((String title, String firstName) ->
                                        !(title.equals("Mrs") && firstName.equals("John"))
                                     && !(title.equals("Mrs") && firstName.equals("123")))
                )
               .build();
    }
}
```

