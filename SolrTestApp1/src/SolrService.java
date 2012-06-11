import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.commons.httpclient.HttpClient;
import org.apache.solr.client.solrj.SolrQuery;

public class SolrService 
{
	String requestHandlerName = "standard";
	String solrMasterArtistUrl = "http://slave-solr-systest.7digital.systest:8080/solr/masterartist/";
	
	public SolrMasterArtist searchMasterArtist(String searchString) 
	{
		SolrMasterArtist solrMasterArtist = new SolrMasterArtist ();
		try
		{
			SolrServer solrSvr = new CommonsHttpSolrServer(solrMasterArtistUrl, new HttpClient());
			SolrQuery query = configureQuery(searchString);	
			QueryResponse res = solrSvr.query(query);
			SolrMasterArtistMapper mapper = new SolrMasterArtistMapper();
			solrMasterArtist = mapper.Map(res.getResults()).get(0);	
		}
		catch(Exception ex)
		{
			System.out.print(ex.getMessage());
			ex.printStackTrace();	
		}
		return solrMasterArtist;
	}

	private SolrQuery configureQuery(String searchString) 
	{
		SolrQuery query = new SolrQuery();
		query.setQuery("text:" + searchString);
		query.setQueryType(requestHandlerName);
		return query;
	}

	public List<SolrMasterArtist> searchMasterArtists(String searchString) {
		List<SolrMasterArtist> solrMasterArtists = new ArrayList<SolrMasterArtist>();
		try
		{
			SolrServer solrSvr = new CommonsHttpSolrServer(solrMasterArtistUrl, new HttpClient());
			SolrQuery query = configureQuery(searchString);	
			QueryResponse res = solrSvr.query(query);
			
			SolrMasterArtistMapper mapper = new SolrMasterArtistMapper();
			solrMasterArtists = mapper.Map(res.getResults());	
		}
		catch(Exception ex)
		{
			System.out.print(ex.getMessage());
			ex.printStackTrace();	
		}
		return solrMasterArtists;
	}
}
