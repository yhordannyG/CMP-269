
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    LehmanGradeBook gb = new LehmanGradeBook();
    @Test
    @DisplayName("Grade 70 should return true for passing")
    void testPassingGrade() {
        assertTrue(gb.isPassing(70));
    }
    @Test
    void testLetterGradeA() {
        assertEquals('A', gb.getLetterGrade(95));
    }
    @Test
    void testLetterGradeF() {
        assertEquals('F', gb.getLetterGrade(50));
    }
    @Test
    void testBoundaryGrades() {
        assertEquals('A', gb.getLetterGrade(90));
        assertEquals('B', gb.getLetterGrade(80));
        assertEquals('C', gb.getLetterGrade(70));
    }
    @Test
    void testInvalidGradeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            gb.isPassing(150);
        });
    }
}