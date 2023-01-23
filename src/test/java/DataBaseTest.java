import org.junit.Test;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class DataBaseTest {

  // Проверяю что база данных возвращает список булок
  // Проверяемый метод - AvailableBuns
  @Test
  public void checkAvailableBuns() {
    Database database = new Database();
    List<Bun> buns = database.availableBuns();
    assertNotNull(buns);
  }
  // Проверяю что база данных возвращает список ингредиентов
  // Проверяемый метод - AvailableIngredients
  @Test
  public void checkAvailableIngredients() {
    Database database = new Database();
    List<Ingredient> ingredient = database.availableIngredients();
    assertNotNull(ingredient);
  }

}
