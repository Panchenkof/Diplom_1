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

  private final String BUN = "Краторная булка";
  private final int BUN_PRICE = 1200;
  private final String FILLING = "Говяжий метеорит";
  private final int FILLING_PRICE = 3200;

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

}
