package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void kuormitettuKonstruktori1() {
        Varasto varastoK = new Varasto(10, 5);
        // RIKOTAAN TÄMÄ TARKOITUKSELLA!
        // KORJAA SEURAAVASSA COMMITISSA OLEMAAN 10
        assertEquals(11, varastoK.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void kuormitettuKonstruktori2() {
        Varasto varastoK = new Varasto(10, 5);
        assertEquals(5, varastoK.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void kuormitettuKonstruktori3() {
        Varasto varastoK = new Varasto(-2, 0);
        assertEquals(0, varastoK.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void kuormitettuKonstruktori4() {
        Varasto varastoK = new Varasto(0, 0);
        assertEquals(0, varastoK.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void kuormitettuKonstruktori5() {
        Varasto varastoK = new Varasto(10, 11);
        assertEquals(10, varastoK.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void kuormitettuKonstruktori6() {
        Varasto varastoK = new Varasto(10, 10);
        assertEquals(10, varastoK.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void kuormitettuKonstruktori7() {
        Varasto varastoK = new Varasto(10, -2);
        assertEquals(0, varastoK.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaAinakinNollaTilavuus1() {
        Varasto varasto2 = new Varasto(-2);
        assertEquals(0, varasto2.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaAinakinNollaTilavuus2() {
        Varasto varasto2 = new Varasto(0);
        assertEquals(0, varasto2.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa2() {
        double aiempiSaldo = varasto.getSaldo();
        varasto.lisaaVarastoon(-2);

        // saldon pitäisi olla sama kuin aiemmin
        assertEquals(aiempiSaldo, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa3() {
        double aiempiSaldo = varasto.getSaldo();
        varasto.lisaaVarastoon(0);

        // saldon pitäisi olla sama kuin aiemmin
        assertEquals(aiempiSaldo, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void saldoMaksimissa() {
        varasto.lisaaVarastoon(11);
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void otaVarastosta() {
        Varasto varastoK = new Varasto(10, 5);
        varastoK.otaVarastosta(-2);
        assertEquals(5, varastoK.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void otaVarastosta2() {
        Varasto varastoK = new Varasto(10, 5);
        varastoK.otaVarastosta(0);
        assertEquals(5, varastoK.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void otaVarastosta3() {
        Varasto varastoK = new Varasto(10, 5);
        varastoK.otaVarastosta(6);
        assertEquals(0, varastoK.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void toStringMuotoilu() {
        Varasto varastoK = new Varasto(10, 5);
        assertEquals("saldo = 5.0, vielä tilaa 5.0", varastoK.toString());
    }
}