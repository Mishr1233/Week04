package org.example.mealplangenerator;


//Define an interface MealPlan representing different meal categories
interface MealPlan {
    String getMealPlanType();
}

//Define specific meal categories implementing MealPlan interface
class VegetarianMeal implements MealPlan {
    @Override
    public String getMealPlanType() {
        return "Vegetarian Meal Plan";
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getMealPlanType() {
        return "Vegan Meal Plan";
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getMealPlanType() {
        return "Keto Meal Plan";
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public String getMealPlanType() {
        return "High-Protein Meal Plan";
    }
}

//Create a generic Meal class that accepts a type parameter T that extends MealPlan
class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public void displayMealPlanInfo() {
        System.out.println("Generated " + mealPlan.getMealPlanType());
    }

    //Generic method to validate and generate a personalized meal plan dynamically
    public static <T extends MealPlan> void validateAndGenerateMealPlan(T mealPlan) {
        // Validation logic (e.g., ensuring valid meal types)
        if (mealPlan == null) {
            System.out.println("Invalid meal plan selection.");
            return;
        }

        // Generate meal plan
        System.out.println("Meal Plan Generated: " + mealPlan.getMealPlanType());
    }
}

//The main class to simulate the Personalized Meal Plan Generator system
public class MealPlanGenerator {

    public static void main(String[] args) {
        //Create instances of different meal plans
        Meal<VegetarianMeal> vegetarianMeal = new Meal<>(new VegetarianMeal());
        Meal<VeganMeal> veganMeal = new Meal<>(new VeganMeal());
        Meal<KetoMeal> ketoMeal = new Meal<>(new KetoMeal());
        Meal<HighProteinMeal> highProteinMeal = new Meal<>(new HighProteinMeal());

        //Generate and validate different personalized meal plans using the generic method
        Meal.validateAndGenerateMealPlan(new VegetarianMeal());
        Meal.validateAndGenerateMealPlan(new VeganMeal());
        Meal.validateAndGenerateMealPlan(new KetoMeal());
        Meal.validateAndGenerateMealPlan(new HighProteinMeal());

        //Display meal plan information for each meal
        vegetarianMeal.displayMealPlanInfo();
        veganMeal.displayMealPlanInfo();
        ketoMeal.displayMealPlanInfo();
        highProteinMeal.displayMealPlanInfo();
    }
}
