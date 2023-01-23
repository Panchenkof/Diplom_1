import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

  private final String FILLING = "sausage";
  private final int FILLING_PRICE = 300;

  //Инициализируем объект Ingredient
  Ingredient ingredient = new Ingredient(IngredientType.FILLING, FILLING, FILLING_PRICE);
  // Проверяем метод getPrice - выводится цена ингредиента
  @Test
  public void getPriceTest() {
    float expected = FILLING_PRICE;
    float actual = ingredient.getPrice();
    assertEquals("Не корректная цена",expected, actual, 0);
  }
  // Проверяем метод getName - выводится название ингредиента
  @Test
  public void getNameTest() {
    String expected = FILLING;
    String actual = ingredient.getName();
    assertEquals("Не корректное наименование", expected, actual);
  }
  // Проверяем метод getType - выводится тип ингредиента
  @Test
  public void getTypeTest() {
    IngredientType expected = IngredientType.FILLING;
    IngredientType actual = ingredient.getType();
    assertEquals("Не корректный тип ингредиента", expected, actual);
  }


}
