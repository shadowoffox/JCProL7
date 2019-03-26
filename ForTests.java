public class ForTests {
String out;
    @BeforeSuite
    public void StartTest() {
        System.out.println("DO IT!");
    }

    @Test(priority = Test.Priority.lowerst)
    public void outIt1(){
        System.out.println("out lowest");
    }

    @Test(priority = Test.Priority.very_low)
    public void outIt2(){
        System.out.println("out very_low");
    }

    @Test(priority = Test.Priority.lower)
    public void outIt3(){
        System.out.println("out lower");
    }
    @Test(priority = Test.Priority.low)
    public void outIt4(){
        System.out.println("out low");
    }

    @Test()
    public void outIt5(){
    System.out.println("out medium");
    }

    @Test(priority = Test.Priority.hight)
    public void outIt6(){
        System.out.println("out hight");
    }

    @Test(priority = Test.Priority.highter)
    public void outIt7(){
        System.out.println("out highter");
    }

    @Test(priority = Test.Priority.very_hight)
    public void outIt8(){
        System.out.println("out very_hight");
    }

    @Test(priority = Test.Priority.hightest)
    public void outIt9(){
        System.out.println("out hightest");
    }

    @AfterSuite
      public void StopTest(){
        System.out.println("STOP IT!");
    }
}
