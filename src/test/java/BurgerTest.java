import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BurgerTest {

  Burger burger;

  private final String BUN = "white bun";
  private final int BUN_PRICE = 200;
  private final String SAUCE = "sour cream";
  private final int SAUCE_PRICE = 200;
  private final String FILLING = "cutlet";
  private final int FILLING_PRICE = 100;

  // Применяются методы стаба, возвращается объект булочка
  public Bun getMockedBun(String name, float price) {
    Bun bun = mock(Bun.class);
    when(bun.getName()).thenReturn(name);
    when(bun.getPrice()).thenReturn(price);
    return bun;
  }

  // Применяются методы стаба, возвращается объект ингредиенты
  public Ingredient getMockedIngredient(IngredientType type, String name, float price) {
    Ingredient ingredient = mock(Ingredient.class);
    when(ingredient.getType()).thenReturn(type);
    when(ingredient.getName()).thenReturn(name);
    when(ingredient.getPrice()).thenReturn(price);
    return ingredient;
  }
  // Перед каждым тестом создаю объект бургер
  @Before
  public void setUp() {
    burger = new Burger();
  }

  // Проверяем метод setBun - выбрать булочку
  @Test
  public void setBunTest() {
    Bun expected = getMockedBun (BUN, BUN_PRICE);
    burger.setBuns(expected);
    Assert.assertEquals(expected, burger.bun);
  }
  // Проверяем метод addIngredient - добавить ингредиенты
  @Test
  public void addIngredientTest() {
    Ingredient expected = getMockedIngredient(IngredientType.FILLING, FILLING, FILLING_PRICE);
    burger.addIngredient(expected);
    Ingredient actual = burger.ingredients.get(0);
    Assert.assertEquals("Добавляем начинку " + FILLING + " с ценой " + FILLING_PRICE, expected, actual);
  }

  // Проверяем метод removeIngredient - удалить ингредиенты
  @Test
  public void removeIngredientTest() {
    Ingredient ingredient = getMockedIngredient(IngredientType.FILLING, FILLING, FILLING_PRICE);
    burger.addIngredient(ingredient);
    burger.removeIngredient(0);
    Assert.assertTrue(burger.ingredients.isEmpty());
  }
  // Проверяем метод moveIngredient - перемещаем ингредиенты по списку
  @Test
  public void moveIngredientTest() {
    Ingredient firstIngredient = getMockedIngredient(IngredientType.FILLING, FILLING, FILLING_PRICE);
    Ingredient secondIngredient = getMockedIngredient(IngredientType.SAUCE, SAUCE, SAUCE_PRICE);
    burger.addIngredient(firstIngredient);
    burger.addIngredient(secondIngredient);
    burger.moveIngredient(0, 1);
    Assert.assertEquals(firstIngredient.name, burger.ingredients.get(1).name);
  }
  // Проверяем метод getPrice - получаем в итоге цену
  @Test
  public void getPriceTest() {
    Bun bun = getMockedBun(BUN, BUN_PRICE);
    Ingredient ingredient = getMockedIngredient(IngredientType.FILLING, FILLING, FILLING_PRICE);
    burger.setBuns(bun);
    burger.addIngredient(ingredient);
    float actual = burger.getPrice();
    Assert.assertEquals(500, actual, 0);
  }
  // Проверяем метод getReceipt - выводится рецепт бургера
  @Test
  public void getReceiptTest() {
    Bun bun = getMockedBun(BUN, BUN_PRICE);
    Ingredient ingredient = getMockedIngredient(IngredientType.FILLING, FILLING, FILLING_PRICE);
    burger.setBuns(bun);
    burger.addIngredient(ingredient);
    String actual = burger.getReceipt();
    String expected = String.format("(==== white bun ====)%n" +
            "= filling cutlet =%n" +
            "(==== white bun ====)%n" +
            "%n" +
            "Price: 500,000000%n");
    Assert.assertEquals("Receipt - " + expected, expected, actual);
  }

}
