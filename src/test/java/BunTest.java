import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
  Bun bun;

  private final String BUN = "black bun";
  private final int BUN_PRICE = 100;

  @Before
  public void setUp(){
    bun = new Bun(BUN, BUN_PRICE);
  }


  @Test
  public void getNameBunTest(){
    String actualBun = "black bun";
    String expectedBun = bun.getName();
    Assert.assertEquals("Ожидается имя булки - black bun", expectedBun, actualBun);
  }

  @Test
  public void getPriceBunTest() {
    float expectedPrice = 100;
    float actualPrice = bun.getPrice();
    Assert.assertEquals("Ожидается цена - 100", expectedPrice, actualPrice, 0);
  }

}
