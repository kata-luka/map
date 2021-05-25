import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.company.Area;
import com.company.TerrainMap;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert.*;


public class MyTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testAreaNegativeSize(){
        expectedException.expect(ValueException.class);
        expectedException.expectMessage("значения области должны быть > 0");
        new Area(-10, -10);
    }

    @Test
    public void testAreaSizeResult(){
        Area testingArea = new Area(20, 30);
        assertEquals(testingArea.getSquareMeters(), 20 * 40);
    }

    @Test
    public void testTerrainMapCreation() throws Exception {
        expectedException.expect(NullPointerException.class);
        new TerrainMap(null, null);
        expectedException.expect(ValueException.class);
        expectedException.expectMessage("имя карты не может быть пустым");
        new TerrainMap("", null);
    }
}