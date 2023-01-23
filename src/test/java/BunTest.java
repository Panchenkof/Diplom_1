import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
  Bun bun;

  private final String BUN = "Краторная булка";
  private final int BUN_PRICE = 1200;

  @Before
  public void setUp(){
    bun = new Bun(BUN, BUN_PRICE);
  }


  @Test
  public void getNameBunTest(){
    String actualBun = "Краторная булка";
    String expectedBun = bun.getName();
    Assert.assertEquals("Ожидается имя булки - Краторная булка", expectedBun, actualBun);
  }

  @Test
  public void getPriceBunTest() {
    float expectedPrice = 1200;
    float actualPrice = bun.getPrice();
    Assert.assertEquals("Ожидается цена - 1200", expectedPrice, actualPrice, 0);
  }

}
