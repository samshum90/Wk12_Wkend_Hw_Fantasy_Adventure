package Skills;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpellListTest {
    SpellList spellList;
    Blizzard blizzard;

    @Before
    public void before(){
        spellList = new SpellList();
        blizzard = new Blizzard(5, 4, "All");
    }

    @Test
    public void canGetSpellListCount(){
        assertEquals( 3, spellList.getSpellListCount());
    }

    @Test
    public void canShowSpellList(){
        spellList.showSpellList();
        assertEquals( 3, spellList.getSpellListCount());
    }



}
