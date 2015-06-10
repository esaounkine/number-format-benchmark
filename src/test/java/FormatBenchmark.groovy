import implementations.Assylias
import implementations.EduardoAviles
import implementations.Esaounkine
import implementations.Jhurtado
import implementations.Jzd
import implementations.Maraca
import implementations.StefanBachert
import org.junit.Test

/**
 * User: elijah
 * Date: 09/06/15*/
public class Benchmark {

    @Test
    public void testCoolFormat() {
        benchmarkMethod('Stefan Bachert', StefanBachert.&myFormat)
        benchmarkMethod('Eduardo Aviles', EduardoAviles.&format)
        benchmarkMethod('maraca', Maraca.&convert)
        benchmarkMethod('esaounkine', Esaounkine.&coolFormat)
        benchmarkMethod('assylias', Assylias.&format)
        benchmarkMethod('jhurtado', Jhurtado.&formatValue)
        benchmarkMethod('jzd', Jzd.&format)
    }
    
    static def benchmarkMethod(String author, Closure formattingClosure) {

        long start = System.currentTimeMillis()

        1000000.times {
            [7, 1000, 5821, 10500, 101800, 2000000, 7800000, 92150000, 123200000, 9999999].each {
                formattingClosure(it)
            }
        }

        System.out.println("$author: ${(System.currentTimeMillis() - start) / 1000} seconds")
    }

}
