import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest
{
    @Test
    public void DataTerceiraEraTesteComAnoNBissexto(){
        DataTerceiraEra anoBissexto = new DataTerceiraEra(1,2,2016);
        anoBissexto.ehBissexto();
        assertTrue(anoBissexto.ehBissexto());
    }
    @Test
    public void DataTerceiraEraTesteComMilENovessentos(){
        DataTerceiraEra anoBissexto = new DataTerceiraEra(1,2,1900);
        anoBissexto.ehBissexto();
        assertFalse(anoBissexto.ehBissexto());
    }
    @Test
    public void DataTerceiraEraTesteComAnoBissexto(){
        DataTerceiraEra anoBissexto = new DataTerceiraEra(1,2,2014);
        anoBissexto.ehBissexto();
        assertFalse(anoBissexto.ehBissexto());
    }
    @Test
    public void DataTerceiraEraTesteComOutroAnoNBissexto(){
        DataTerceiraEra anoBissexto = new DataTerceiraEra(1,2,3019);
        anoBissexto.ehBissexto();
        assertFalse(anoBissexto.ehBissexto());
    }
    
}
