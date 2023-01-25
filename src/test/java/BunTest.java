import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

  private final String name;
  private final float bunPrice;

  public BunTest(String name, float bunPrice) {
    this.name = name;
    this.bunPrice = bunPrice;
  }

  @Parameterized.Parameters
  public static Object[][] dataTest() {
    return new Object[][]{
            {"black bun", 100f},
            {"", 100f},
            {null, 100f},
            {"£%$^", 100f},
            {"dfhdshdshhjtjrtjjnrtghjdehjndshdfbdfbdfhfhdfhgrhrthj", 100f},
            {"black bun", 0},
            {"", 0},
            {null, 0},
            {"£%$^", 0},
            {"dfhdshdshhjtjrtjjnrtghjdehjndshdfbdfbdfhfhdfhgrhrthj", 0},
            {"black bun", Float.MAX_VALUE},
            {"", Float.MAX_VALUE},
            {null, Float.MAX_VALUE},
            {"£%$^", Float.MAX_VALUE},
            {"dfhdshdshhjtjrtjjnrtghjdehjndshdfbdfbdfhfhdfhgrhrthj", Float.MAX_VALUE},
            {"black bun", -100f},
            {"", -100f},
            {null, -100f},
            {"£%$^", -100f},
            {"dfhdshdshhjtjrtjjnrtghjdehjndshdfbdfbdfhfhdfhgrhrthj", -100f},
            {"black bun", 0.000000000001f},
            {"", 0.000000000001f},
            {null, 0.000000000001f},
            {"£%$^", 0.000000000001f},
            {"dfhdshdshhjtjrtjjnrtghjdehjndshdfbdfbdfhfhdfhgrhrthj", 0.000000000001f}
    };
  }

  @Test
  public void getNameBunTest() {
    Bun bun = new Bun(name, bunPrice);
    assertEquals("Ожидается корректное имя булки", name, bun.getName());
  }

  @Test
  public void getPriceBunTest() {
    Bun bun = new Bun(name, bunPrice);
    Assert.assertEquals("Ожидается корректная цена", bunPrice, bun.getPrice(), 0);
  }

}
