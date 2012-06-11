import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;


public class SolrMasterArtistMapper {

	public List<SolrMasterArtist> Map(SolrDocumentList results) 
	{
		
		
		List<SolrMasterArtist> result = new ArrayList<SolrMasterArtist>();
		
		for(Iterator<SolrDocument> resultIterator = results.iterator(); resultIterator.hasNext(); ) {
			
			
			SolrDocument nextSolrDoc = resultIterator.next();
			SolrMasterArtist tempToAdd = new SolrMasterArtist();
			tempToAdd.id = (String) nextSolrDoc.getFieldValue("id");
			tempToAdd.masterArtistName = (String) nextSolrDoc.getFieldValue("masterArtistName");
			tempToAdd.masterArtistId = (Integer) nextSolrDoc.getFieldValue("masterArtistId");
			tempToAdd.masterArtistSortName = (String) nextSolrDoc.getFieldValue("masterArtistSortName");
			tempToAdd.masterArtistUrl = (String) nextSolrDoc.getFieldValue("masterArtistUrl");
			result.add(tempToAdd);
			
			
		}
		
		
		return result;
	}
}
