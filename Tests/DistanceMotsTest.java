import org.junit.jupiter.api.*;

public class DistanceMotsTest {

    @Test
    void MotsVides() throws Exception{
        Assertions.assertEquals(DistanceMots.levenshtein("",""), 0);
    }

    @Test
    void PremierMotVide() throws Exception{
        Assertions.assertEquals(DistanceMots.levenshtein("","test"), 4);
    }

    @Test
    void DeuxiemeMotVide() throws Exception{
        Assertions.assertEquals(DistanceMots.levenshtein("test",""), 4);
    }

    @Test
    void MotsIdentiques() throws Exception{
        Assertions.assertEquals(DistanceMots.levenshtein("test","test"), 0);
    }

    @Test
    void MotsTotalementDiff() throws Exception{
        Assertions.assertEquals(DistanceMots.levenshtein("test","diff"), 4);
    }

    @Test
    void MotsPartiellementDiff() throws Exception{
        Assertions.assertEquals(DistanceMots.levenshtein("partiellement","differents"), 9);
    }
}
