import org.jetbrains.kotlin.course.culinary.*
import org.jetbrains.kotlin.course.culinary.PotImpl
import org.jetbrains.kotlin.course.culinary.functions.CookingService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TaskTest {
    @Test
    fun testTask1() {
        CookingService().performCooking()
        assertTrue(
            PotImpl.contents.size == 3,
            "There should not be more than three tomatoes in the pot."
        )
        val notTomato = PotImpl.contents.firstOrNull { it is CutVegetable && it.type == VegetableType.Tomato }
        assertNull(notTomato) { "There is something other than tomato in pot, $notTomato" }
        assertTrue(PotImpl.simmering)
    }

    @Test
    fun testTask2() {
        CookingService().performCooking()
        assertTrue(PotImpl.tastesPerfect)
        assertTrue(PotImpl.simmering)
    }

    @Test
    fun testTask3() {
        CookingService().performCooking()
        println(actions.joinToString("\n"))
        println(SaladBowlImpl.contents)
        assertTrue(SaladBowlImpl.mixing)
    }

    @Test
    fun testTask4() {
        CookingService().performCooking()
        assertTrue(BlenderImpl.blending)
    }
}
