import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

  private final String name;
  private final IngredientType type;
  private final float price;

  public IngredientTypeTest(String name, IngredientType type, float price) {
    this.name = name;
    this.type = type;
    this.price = price;
  }

  @Parameterized.Parameters
  public static Object[][] dataTest() {
    return new Object[][]{
            {"hai-xiang", SAUCE, 180f},
            {"shrimps", FILLING, 250f},
            {"onion", FILLING, 50f},
            {"cheese", FILLING, 300f}
    };
  }
  // Проверяем работу класса перечисление - выводятся названия вариантов типов ингредиентов
  @Test
  public void checkIngredientType() {
    Ingredient ingredient = new Ingredient(type, name, price);
    assertEquals("Нет корректного типа ингредиентов", type, ingredient.getType());
  }
}
