import com.kiluange.generator.StringGeneratorBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GeneratorTest {

    @Test
    void testDefaultGeneratedId(){
        var generator = new StringGeneratorBuilder.Builder().create();
        Assertions.assertEquals(8,generator.generateId().length());
    }

    @Test
    void testAlphanumericGeneratedId(){
        var generator = new StringGeneratorBuilder.Builder()
                .alphanumeric(true)
                .create();

        Assertions.assertTrue(generator.generateId().matches("[A-Z0-9]*"));
    }

    @Test
    void testNonAlphanumericGeneratedId(){
        var generator = new StringGeneratorBuilder.Builder()
                .alphanumeric(false)
                .create();

        Assertions.assertTrue(generator.generateId().matches("^[A-Z]*$"));
    }

    @Test
    void testErrorValidationAlphanumericGeneratedId(){
        var generator = new StringGeneratorBuilder.Builder()
                .alphanumeric(true)
                .create();

        Assertions.assertFalse(generator.generateId().matches("^[A-Z]*$"));
    }

    @Test
    void testGeneratedIdWithPrefix(){
        var generator = new StringGeneratorBuilder.Builder()
                .alphanumeric(true)
                .prefix("TEST")
                .create();

        Assertions.assertTrue(generator.generateId().contains("TEST"));
    }

    @Test
    void testGeneratedIdWithSuffix(){
        var generator = new StringGeneratorBuilder.Builder()
                .alphanumeric(true)
                .suffix("TEST")
                .create();

        Assertions.assertTrue(generator.generateId().contains("TEST"));
    }
}
