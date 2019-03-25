public class ForTests {


    @BeforeSuite
    public void B() { }

    @Test()
    public void outIt(){
    System.out.println("out");
    }

    @AfterSuite
      public void A(){ }
}
