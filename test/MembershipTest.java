import membership.Membership;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MembershipTest {

    /*Inaktive medlemmer skal betale 500 kr. Derfor hvis den første "false" ændres til true,
    og du derefter kører metoden alene (eller hele klassen) vil testen slå fejl, fordi "expectedFee"
    er 500kr for inaktive medlemmer ligegyldigt alder.*/
    @Test
    void testFeeForInactiveMember() {
        Membership m = new Membership(1, "Inaktiv", 60, false, false, false);
        assertEquals(500, m.expectedFee());
    }


    /*Aktive medlemmer under 18 skal betale 1000 kr. Derfor hvis du ændrer alderen til over 18,
    vil testen slå fejl der. */
    @Test
    void testFeeForJuniorMember() {
        Membership m = new Membership(2, "Junior", 12, true, false, false);
        assertEquals(1000, m.expectedFee());
    }

    //Aktive medlemmer mellem 18 og 59 skal betale 1600 kr.
    @Test
    void testFeeForAdultMember() {
        Membership m = new Membership(3, "Voksen", 30, true, false, false);
        assertEquals(1600, m.expectedFee());
    }

    //Aktive medlemmer på 60 år eller over skal betale 1200 kr.
    @Test
    void testFeeForSeniorMember() {
        Membership m = new Membership(4, "Senior", 65, true, false, false);
        assertEquals(1200, m.expectedFee());
    }

    //18-årige klassificeres som voksne og betaler 1600 kr.
    @Test
    void testFeeJuniorToAdult() {
        Membership m = new Membership(5, "Grænsetilfælde for junior til voksen", 18, true, false, false);
        assertEquals(1600, m.expectedFee());
    }

    //60-årige klassificeres som senior og betaler 1200 kr.
    @Test
    void testFeeAdultToSenior() {
        Membership m = new Membership(6, "Grænsetilfælde for voksen til senior", 60, true, false, false);
        assertEquals(1200, m.expectedFee());
    }
}

/*
- Testen fanger fejl og dokumenterer også, hvordan metoderne bør opføre sig, f.eks. hvis der ændres i inaktiv
  til aktiv, så fortæller den hvad der gik galt.
- I stedet for først at opdage fejl, når vi kører selve programmet, kan man hurtigt spotte dem i testfasen, ved at
  teste enkelte dele.
- Dokumentation for hvad skal kunne, så kan man hurtigt se hvilke regler der gælder de forskellige steder.
 */