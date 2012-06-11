
import junit.framework.TestCase;
import org.junit.Assert;

public class SolrTests extends TestCase{

	public void test_basic()
	{
		Assert.assertEquals(1,1);
	}
	
	public void test_GetDocFromSolrService_UnitTest()
	{
		SolrService solrService = new SolrService();
		String searchString = "pink floyd";
		SolrMasterArtist solrmasterArtist = solrService.searchMasterArtist(searchString);
		Assert.assertNotNull(solrmasterArtist);
	}
	
	public void test_GetDocFromSolrService_AcceptanceTest()
	{
		SolrService solrService = new SolrService();
		String searchString = "pink floyd";
		SolrMasterArtist solrmasterArtist = solrService.searchMasterArtist(searchString);
		Assert.assertEquals("ma_34_447", solrmasterArtist.id);
	}
}
